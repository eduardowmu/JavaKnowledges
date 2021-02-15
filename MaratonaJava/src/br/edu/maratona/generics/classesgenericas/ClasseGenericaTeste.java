package br.edu.maratona.generics.classesgenericas;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTeste 
{	public static void main(String[] args) 
	{	List<Carro> carrosDisponiveis = new ArrayList<>();
		
		carrosDisponiveis.add(new Carro("GOL"));
		carrosDisponiveis.add(new Carro("BMW"));
		ObjetosAlugaveis<Carro> carroAlugavel = new 
				ObjetosAlugaveis<>(carrosDisponiveis);
		
		Carro carro = carroAlugavel.getObjetoDipsonivel();
		System.out.println("Usando o carro por um mês");
		carroAlugavel.devolverObjeto(carro);
	}
}

/*Essa notação "T" significa que iremos passar um tipo
 *para essa classe. Essa letra significa TYPE = tipo.
 *Quando estamos trabalhando com coleções, como uma lista
 *utilizamos a letra "E" de elemento. Fora das coleções iremos
 *usar um "T". Onde tiver essa letra, no caso abaixo iremos trocar
 *por um outro nome. Onde tiver Carro, iremos substituir por T, ou seja
 *o tipo que será passado.*/
class ObjetosAlugaveis<T>
{	private List<T> objDisponiveis = new ArrayList<>();
	
	public ObjetosAlugaveis(List<T> objDisponiveis)
	{this.objDisponiveis = objDisponiveis;}
	
	public T getObjetoDipsonivel()
	{	T t = this.objDisponiveis.remove(0);
		System.out.println("Alugando objeto: " + t);
		System.out.println("Carros disponíveis " + this.objDisponiveis);
		return t;
	}
	
	public void devolverObjeto(T t)
	{	System.out.println("Devolvendo objeto " + t);
		this.objDisponiveis.add(t);
		System.out.println("Objetos disponíveis " + this.objDisponiveis); 
	}
}