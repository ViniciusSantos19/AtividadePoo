package ConnectDb;

import java.util.List;

import modelo.Jogador;
import modelo.Jogo;

public interface DAOjogo {
	public Jogo setJogo(Jogo jogo)throws Exception;
	public Jogo getJogo(int idJogo)throws Exception;
	public Jogador setJogador(Jogador jogador)throws Exception;
	public Jogador getJogador(int idJogador)throws Exception;
	public Jogo UpdateJogo(Jogo jogo, int id)throws Exception;
	public Jogador UpdatePontosJogador(Jogador jogador)throws Exception;
	public List<Jogador> getRank()throws Exception;
}
