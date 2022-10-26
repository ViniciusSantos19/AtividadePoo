package negocio;

public class Pontos {
	private int pontosJogador1;
	private int pontosJogador2;
	
	
	
	public int getPontosJogador1() {
		return pontosJogador1;
	}



	public void setPontosJogador1(int pontosJogador1) {
		this.pontosJogador1 = pontosJogador1;
	}



	public int getPontosJogador2() {
		return pontosJogador2;
	}



	public void setPontosJogador2(int pontosJogador2) {
		this.pontosJogador2 = pontosJogador2;
	}



	public Pontos() {
		super();
		this.pontosJogador1 = 0;
		this.pontosJogador2 = 0;
	}
	
}
