package negocio;

public class Advogado {

	private String nome;
	private double honorarios;
	
	public Advogado(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public double getHonorarios() {
		return honorarios;
	}
	
	public void calcularHonorarios(double valor) {
		this.honorarios=valor*5/100;
	}

}
