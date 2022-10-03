package negocio3;

public class Vip extends Ingresso{
	
	public Vip(String nomeShow, Double valor) {
		super(nomeShow, valor);
	}

	@Override
	public void imprimirIngresso() {
		this.setValor(getValor() + 200);
		System.out.println("O valor do ingresso vip é: "+ this.getValor());
	}
	
}
