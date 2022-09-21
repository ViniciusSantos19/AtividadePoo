package negocio;

public abstract class ProjetoDePesquisa {
	
	private Pesquisador pessoa;
	
	public ProjetoDePesquisa(Pesquisador pessoa){
		this.pessoa = pessoa;
	}
	
	public void inserirPesquisadores(Pesquisador orientado){
		pessoa.getCordenados().add(orientado);
	}
	
	public int quantidadeOrientados() {
		return this.pessoa.getCordenados().size();
	}
	
	public abstract double getValorPago();

	public Pesquisador getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pesquisador pessoa) {
		this.pessoa = pessoa;
	}
	
}
