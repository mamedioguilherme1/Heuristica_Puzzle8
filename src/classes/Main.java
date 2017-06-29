package classes;

import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vector<Integer> raiz = new Vector<>();
		for (int i = 0; i < 9; i++) {
			raiz.add(i);
		}
		Valor tabuleiro = new Valor(raiz);
		
		No acassia = new No(tabuleiro, 1);
		
		acassia.gerarFilhos();
		acassia.exibe();

	}

}
