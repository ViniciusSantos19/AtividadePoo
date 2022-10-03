package negocio3;

public class CamaroteInferior extends Vip{
		
	public CamaroteInferior(String nomeShow, Double valor, String localShow) {
		super(nomeShow, valor);
		this.localShow = localShow;
	}

	private String localShow;

	public String getLocalShow() {
		return localShow;
	}

	public void setLocalShow(String localShow) {
		this.localShow = localShow;
	}
	
	public void imprimirLocal() {
		System.out.println(this.getLocalShow());
	}
	
}
