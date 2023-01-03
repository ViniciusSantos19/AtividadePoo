package modelo;

public class Jogador {
	private String nome;
	public Jogo jogo;
	private double pontos;
	private int rank;
	
	
	
	public Jogo getTabuleiro() {
		return jogo;
	}

	public void setTabuleiro(int[][] Copiatabuleiro) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				jogo.tabuleiro[i][j] = Copiatabuleiro[i][j];
			}
		}
	}

	public double getPontos() {
		return pontos;
	}

	public void setPontos(double pontos) {
		this.pontos = pontos;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	private String getNome() {
		return this.nome;
	}
}