package negocio;

public class Propriedade extends Heranca {

	public Propriedade(double valor) {
		super(valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double calculaImposto() {
		return this.getValor()*1/10;
	}

}
