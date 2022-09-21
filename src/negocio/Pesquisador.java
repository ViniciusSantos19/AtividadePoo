package negocio;

import java.util.ArrayList;

public  class Pesquisador {
	private String nome;
	private  Pesquisador cordenador;
	private ArrayList<Pesquisador> cordenados;
	private double salario;
	
	public Pesquisador(String nome, Pesquisador cordenador) {
		this.nome = nome;
		this.cordenador = cordenador;
		this.cordenados = new ArrayList<Pesquisador>();
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pesquisador getCordenador() {
		return cordenador;
	}
	
	public void setCordenador(Pesquisador cordenador) {
		this.cordenador = cordenador;
	}

	public ArrayList<Pesquisador> getCordenados() {
		return cordenados;
	}

	public int quantidadeSubordinados(){
		return this.getCordenados().size();
	}
	
}
