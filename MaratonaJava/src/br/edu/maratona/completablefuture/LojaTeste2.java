package br.edu.maratona.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import br.edu.maratona.completablefuture.classes.Loja;

public class LojaTeste2 
{	public static void main(String[] args) 
	{	List<Loja> lojas = asList(new Loja("Americanas"), 
								  new Loja("Marabras"),
								  new Loja("CEM"),
								  new Loja("Casas Bahia"));
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		findPrices(lojas);
		findPrices2(lojas);
		findPrices3(lojas);
		/*Usando a Thread Factory pois podemos mudar como as Threads 
		 *serão criadas*/
		final Executor executor = Executors.newFixedThreadPool(
				Math.min(lojas.size(), 100), r -> {
					Thread t = new Thread(r);
					/*As Thread daimon não impedem a execução do programa,
					 *a não ser que paremos todas as threads não daemon.*/ 
					t.setDaemon(true);
					return t;
				});
		findPrices4(lojas, executor);
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
	
	private static List<String> findPrices4(List<Loja> lojas, Executor executor)
	{	System.out.println("CompletableFuture Assincrono");
		long start = System.currentTimeMillis();
		
		List<CompletableFuture<String>> colecao = lojas.stream().map(loja -> 
			CompletableFuture.supplyAsync(() -> String.format("%s o preço é: %.2f", 
			loja.getNome(), loja.getPreco()), executor)).collect(Collectors.toList());
		
		List<String> precosFuturos = colecao.stream().map(CompletableFuture::join)
				.collect(Collectors.toList());
		
		System.out.println("Tempo final: " + (System.currentTimeMillis() - start));
		System.out.println(precosFuturos);
		return precosFuturos;
	}
}