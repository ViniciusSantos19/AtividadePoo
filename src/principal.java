import negocio.Pesquisador;
import negocio.ProjetoDePesquisaProfessor;

public class principal {

	public static void main(String[] args) {
		Pesquisador Manuel = new Pesquisador("Manuel", null);
		ProjetoDePesquisaProfessor teste = new ProjetoDePesquisaProfessor(Manuel);
		teste.inserirPesquisadores(new Pesquisador("Vinicius",Manuel));
		teste.inserirPesquisadores(new Pesquisador("Aluno2",Manuel));
		teste.inserirPesquisadores(new Pesquisador("Aluno3",Manuel));
		System.out.println(teste.getValorPago());
	}

}
