package modelo;

import java.io.Serializable;

public class Jogador implements Serializable{
	private int idJogador;
	private String nome;
	private double pontos;
	
	public Jogador(int idJogaor, String nome, double pontos) {
		this.idJogador = idJogaor;
		this.nome = nome;
		this.pontos = pontos;
	}

	public double getPontos() {
		return pontos;
	}

	public void setPontos(double pontos) {
		this.pontos = pontos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getIdJogador() {
		return this.idJogador;
	}
}
