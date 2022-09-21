package negocio;

public class ProjetoDePesquisaCordenador extends ProjetoDePesquisa{

	@Override
	public double getValorPago(Pesquisador pessoa) {
		
		double salario = 300 - (pessoa.getCordenados().size() * 0.025 );
		
		return salario;
	}

	

}
