package modelo;

import java.util.List;

import ConnectDb.DAOpostgres;

public class Agenda {
	private DAOpostgres connection;
	public Agenda() {
		this.connection = new DAOpostgres();
	}
	
	public Jogo AddJogo(Jogo jogo) throws Exception {
		return this.connection.setJogo(jogo);
	}
	
	public Jogo getJogo(int idJogo) throws Exception {
		return this.connection.getJogo(idJogo);
	}
	
	public Jogador addJogador(Jogador jogador) throws Exception {
		return this.connection.setJogador(jogador);
	}
	
	public Jogador getJogador(int idJogador) throws Exception {
		return this.connection.getJogador(idJogador);
	}
	
	public Jogador updatePontos(int idJogador, double pontos) throws Exception {
		return this.connection.UpdatePontosJogador(idJogador, pontos);
	}
	
	public void updateTabuleiro(Jogo jogo, int idJogo) throws Exception {
		this.connection.UpdateJogo(jogo, idJogo);
	}
	
	public void addJogoJogador(int pk_jogo, int pk_jogador)throws Exception {
		this.connection.setJogo_Jogador(pk_jogo, pk_jogador);
	}
	
	public List<String> getIdJogos(Jogador jogador) throws Exception {
		return this.connection.getIdJogoSalvo(jogador);
	}
}
