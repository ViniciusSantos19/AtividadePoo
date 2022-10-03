package negocio3;

public abstract class Ingresso {
	
	private String nomeShow;
	private Double valor;
	
	public Ingresso(String nomeShow, Double valor) {
		this.nomeShow = nomeShow;
		this.valor = valor;
	}

	public String getNomeShow() {
		return nomeShow;
	}
	
	public void setNomeShow(String nomeShow) {
		this.nomeShow = nomeShow;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public abstract void imprimirIngresso(); 
	
}
