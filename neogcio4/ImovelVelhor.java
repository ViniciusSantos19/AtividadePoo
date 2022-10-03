package neogcio4;

public class ImovelVelhor extends Imovel{

	public ImovelVelhor(double valorImovel, String lenderecoImovel) {
		super(valorImovel-(valorImovel * 0.2), lenderecoImovel);
		// TODO Auto-generated constructor stub
	}

}
