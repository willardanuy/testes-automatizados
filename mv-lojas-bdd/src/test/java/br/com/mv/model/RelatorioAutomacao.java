package br.com.mv.model;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.Sheets.Spreadsheets.Values.Update;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import net.thucydides.core.util.SystemEnvironmentVariables;

public class RelatorioAutomacao {
    /** Application name. */
    private static final String APPLICATION_NAME =
        "Relatorio Automacao";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
        System.getProperty("user.home"), ".credentials/sheets.googleapis.com-java-relatorio-automacao-" + SystemEnvironmentVariables.createEnvironmentVariables().getProperty("mvlojas.gravar.pedido.relatorio.versao"));

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/sheets.googleapis.com-java-quickstart
     */
    private static final List<String> SCOPES =
        Arrays.asList(SheetsScopes.SPREADSHEETS); //_READONLY

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in =
            RelatorioAutomacao.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets =
            GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
            flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Sheets API client service.
     * @return an authorized Sheets API client service
     * @throws IOException
     */
    public static Sheets getSheetsService() throws IOException {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void salvarPedidoRelatorio(String codTeste, String nroPedido) throws IOException {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("d"); // Ex.: Dia "3" ao inves de Dia "03" 
		String data = sdf.format(new Date());
		
        // Build a new authorized API client service.
        Sheets service = getSheetsService();
        
        String spreadsheetId = SystemEnvironmentVariables.createEnvironmentVariables().getProperty("mvlojas.gravar.pedido.planilha");
        String aba = SystemEnvironmentVariables.createEnvironmentVariables().getProperty("mvlojas.gravar.pedido.aba.fixa");
        Boolean abaFixa = Boolean.parseBoolean(aba);
        
        if (!abaFixa) {
        	aba = "Exec" + data;
        }
        
        // ---------------------------------------------
        // Atualiza a data de execução dos testes, célula: C5
        // --------------------------------------------
        
        String rangeData = aba + "!C5";
        
        ValueRange responseData = service.spreadsheets().values()
                .get(spreadsheetId, rangeData)
                .execute();
        
		List<List<Object>> valuesData = responseData.getValues();

		if (valuesData == null || valuesData.size() == 0) {
			System.out.println("No data found.");
		} else {
			
			valuesData.get(0).set(0, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			
			Update request = service.spreadsheets().values()
					.update(spreadsheetId, rangeData, responseData)
					.setValueInputOption("USER_ENTERED");

			request.execute();
		}
        
		// ---------------------------------------------
        // Atualiza o status dos testes e o nro do pedido relacionado
        // --------------------------------------------
		
        String celulas = SystemEnvironmentVariables.createEnvironmentVariables().getProperty("mvlojas.gravar.pedido.intervalo.celulas");
        
        String range = aba + "!" + celulas;
        
        ValueRange response = service.spreadsheets().values()
            .get(spreadsheetId, range)
            .execute();
        
        List<List<Object>> values = response.getValues();
        
        if (values == null || values.size() == 0) {
        	System.out.println("No data found.");
        } else {
        	
			for (List<Object> row : values) {
				String col0 = (String) row.get(0);

				if (col0.equals(codTeste)) {
					row.set(2, "Sucesso");
					row.set(3, nroPedido);
				}
			}
		}
        
		try {
			Update request = service.spreadsheets().values()
					.update(spreadsheetId, range, response)
					.setValueInputOption("USER_ENTERED");

			request.execute();
			
		} catch (GoogleJsonResponseException e) {
			GoogleJsonError error = e.getDetails();
			System.out.println(error);
		}
    }
}