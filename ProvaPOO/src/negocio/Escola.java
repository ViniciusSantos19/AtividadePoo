package negocio;

import java.util.ArrayList;

public class Escola {
	ArrayList<Funcionario> empregados;
	
	public Escola() {
		this.empregados = new ArrayList<Funcionario>();
	}

	public ArrayList<Funcionario> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(ArrayList<Funcionario> empregados) {
		this.empregados = empregados;
	}

	public Double calculaTodosOsSalario() {
		Double aux = 0.0;
		for(int i = 0; i < this.getEmpregados().size(); i++) {
			aux += this.getEmpregados().get(i).calcularSalario();
		}
		return aux;
	}
	
	public void addEmpregados(Funcionario funcionario) {
		this.getEmpregados().add(funcionario);
	}
	
}
