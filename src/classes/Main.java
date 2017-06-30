package classes;

import java.util.Vector;

public class Main {

	public static No best = null;
	public static void main(String[] args) {
		// ACACIA É A MINHA ARVORE - EM HOMENAGEM A ARVORE EM FRENTE DE CASA QUE CHAMA ACASSIA
		
		
		Vector<Integer> raiz = new Vector<>();
		for (int i = 0; i < 9; i++) {
			raiz.add(i);
		}
		Valor tabuleiro = new Valor(raiz);
		
		No acacia = new No(tabuleiro, 1);
		best = acacia;
		acacia.gerarFilhos();
		acacia.exibe();
		
		System.out.println("______________________________________________");
		System.out.println("\n\nHeuristica: " + best.valor.calculaEuristica());
		System.out.println("Nivel: " + best._profundidade);
		best.valor.exibe();
		

	}

}
