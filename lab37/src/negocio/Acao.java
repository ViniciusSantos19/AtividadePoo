package negocio;

public class Acao extends Heranca {

	public Acao(double valor) {
		super(valor);
	}

	@Override
	protected double calculaImposto() {
		return this.getValor()*17/100;
	}

}
