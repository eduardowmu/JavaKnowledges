package br.edu.maratona.completablefuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import br.edu.maratona.completablefuture.classes.Loja;

public class LojaTeste 
{	public static void main(String[] args) throws InterruptedException 
	{	Loja americanas = new Loja();
		Loja marabras = new Loja();
		Loja cem = new Loja();
		Loja casasBahia = new Loja();
		
		//início do processo
		long start = System.currentTimeMillis();
		//pegando preços de forma síncrona de cada loja
//		System.out.println("---SÍNCRONA---");
//		System.out.println(americanas.getPreco());
//		System.out.println(marabras.getPreco());
//		System.out.println(cem.getPreco());
//		System.out.println(casasBahia.getPreco());
		
		//imprimindo o tempo de duração
//		System.out.println(System.currentTimeMillis() - start);
		
		System.out.println("---ASSÍNCRONA---");
		Future<Double> preco1 = americanas.getPrecoAsync();
		Future<Double> preco2 = marabras.getPrecoAsync();
		Future<Double> preco3 = cem.getPrecoAsync();
		Future<Double> preco4 = casasBahia.getPrecoAsync();
		//tempo de invocação dos preços
		long tempoFinal = System.currentTimeMillis() - start;
		System.out.println("Tempo invocação: " + tempoFinal);
		//enrolando();
		try 
		{	System.out.println(preco1.get());
			System.out.println(preco2.get());
			System.out.println(preco3.get());
			System.out.println(preco4.get());
		} 
		catch (InterruptedException | ExecutionException e) 
		{System.out.println(e.getMessage());}
		
		System.out.println("Tempo final: " + (System.currentTimeMillis() - start));
	}

	private static void enrolando()
	{	long soma = 0;
		for(int i = 0; i < 1_000_000; i++)	{soma += 1;}
		
		System.out.println(soma);
	}
}