package br.edu.maratona.completablefuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTeste 
{	private static ExecutorService executorService = 
		Executors.newFixedThreadPool(1);
	
	public static void main(String[] args) 
	{	/*Criando um Future, especificando o tipo de resultado que esperamos
	 	dele, vamos primeiro fazer a moda antiga para depois ver no java 8*/
		Future<Double> future = executorService.submit(new Callable<Double>() 
		{	@Override public Double call() throws Exception 
			{	//pausa pos 2 segundos
				TimeUnit.SECONDS.sleep(2);
				return 2000D;
			}
		});
		
		enrolando();
		try 
		{	Double futureDoubleResult = future.get(3, TimeUnit.SECONDS);
			System.out.println(futureDoubleResult);
		} 
		
		catch (InterruptedException | ExecutionException | TimeoutException e) 
		{e.printStackTrace();}
		
		finally	{executorService.shutdown();}
	}
	
	private static void enrolando()
	{	long soma = 0;
		for(int i = 0; i < 1_000_000; i++)	{soma += 1;}
		
		System.out.println(soma);
	}
}