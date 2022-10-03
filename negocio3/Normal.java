package negocio3;

public class Normal extends Ingresso{
	
	public Normal(String nomeShow, Double valor) {
		super(nomeShow, valor);
	}

	@Override
	public void imprimirIngresso() {
		System.out.println("O valor do ingresso normal é: "+ this.getValor());
	}
	
}
