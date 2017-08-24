package br.com.mv.model;

public class NotaFiscal {

private int nroTipoNf;
	
	private int nroCupom;
	
	private String codTipoDocto;
	
	private int nroNf;	
	
	private String serieNf;
	
	private int nroLoja;
	
	private int codNroLoja;
	
	private int nroLojaDestino;

	public NotaFiscal(int nroTipoNf, int nroCupom, String codTipoDocto, int nroNf, String serieNf, int nroLoja,
			int nroLojaDestino) {
		this.nroTipoNf = nroTipoNf;
		this.nroCupom = nroCupom;
		this.codTipoDocto = codTipoDocto;
		this.nroNf = nroNf;
		this.serieNf = serieNf;
		this.nroLoja = nroLoja;
		this.nroLojaDestino = nroLojaDestino;
	}

	public NotaFiscal() {}

	public int getNroTipoNf() {
		return nroTipoNf;
	}

	public void setNroTipoNf(int nroTipoNf) {
		this.nroTipoNf = nroTipoNf;
	}

	public int getNroCupom() {
		return nroCupom;
	}

	public void setNroCupom(int nroCupom) {
		this.nroCupom = nroCupom;
	}

	public String getCodTipoDocto() {
		return codTipoDocto;
	}

	public void setCodTipoDocto(String codTipoDocto) {
		this.codTipoDocto = codTipoDocto;
	}

	public int getNroNf() {
		return nroNf;
	}

	public void setNroNf(int nroNf) {
		this.nroNf = nroNf;
	}

	public String getSerieNf() {
		return serieNf;
	}

	public void setSerieNf(String serieNf) {
		this.serieNf = serieNf;
	}

	public int getNroLoja() {
		return nroLoja;
	}

	public void setNroLoja(int nroLoja) {
		this.nroLoja = nroLoja;
	}

	public int getNroLojaDestino() {
		return nroLojaDestino;
	}

	public void setNroLojaDestino(int nroLojaDestino) {
		this.nroLojaDestino = nroLojaDestino;
	}

	public int getCodNroLoja() {
		return codNroLoja;
	}

	public void setCodNroLoja(int codNroLoja) {
		this.codNroLoja = codNroLoja;
	}
	
}

