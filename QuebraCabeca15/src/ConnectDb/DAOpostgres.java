package ConnectDb;

import java.util.List;

import modelo.Jogador;
import modelo.Jogo;

public class DAOpostgres implements DAOjogo{

	ConnectPostgres conn;
	
	public DAOpostgres() {
		this.conn = new ConnectPostgres();
	}
	
	public Jogo setJogo(Jogo jogo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Jogo getJogo(int idJogo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Jogador setJogador(Jogador jogador) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Jogador setJogador(int idJogador) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Jogador> getRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
