package classes;

import java.util.ArrayList;
import java.util.Vector;

public class No {
	
	public ArrayList<No> filho = new ArrayList<>();
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

		this.organizar();
	
		if(Main.best.valor.calculaEuristica() < this.filho.get(0).valor.calculaEuristica())
			Main.best = this.filho.get(0);
		
		if((this._profundidade + 1) < 10)
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
			System.out.println("__________________________________________");
			System.out.println("NIVEL: " + this._profundidade);
			System.out.println("HEURISTICA: " + this.valor.calculaEuristica() + "%");
			this.valor.exibe();
			for(int i = 0; i < filho.size(); i++)
			{
				filho.get(i).exibe();
						
			}
		}
	}
	
	public void organizar()
	{
		No filhos_;
		for (int i = 0; i < this.filho.size(); i++) 
		{
			for (int j = (i + 1); j < this.filho.size(); j++) 
			{
				if(filho.get(i).valor.calculaEuristica() < filho.get(j).valor.calculaEuristica())
				{
					filhos_ = filho.get(i);
					filho.set(i, filho.get(j));
					filho.set(j, filhos_);
					
				}
			}
		}
		
	}
	
}
