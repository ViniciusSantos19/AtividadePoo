package negocio;

public class Testamento {
	
	private Advogado advogado;
	private Herdeiro primeiro;
	private Herdeiro segundo;
	
	public Testamento(Advogado advogado, Herdeiro primeiro, Herdeiro segundo) {
		super();
		this.advogado = advogado;
		this.primeiro = primeiro;
		this.segundo = segundo;
	}
	
	
	public void registrarBem(String herdeiro, Heranca heranca) {
		if(herdeiro.equalsIgnoreCase("primeiro")) {
			primeiro.addHeranca(heranca);
		}else {
			segundo.addHeranca(heranca);
		}
	}
	
	public String getCustoAdvogado() {
		advogado.calcularHonorarios(primeiro.getValorTotal()+segundo.getValorTotal());
		return "O valor gasto com o advogado foi de " +advogado.getHonorarios();
	}
	
	public String getValorBens() {
		return "O valor total dos bens foi de " + (primeiro.getValorTotal()+segundo.getValorTotal());
	}
	
	
	public String getValorImpostos() {
		return "O valor total dos impostos foi de " + (primeiro.getImpostos()+segundo.getImpostos());
	}
	
	public String getRelatorio() {
		
		String resposta="";
		
		resposta+=primeiro.getHerancas()+"\n";
		resposta+=segundo.getHerancas()+"\n";
		resposta+=this.getCustoAdvogado()+"\n";
		resposta+=this.getValorBens()+"\n";
		resposta+="O valor total de  "+ this.primeiro.getNome() +" foi de "+ this.primeiro.getValorTotal()+"\n";
		resposta+="O valor total de  "+ this.segundo.getNome() +" foi de "+ this.segundo.getValorTotal()+"\n";
		resposta+=this.getValorImpostos()+"\n";
		
		return resposta;
	}

}
