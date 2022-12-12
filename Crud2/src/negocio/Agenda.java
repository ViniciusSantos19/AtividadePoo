package negocio;

import java.util.List;

import connectDb.DAOpostgres;

public class Agenda {
	DAOpostgres connect;
	public Agenda() {
		this.connect = new DAOpostgres();
	}
	
	public Aluno addAluno(Aluno aluno) throws Exception {
		return connect.setAluno(aluno);
	}
	
	public Aluno getAluno(String nome) throws Exception {
		return connect.getAluno(nome);
	}
	
	public Double getMedia(String nome) throws Exception {
		return this.connect.getMedia(nome);
	}
	
	public List<Aluno> getListaAluno() throws Exception{
		return this.connect.resumoAlunos();
	}
	
	public List<Aluno> getListaMedias() throws Exception{
		return this.connect.resumoMedias();
	}
	
	public int deleteAluno(String nome)  throws Exception{
		return this.connect.deleteAluno(nome);
	}
	
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		try {
			agenda.deleteAluno("jorge");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
