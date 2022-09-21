import negocio.Pesquisador;
import negocio.ProjetoDePesquisaCordenador;
import negocio.ProjetoDePesquisaProfessor;

public class principal {

	public static void main(String[] args) {
		Pesquisador Manuel = new Pesquisador("Manuel", null);
		Pesquisador Renato = new Pesquisador("Renato", Manuel);
		ProjetoDePesquisaCordenador teste = new ProjetoDePesquisaCordenador(Manuel);
		ProjetoDePesquisaProfessor teste2 = new ProjetoDePesquisaProfessor(Renato);
		teste.inserirPesquisadores(new Pesquisador("nome1", Manuel));
		teste.inserirPesquisadores(new Pesquisador("nome2", Manuel));
		teste.inserirPesquisadores(new Pesquisador("nome3", Manuel));
		System.out.println(teste.getValorPago());
		System.out.println(teste2.getValorPago());

	}

}
