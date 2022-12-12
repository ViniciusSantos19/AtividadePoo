package connectDb;

import java.util.List;

import negocio.Aluno;

public interface DAOaluno {
	public Aluno setAluno(Aluno aluno)throws Exception;
	public Aluno getAluno(String aluno)throws Exception;
	public Double getMedia(String aluno)throws Exception;
	public List<Aluno> resumoMedias()throws Exception;
	public List<Aluno> resumoAlunos()throws Exception;
	public int deleteAluno(String nome)throws Exception;
}
