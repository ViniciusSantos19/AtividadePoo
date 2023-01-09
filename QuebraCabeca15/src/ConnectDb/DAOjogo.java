package ConnectDb;

import java.util.List;

import modelo.Jogador;
import modelo.Jogo;

public interface DAOjogo {
	public Jogo setJogo(Jogo jogo)throws Exception;
	public Jogo getJogo(int idJogo)throws Exception;
	public Jogador setJogador(Jogador jogador)throws Exception;
	public Jogador getJogador(int idJogador)throws Exception;
	public void UpdateJogo(Jogo jogo, int id)throws Exception;
	public Jogador UpdatePontosJogador(int idJogador, double pontos)throws Exception;
	public List<Jogador> getRank()throws Exception;
	public void setJogo_Jogador(int pk_jogo, int pk_jogador)throws Exception;
	public List<String> getIdJogoSalvo(Jogador jogador)throws Exception;
	public void deleteJogo(int id)throws Exception;
	public void deleteJogoJogador(int idjogo)throws Exception;
	public void zerarRank()throws Exception;
}
