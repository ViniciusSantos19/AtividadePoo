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
	
	public Jogador getJogador(int idJogador, String nome) throws Exception {
		return this.connection.getJogador(idJogador, nome);
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
	
	public List<Jogador> getRank() throws Exception{
		return this.connection.getRank();
	}
	
	public void deleteJogo(int id) throws Exception {
		this.connection.deleteJogo(id);
	}
	
	public void deleteJogoJogador(int id) throws Exception {
		this.connection.deleteJogoJogador(id);
	}
	
	public void zerarRank() throws Exception {
		this.connection.zerarRank();
	}
}
