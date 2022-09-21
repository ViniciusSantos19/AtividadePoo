package negocio;

public abstract class ProjetoDePesquisa {
	
	public ProjetoDePesquisa(){
		
	}
	
	public void inserirPesquisadores(Pesquisador orientador, Pesquisador orientado){
		orientado.getCordenados().add(orientado);
	}
	
	public int quantidadeOrientados(Pesquisador pessoa) {
		return pessoa.getCordenados().size();
	}
	
	public abstract double getValorPago(Pesquisador pessoa);
	
}
