package classes;

import java.util.Vector;

public class Valor {
	public Vector<Integer> valor;
	public static int profundidade = 0;
	
	public Valor(Vector<Integer> v){
		valor = (v);
	}
	
	public void exibir(){
		for(int i = 0; i < valor.size(); i++)
			System.out.println(valor.get(i));
	}
	
	public void cima()
	{
		int zero = this.valor.indexOf(0);
		zero -= 3;
		if (zero >= 0){
			Integer value = this.valor.get(zero+3);
			this.valor.set(zero + 3, this.valor.get(zero));
			this.valor.set(zero, value);
		}
	}
	public void baixo()
	{
		int zero = this.valor.indexOf(0);
		zero += 3;
		if (zero <= 8){
			Integer value = this.valor.get(zero - 3);
			this.valor.set(zero - 3, this.valor.get(zero));
			this.valor.set(zero, value);
		}
	}
	public void direita()
	{
		int zero = this.valor.indexOf(0);
		
		if ((zero != 2 && zero != 5 && zero != 8))
		{
			zero += 1;
			Integer value = this.valor.get(zero - 1);
			this.valor.set(zero - 1, this.valor.get(zero));
			this.valor.set(zero, value);
		}
	}
	public void esquerda()
	{
		int zero = this.valor.indexOf(0);
		
		if ((zero != 0 && zero != 3 && zero != 6))
		{
			zero -= 1;
			Integer value = this.valor.get(zero + 1);
			this.valor.set(zero + 1, this.valor.get(zero));
			this.valor.set(zero, value);
		}
		
	}
	
	public void exibe()
	{
		if(valor != null)
		{
			for(int i = 0; i < 9; i++)
			{
				System.out.print("_" + valor.get(i) + "_");
				if((i+1) % 3 == 0 )
					System.out.println();
				
			}
		}
	}
	
	public float calculaEuristica()
	{
		int cont = 0;
		for (int i = 0; i < valor.size(); i++) {
			if(valor.get(i) == (i+1))
			{
				cont++;
			}
		}
		
		return (100 * cont) / 8;
	}
	
	
	
}
