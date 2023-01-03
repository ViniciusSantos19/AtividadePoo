package modelo;

import java.util.Random;

public class Jogo {
	public int tabuleiro[][] = new int[4][4];
	private int array[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,-1};
	private int pontos;
	private int tam = 4;
	
	public Jogo() {
		this.getArrayValido();
		this.iniciaTabuleiro();
	}
	
	public boolean ehVitoria() {
		int contador = 1;
		
		for(int i = 0;  i < this.tam; i++) {
			for(int j = 0; j < this.tam; j++) {
				if(tabuleiro[i][j] != contador && tabuleiro[i][j] != -1) {
					return false;
				}
				contador++;
			}
		}
		return true;
	}
	
	public void reiniciaJogo() {
		this.getArrayValido();
		this.iniciaTabuleiro();
		this.pontos = 0;
	}

	private  boolean ehValido() {
		int qntdReversoe = 0;
		for(int i = 0; i < this.tam * this.tam; i++) {
			for(int j = 0;  j < i; j++) {
				if(array[j] > array[i]) {
					qntdReversoe++;
				}
			}
		}
		return (qntdReversoe % 2) == 0;
	}
	
	public void getArrayValido() {
		do {
			this.embaralhaArray();
		}while(this.ehValido());
	}
	
	private void embaralhaArray() {
		int tamTab = this.tam * this.tam;
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
	public void troca(int linha1, int coluna1, int linha2, int coluna2) {
		int aux = this.tabuleiro[linha1][coluna1];
		this.tabuleiro[linha1][coluna1] = this.tabuleiro[linha2][coluna2];
		this.tabuleiro[linha2][coluna2] = aux;
	}
	
	public void testeOrdenado() {
		int count = 1;
		for(int i = 0; i< tam; i++) {
			for(int j = 0; j < tam; j++) {
				tabuleiro[i][j] = count;
				count++;
			}
			tabuleiro[3][2]=-1;
			tabuleiro[3][3] = 15;
		}
	}
}
