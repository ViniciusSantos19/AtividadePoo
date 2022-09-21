package negocio;

public class ProjetoDePesquisaProfessor extends ProjetoDePesquisa{

	public ProjetoDePesquisaProfessor(Pesquisador pessoa) {
		super(pessoa);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getValorPago() {
		double salario = 220 + (220 + (this.getPessoa().getSalario() * 0.3));
		this.getPessoa().setSalario(salario);
		return salario;
	}

	
	
}
