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
		PreparedStatement ps = this.conn.getConnection().prepareStatement("INSERT INTO JOGO (PK_JOGO, FK_JOGADOR, OBJETO) "+
		"VALUES (?,?,?)");
		ps.setInt(1, jogo.getIdJogo());
		ps.setInt(2, jogo.getIdJogador());
		ps.setBytes(3, converteJogoParaByte(jogo));
		ps.execute();
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
	
	public Jogador UpdatePontosJogador(Jogador jogador)throws Exception {
		PreparedStatement ps = this.conn.getConnection().prepareStatement("UPDATE JOGADOR SET PONTOS = ? WHERE PK_JOGADOR = "+jogador.getIdJogador());
		ps.setDouble(1, jogador.getPontos());
		ps.executeUpdate();
		return jogador;
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
	
	
	
	public static void main(String[] args) {
		DAOpostgres test = new DAOpostgres();
		
		Jogo jogo3 = new Jogo();
		jogo3.setIdJogo(2);
		jogo3.setIdJogador(1);
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.println(jogo3.getTabuleiro()[i][j]);
			}
		}
		System.out.println("/////");
		
		try {
			test.UpdateJogo(jogo3, 1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			jogo3 = test.getJogo(1);
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					System.out.println(jogo3.getTabuleiro()[i][j]);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
