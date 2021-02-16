package br.edu.maratona.generics;

import java.util.ArrayList;
import java.util.List;

import br.edu.maratona.generics.classesgenericas.Carro;
import br.edu.maratona.generics.wildcard.Animal;

public class MetodoGenericoTeste 
{	public static void main(String[] args) 
	{criarArray(new Carro("Dudu"));}

	/*Queremos criar um array do tipo T, adicioná-lo
	 *nesse array e imprimir*/
	public static <T extends Carro> void criarArray(T t)
	{	List<T> lista = new ArrayList<>();
		lista.add(t);
		System.out.println(lista);
	}
}