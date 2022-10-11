package negocio;

public class princpal {

	public static void main(String[] args) {
		
		
		FuncionarioAdministrativo func = new FuncionarioAdministrativo("vini", 7 , 3, 1200.0);
		Professores prof = new Professores("manuel", 7, 3, 1200.0);
		prof.calcularSalario();
		func.calcularSalario();
		Escola escola = new Escola();
		escola.addEmpregados(func);
		escola.addEmpregados(prof);	
		System.out.println(escola.calculaTodosOsSalario());
		System.out.println(escola.getEmpregados().size());
		System.out.println(prof.getSalarioMes());
		System.out.println(func.getSalarioMes());
}
}
