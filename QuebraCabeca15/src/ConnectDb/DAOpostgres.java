package ConnectDb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Jogador;
import modelo.Jogo;

public class DAOpostgres implements DAOjogo{

	private ConnectPostgres conn;
	
	public DAOpostgres() {
		this.conn = new ConnectPostgres();
	}
	
	public Jogo setJogo(Jogo jogo) throws Exception {
		PreparedStatement ps = this.conn.getConnection().prepareStatement("INSERT INTO JOGO (OBJETO) "+
		"VALUES (?)",Statement.RETURN_GENERATED_KEYS);
		//ps.setInt(1, jogo.getIdJogo());
		ps.setBytes(1, converteJogoParaByte(jogo));
		ps.execute();
		ResultSet num = ps.getGeneratedKeys();
		if(num.next()) {
			jogo.setIdJogo(num.getInt(1));
			return jogo;
		}
		return jogo;
	}
	
	

	public Jogo getJogo(int idJogo) throws Exception {
		String select = "SELECT  OBJETO FROM JOGO AS J WHERE PK_JOGO ="+"'"+idJogo+"'";
		Statement stmt = this.conn.getConnection().createStatement();
		ResultSet rSet = stmt.executeQuery(select);
		rSet.next();
		return converterByteParaJogo(rSet.getBytes(1));
	}
	
	public Jogo UpdateJogo(Jogo jogo, int id) throws Exception {
		PreparedStatement ps = this.conn.getConnection().prepareStatement("UPDATE JOGO SET OBJETO = ? WHERE PK_JOGO = "+id);
		ps.setBytes(1, converteJogoParaByte(jogo));
		ps.executeUpdate();
		return jogo;
	}

	public Jogador setJogador(Jogador jogador) throws Exception {
		PreparedStatement ps = this.conn.getConnection().prepareStatement("INSERT INTO JOGADOR (PK_JOGADOR, NOME, PONTOS) VALUES (?, ?, ?)");
		ps.setInt(1, jogador.getIdJogador());
		ps.setString(2, jogador.getNome());
		ps.setDouble(3, jogador.getPontos());
		ps.execute();
		return jogador;
	}

	public Jogador getJogador(int idJogador) throws Exception {
		String select = "SELECT  PK_JOGADOR, NOME, PONTOS FROM JOGADOR AS J WHERE PK_JOGADOR ="+"'"+idJogador+"'";
		Statement stmt = this.conn.getConnection().createStatement();
		ResultSet rSet = stmt.executeQuery(select);
		Jogador jogador = null;
		if(rSet.next()) {
			jogador = new Jogador(rSet.getInt("PK_JOGADOR"),rSet.getString("NOME"), rSet.getDouble("PONTOS"));
		}
		return jogador;
	}

	public List<Jogador> getRank() throws Exception {
		String select = "SELECT (NOME, PONTOS, PK_JOGADOR) FROM JOGADOR AS J ORDER BY J.PONTOS";
		Statement stmt = this.conn.getConnection().createStatement();
		ResultSet rSet = stmt.executeQuery(select);
		List<Jogador> lista = new  ArrayList<Jogador>();
		while(rSet.next()) {
			Jogador jogador = new Jogador(rSet.getInt("PK_JOGADOR"),rSet.getString("NOME"), rSet.getDouble("PONTOS"));
			lista.add(jogador);
		}
		return lista;
		
	}
	
	public Jogador UpdatePontosJogador(int idJogador, double pontos)throws Exception {
		PreparedStatement ps = this.conn.getConnection().prepareStatement("UPDATE JOGADOR SET PONTOS = ? WHERE PK_JOGADOR = "+idJogador);
		ps.setDouble(1, pontos);
		ps.executeUpdate();
		return null;
	}
	
	private static Jogo converterByteParaJogo(byte[] jogoByte) {
		try {
		      ByteArrayInputStream bao = new ByteArrayInputStream(jogoByte);
		      ObjectInputStream ous;
		      ous = new ObjectInputStream(bao);
		      return (Jogo) ous.readObject();
		    } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } catch (ClassNotFoundException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		return null;
	}
	
	
	
	private static byte[] converteJogoParaByte(Jogo jogo) {
		try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream ous;
            ous = new ObjectOutputStream(bao);
            ous.writeObject(jogo);
            return bao.toByteArray();
     } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
     }

     return null;
	}
	
	public void setJogo_Jogador(int pk_jogo, int pk_jogador)throws Exception {
		PreparedStatement ps = this.conn.getConnection().prepareStatement("INSERT INTO JOGO_JOGADOR (FK_JOGO, FK_JOGADOR) VALUES(?, ?)");
		ps.setInt(1, pk_jogo);
		ps.setInt(2, pk_jogador);
		ps.execute();
	}
	
	
	public List<String> getIdJogoSalvo(Jogador jogador) throws Exception {
		String select = "select fk_jogo from jogo_jogador as jj inner join jogo as j on(j.pk_jogo = jj.fk_jogo)\n"
				+ "inner join jogador as ja on (ja.pk_jogador = jj.fk_jogador) where ja.pk_jogador ="+jogador.getIdJogador();
		Statement stmt = this.conn.getConnection().createStatement();
		ResultSet rSet = stmt.executeQuery(select);
		List<String> lista = new ArrayList<String>();
		while(rSet.next()) {
			int num = rSet.getInt(1);
			lista.add(Integer.toString(num));
		}
		return lista;
	}
	
	public static void main(String[] args) {
		DAOpostgres test = new DAOpostgres();
		Jogo jogo = null;
		try {
			jogo = test.getJogo(21);
			;
			for(int i = 0; i < 4; i++) {
				for(int j = 0;  j < 4; j++) {
					System.out.println(jogo.getTabuleiro()[i][j]);
				}
			}
			System.out.println("______________");
			//jogo.troca(3, 3, 2, 1);
			jogo  = test.UpdateJogo(jogo, 21);
			for(int i = 0; i < 4; i++) {
				for(int j = 0;  j < 4; j++) {
					System.out.println(jogo.getTabuleiro()[i][j]);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
