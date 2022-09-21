package negocio;

public class ProjetoDePesquisaProfessor extends ProjetoDePesquisa{

	@Override
	public double getValorPago(Pesquisador pessoa) {
		double salario = 220 + (pessoa.getCordenador().getSalario() * 0.3);
		return salario;
	}

	
	
}
