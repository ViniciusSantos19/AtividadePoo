import java.util.Scanner;

import negocio.Animal;
import negocio.Cachorro;
import negocio.Gato;
import negocio2.Miseravel;
import negocio2.Pobre;
import negocio2.Rica;
import negocio3.CamaroteInferior;
import negocio3.CamaroteSuperior;
import negocio3.Normal;
import neogcio4.ImovelNovo;
import neogcio4.ImovelVelhor;

public class Principal {
	public static void main(String[] args) {
		Scanner digitar = new Scanner(System.in);
		Cachorro teste = new Cachorro("Pretinha", "Vira-Lata");
		Gato teste2 = new Gato("Pangu", "Vira-Lata");
		Pobre vinicius = new Pobre("Vinicius", 20);
		Miseravel mendingo = new Miseravel("Mendingo", 60);
		Rica rico = new Rica("Rico", 40, 1200);
		//teste animal
		System.out.println(teste.anda());
		System.out.println(teste.latir());
		System.out.println(teste2.anda());
		System.out.println(teste2.mia());
		//teste pessoa
		System.out.println(vinicius.trabalha());
		System.out.println(mendingo.mendinga());
		System.out.println(rico.fazCompra());
		//teste ingresso
		
		System.out.println("Digite 1 para compra um ingresso nomral e 2 para um ingresso vip");
		int escolha = digitar.nextInt();
		
		if(escolha == 1) {
			Normal ingresso = new Normal("Show de sertanejo", 80.0);
			System.out.println("Esse ingresso é normal");
			System.out.println(ingresso.getValor());
		}else if(escolha == 2) {
			System.out.println("Vocẽ escolheu um ingresso vip");
			System.out.println("Digite 1 para comprar camarote superior ou depoi para comprar o camarote inferior");
			escolha = digitar.nextInt();
			if(escolha == 1) {
				CamaroteSuperior ingresso = new CamaroteSuperior("Show de sertanejo", 120.0, "Salavor");
				System.out.println("Ingresso para camarote superior");
				System.out.println(ingresso.getValor());
			}else if(escolha == 2) {
				CamaroteInferior ingresso = new CamaroteInferior("Show de sertanejo", 120.0, "Salvador");
				System.out.println("Ingresso para camarote inferior");
				System.out.println(ingresso.getValor());
			}
		}
		System.out.println("digite 1 para comprar um imovel velho ou 2 para comprar um imovel novo");
		escolha = digitar.nextInt();
		if(escolha == 1) {
			System.out.println("Você escolheu um imovel velho");
			ImovelVelhor casa = new ImovelVelhor(1200.0, "Amaralina");
			System.out.println(casa.getValorImovel());
		}else if(escolha == 2) {
			System.out.println("Você escolheu um imovel novo");
			ImovelNovo casa = new ImovelNovo(1200.0, "Amaralina");
			System.out.println(casa.getValorImovel());
		}
		
	}
}
/* */