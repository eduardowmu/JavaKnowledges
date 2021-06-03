package br.edu.maratona.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import br.edu.maratona.completablefuture.classes.Loja;

public class LojaTeste2 
{	public static void main(String[] args) 
	{	List<Loja> lojas = asList(new Loja("Americanas"), 
								  new Loja("Marabras"),
								  new Loja("CEM"),
								  new Loja("Casas Bahia"));
	
		findPrices(lojas);
		findPrices2(lojas);
		findPrices3(lojas);
	}

	private static List<String> findPrices(List<Loja> lojas)
	{	//System.out.println("Stream sequencial");
		System.out.println("Stream paralelo");
		long start = System.currentTimeMillis();
//		List<String> colecao = lojas.stream().map(loja -> 
//			String.format("%s o preço é: %.2f", loja.getNome(), loja.getPreco()))
//			.collect(Collectors.toList());
		
		List<String> colecao = lojas.parallelStream().map(loja -> 
			String.format("%s o preço é: %.2f", loja.getNome(), loja.getPreco()))
			.collect(Collectors.toList());
		
		System.out.println("Tempo final: " + (System.currentTimeMillis() - start));
		System.out.println(colecao);
		return colecao;
	}
	
	private static List<String> findPrices2(List<Loja> lojas)
	{	System.out.println("CompletableFuture");
		long start = System.currentTimeMillis();
		
		List<String> colecao = lojas.stream().map(loja -> CompletableFuture.supplyAsync(() -> 
			String.format("%s o preço é: %.2f", loja.getNome(), loja.getPreco())))
			.map(CompletableFuture::join).collect(Collectors.toList());
		
		System.out.println("Tempo final: " + (System.currentTimeMillis() - start));
		System.out.println(colecao);
		return colecao;
	}
	
	private static List<String> findPrices3(List<Loja> lojas)
	{	System.out.println("CompletableFuture Assincrono");
		long start = System.currentTimeMillis();
		
		List<CompletableFuture<String>> colecao = lojas.stream().map(loja -> 
			CompletableFuture.supplyAsync(() -> String.format("%s o preço é: %.2f", 
			loja.getNome(), loja.getPreco()))).collect(Collectors.toList());
		
		List<String> precosFuturos = colecao.stream().map(CompletableFuture::join)
				.collect(Collectors.toList());
		
		System.out.println("Tempo final: " + (System.currentTimeMillis() - start));
		System.out.println(precosFuturos);
		return precosFuturos;
	}
}