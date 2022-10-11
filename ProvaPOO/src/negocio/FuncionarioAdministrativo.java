package negocio;

public class FuncionarioAdministrativo extends Funcionario{

	

	public FuncionarioAdministrativo(String nome, int horasExtrasTrabalhadas, int diasQueFaltou, Double salarioBase) {
		super(nome, horasExtrasTrabalhadas, diasQueFaltou, salarioBase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double calcularSalario() {
		
		int diasTrabalhados = 30 - this.getDiasQueFaltou();
		Double horasTrabalhadas = diasTrabalhados * 8.0;
		Double salarioHora = this.getSalarioBase() / (30 * 8);
		Double aux = 0.0;
		
		for(int i = 0; i < diasTrabalhados; i++) {
			aux =  salarioHora * horasTrabalhadas;
		}
		
		if(this.getHorasExtrasTrabalhadas() > 0) {
			Double aux2 = 0.0;
			Double horaExtra = salarioHora * 1.5;
			for(int i = 0;  i < this.getHorasExtrasTrabalhadas(); i++) {
				aux2 = horaExtra * this.getHorasExtrasTrabalhadas();
			}
			aux = aux2 + aux;
			this.setSalarioMes(aux);
			return this.getSalarioMes();
		}
		
		
		return aux;
	}

}
