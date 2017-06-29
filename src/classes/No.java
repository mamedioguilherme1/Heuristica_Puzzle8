package classes;

import java.util.ArrayList;
import java.util.Vector;

public class No {
	
	public ArrayList<No> filho = new ArrayList<>();
	public static int profundidade = 0;
	public Valor valor;
	public int _profundidade = 0;
	
	public No() {
		
	}
	
	public No(Valor valo, int prof) {
		this.valor = valo;
		this._profundidade = prof;
	}
	
	@SuppressWarnings("unchecked")
	public void gerarFilhos()
	{
		Valor tabuleiro = new Valor((Vector<Integer>) this.valor.valor.clone());
		tabuleiro.cima();
		if(!tabuleiro.valor.equals(this.valor.valor))
			this.filho.add(new No(tabuleiro, this._profundidade+1));
		
		tabuleiro = new Valor((Vector<Integer>) this.valor.valor.clone());
		tabuleiro.baixo();
		if(!tabuleiro.valor.equals(this.valor.valor))
			this.filho.add(new No(tabuleiro, this._profundidade+1));
		
		tabuleiro = new Valor((Vector<Integer>) this.valor.valor.clone());
		tabuleiro.esquerda();
		if(!tabuleiro.valor.equals(this.valor.valor))
			this.filho.add(new No(tabuleiro, this._profundidade+1));
		
		tabuleiro = new Valor((Vector<Integer>) this.valor.valor.clone());
		tabuleiro.direita();
		if(!tabuleiro.valor.equals(this.valor.valor))
			this.filho.add(new No(tabuleiro, this._profundidade+1));
		
		
		if((this._profundidade + 1) < 5)
		{
			for (int i = 0; i < filho.size(); i++) {
				filho.get(i).gerarFilhos();
			}
		}
	}
	
	public void exibe()
	{
		if(valor != null)
		{
			System.out.println(this._profundidade);
			this.valor.exibe();
			for(int i = 0; i < filho.size(); i++)
			{
				filho.get(i).exibe();
			}
		}
	}
	
	
}
