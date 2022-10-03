package negocio3;

public class CamaroteSuperior extends Vip{

	private String localShow;
	
	public CamaroteSuperior(String nomeShow, Double valor, String localShow) {
		super(nomeShow, valor+200);
		this.localShow = localShow;
	}

	public String getLocalShow() {
		return localShow;
	}

	public void setLocalShow(String localShow) {
		this.localShow = localShow;
	}
	
	public Double retornaValor() {
		return this.getValor();
	}
	
}
