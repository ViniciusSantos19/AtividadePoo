package connectDb;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import negocio.Aluno;

public class DAOpostgres implements DAOaluno{

	private ConnectPostgres conn;
	
	public DAOpostgres () {
		this.conn = new ConnectPostgres();
	}

	@Override
	public Aluno setAluno(Aluno aluno) throws Exception {
		String insert = "INSERT INTO ALUNOS (NOME, PROVA1, PROVA2, TRABALHO) VALUES ('"+aluno.getNome()+"'"+", "+
	aluno.getProva1()+", "+aluno.getProva2()+", "+aluno.getTrabalho()+" )";
		Statement stmt = this.conn.getConnection().createStatement();
		stmt.executeUpdate(insert);
		return aluno;
	}

	@Override
	public Aluno getAluno(String aluno) throws Exception {
		String select = "SELECT * FROM ALUNOS AS A WHERE NOME ="+"'"+aluno+"'";
		Statement stmt = this.conn.getConnection().createStatement();
		ResultSet rSet = stmt.executeQuery(select);
		Aluno alun = null;
		if(rSet.next()) {
			alun = new Aluno(rSet.getString("NOME"),rSet.getDouble("PROVA1"),rSet.getDouble("PROVA2"),rSet.getDouble("TRABALHO"));
		}
		return alun;
	}

	@Override
	public Double getMedia(String aluno) throws Exception {
		String select = "SELECT  (PROVA1 + PROVA2 + TRABALHO)/3 AS M FROM ALUNOS AS A WHERE NOME = '"+aluno+"'";
		Statement stmt = this.conn.getConnection().createStatement();
		ResultSet rSet = stmt.executeQuery(select);
		double media= 0;
		if(rSet.next()) {
			media = rSet.getDouble("M");
		}
		return media;
	}

	@Override
	public List<Aluno> resumoMedias() throws Exception {
		String select = "SELECT  (PROVA1 + PROVA2 + TRABALHO)/3 AS M, NOME FROM ALUNOS AS A ORDER BY NOME";
		Statement stmt = this.conn.getConnection().createStatement();
		ResultSet rSet = stmt.executeQuery(select);
		List<Aluno> lista = new  ArrayList<Aluno>();
		while(rSet.next()) {
			Aluno aluno = new Aluno(rSet.getString("NOME"),0,0,0);
			aluno.setMeida(rSet.getDouble("M"));
			lista.add(aluno);
		}
		if(lista.size() == 0) {
			return null;
		}
		return lista;
	}

	@Override
	public List<Aluno> resumoAlunos() throws Exception {
		String select = "SELECT * FROM ALUNOS ORDER BY NOME";
		Statement stmt = this.conn.getConnection().createStatement();
		ResultSet rSet = stmt.executeQuery(select);
		List<Aluno> lista = new  ArrayList<Aluno>();
		while(rSet.next()) {
			Aluno aluno = new Aluno(rSet.getString("NOME"), rSet.getDouble("PROVA1"), rSet.getDouble("PROVA2"),
					rSet.getDouble("TRABALHO"));
			lista.add(aluno);
		}
		if(lista.size() == 0) {
			return null;
		}
		return lista;
	}

	@Override
	public int deleteAluno(String nome) throws Exception {
		String delete = "DELETE FROM ALUNOS WHERE NOME ='"+nome+"'";
		Statement stmt = this.conn.getConnection().createStatement();
		stmt.executeUpdate(delete);
		return 1;
	}
	
	

}
