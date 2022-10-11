package negocio;

public abstract class Funcionario {

	private String nome;
	private int horasExtrasTrabalhadas;
	private int diasQueFaltou;
	private Double salarioBase;
	private Double salarioMes;
	
	public Funcionario(String nome, int horasExtrasTrabalhadas, int diasQueFaltou, Double salarioBase) {
		this.nome = nome;
		this.horasExtrasTrabalhadas = horasExtrasTrabalhadas;
		this.diasQueFaltou = diasQueFaltou;
		this.salarioBase = salarioBase;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getHorasExtrasTrabalhadas() {
		return horasExtrasTrabalhadas;
	}
	
	public void setHorasExtrasTrabalhadas(int horasExtrasTrabalhadas) {
		this.horasExtrasTrabalhadas = horasExtrasTrabalhadas;
	}
	
	public int getDiasQueFaltou() {
		return diasQueFaltou;
	}
	
	public void setDiasQueFaltou(int diasQueFaltou) {
		this.diasQueFaltou = diasQueFaltou;
	}
	
	public Double getSalarioBase() {
		return salarioBase;
	}
	
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	
	
	public Double getSalarioMes() {
		return salarioMes;
	}

	public void setSalarioMes(Double salarioMes) {
		this.salarioMes = salarioMes;
	}

	public abstract Double calcularSalario();
	
	
	
}
