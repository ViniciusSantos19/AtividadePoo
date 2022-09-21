import negocio.Pesquisador;
import negocio.ProjetoDePesquisaCordenador;
import negocio.ProjetoDePesquisaProfessor;

public class principal {

	public static void main(String[] args) {
		Pesquisador Manuel = new Pesquisador("Manuel", null);
		ProjetoDePesquisaCordenador teste = new ProjetoDePesquisaCordenador(Manuel);
		teste.inserirPesquisadores(new Pesquisador("nome1", Manuel));
		teste.inserirPesquisadores(new Pesquisador("nome2", Manuel));
		teste.inserirPesquisadores(new Pesquisador("nome3", Manuel));
		System.out.println(teste.getValorPago());

	}

}
