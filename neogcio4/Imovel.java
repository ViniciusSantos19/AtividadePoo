package neogcio4;

public class Imovel {
	
	private double valorImovel;
	private String lenderecoImovel;
	
	public Imovel(double valorImovel, String lenderecoImovel) {
		super();
		this.valorImovel = valorImovel;
		this.lenderecoImovel = lenderecoImovel;
	}

	public double getValorImovel() {
		return valorImovel;
	}
	
	public void setValorImovel(double valorImovel) {
		this.valorImovel = valorImovel;
	}
	
	public String getLenderecoImovel() {
		return lenderecoImovel;
	}
	
	public void setLenderecoImovel(String lenderecoImovel) {
		this.lenderecoImovel = lenderecoImovel;
	}
	
}
