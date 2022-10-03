package negocio2;

public class Rica extends Pessoa {

	private Double dinheiro;

	public Rica(String nome, int idade, double dinheiro) {
		super(nome, idade);
		this.dinheiro = dinheiro;
		// TODO Auto-generated constructor stub
	}

	public Double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(Double dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public String fazCompra() {
		return "Fez compras";
	}

}
