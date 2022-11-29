package negocio;

import java.util.ArrayList;
import java.util.List;

public class Herdeiro {
	
	private String nome;
	private List<Heranca> lista;
	
	public Herdeiro(String nome) {
		super();
		this.nome = nome;
		this.lista= new ArrayList<Heranca>();
	}
	
	public void addHeranca(Heranca heranca) {
		this.lista.add(heranca);
		
	}
	
	
	
	public String getNome() {
		return nome;
	}

	public String getHerancas() {
		int acoes=0;
		int propriedades=0;
		
		for (Heranca heranca : lista) {
			if(heranca instanceof Acao) {
				acoes++;
			}else {
				propriedades++;
			}
		}
		return this.nome + "tem " + acoes+ " acoes e "+ propriedades + " propriedades";
	}
	
	public double getValorTotal() {
		return this.lista.stream().mapToDouble(Heranca::getValor).sum();
	}
	
	public double getImpostos() {
		return this.lista.stream().mapToDouble(Heranca::getImposto).sum();
	}

}
