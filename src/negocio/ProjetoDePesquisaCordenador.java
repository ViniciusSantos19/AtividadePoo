package negocio;

public class ProjetoDePesquisaCordenador extends ProjetoDePesquisa{

	public ProjetoDePesquisaCordenador(Pesquisador pessoa) {
		super(pessoa);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getValorPago() {
		double salario = 300 -(300 *  (this.getPessoa().getCordenados().size() * 0.025 ));
		this.getPessoa().setSalario(salario);
		return salario;
	}

	

}
