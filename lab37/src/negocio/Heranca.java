package negocio;

public abstract class Heranca {
	
	private double valor;
	private double imposto;
	private double valorLiquido;

	public Heranca(double valor) {
		super();
		this.valor = valor;
		this.imposto=this.calculaImposto();
		this.valorLiquido=this.valor-this.imposto;
	}

	protected abstract double calculaImposto();

	public double getValor() {
		return valor;
	}

	public double getImposto() {
		return imposto;
	}

	public double getValorLiquido() {
		return valorLiquido;
	}
	
	
	

}
