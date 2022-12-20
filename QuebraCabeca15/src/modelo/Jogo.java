package modelo;

import java.util.Random;

public class Jogo {
	public int tabuleiro[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,-1}};
	private int array[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,-1};
	private int pontos;
	private int tam = 4;
	
	public Jogo() {
		this.embaralhaArray();
		this.iniciaTabuleiro();
	}
	
	public boolean ehVitoria() {
		int contador = 1;
		
		for(int i = 0;  i < this.tam; i++) {
			for(int j = 0; j < this.tam; j++) {
				if(tabuleiro[i][j] != contador || tabuleiro[i][j] != -1) {
					return false;
				}
				contador++;
			}
		}
		return true;
	}

	private  void ehValido() {
		
		
		
	}
	
	private void embaralhaArray() {
		int tamTab = this.tam * this.tam -1;
		Random aleatorio = new Random();
		while(tamTab > 1) {
			int num = aleatorio.nextInt(tamTab--);
			int temp =array[tamTab];
			array[tamTab] = array[num];
			array[num] =temp;
		}
	}
	
	private void iniciaTabuleiro(){
		int count = 0;
		for(int i = 0; i < this.tam; i++) {
			for(int j = 0; j < this.tam; j++) {
				this.tabuleiro[i][j] = this.array[count];
				count++;
			}
		}

	}
	public static void main(String[] args) {
		Jogo test = new Jogo();
		for(int i = 0; i < test.tam; i++) {
			for(int j = 0; j < test.tam; j++) {
				System.out.println(test.tabuleiro[i][j]);
			}
		}
	}
}