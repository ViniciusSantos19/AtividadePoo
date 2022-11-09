package negocio;

import java.util.ArrayList;

public abstract class Forca {
	
	private ArrayList<String> palavras;
	private char letra;
	private int rodada;
	
	public Forca() {
		ArrayList<String> palavras = new ArrayList<String>();
		this.rodada = 5;
	}

	public ArrayList<String> getPalavras() {
		return palavras;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	public int getRodada() {
		return rodada;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}

	public boolean checarPalavra(String palavra) {
		for(int i = 0; i < this.getPalavras().size(); i++) {
				if(this.getPalavras().get(i) == palavra) {
					return true;
				}
		}
		return false;
	}
	
	public boolean checarLetra(char letra, String palavra) {
		if(this.checarPalavra(palavra)) {
			for(int i = 0; i < palavra.length(); i++) {
				if(palavra.charAt(i) == letra) {
					return true;
				}
			}
			this.setRodada(this.getRodada() - 1);
			return false;
		}
		return false;
	}
	
	
	public abstract void adicionarPalavras();
	
}
