package negocio;

public class Aluno {
	private String nome;
	private double prova1;
	private double prova2;
	private double trabalho;
	private double media;

	public Aluno(String nome,  double prova1,  double prova2,  double trabalho) {
		super();
		this.nome = nome;
		this.prova1 = prova1;
		this.prova2 = prova2;
		this.trabalho = trabalho;
	}

	public String getNome() {
		return nome;
	}

	public double getProva1() {
		return prova1;
	}

	public double getProva2() {
		return prova2;
	}

	public double getTrabalho() {
		return trabalho;
	}

	public void setMeida(Double media) {
		this.media = media;
	}
	
	public Double getMedia() {
		return media;
	}
	
}
