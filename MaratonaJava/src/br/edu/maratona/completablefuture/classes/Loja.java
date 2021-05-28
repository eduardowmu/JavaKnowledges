package br.edu.maratona.completablefuture.classes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja 
{	public double getPreco() throws InterruptedException
	{return this.calcularPreco();}

	public Future<Double> getPrecoAsync()
	{	CompletableFuture<Double> precoFuturo = new CompletableFuture<>();
		new Thread(() -> {
			try {precoFuturo.complete(calcularPreco());} 
			catch (InterruptedException e) 
			{System.out.println(e.getMessage());}
		}).start();
		return precoFuturo;
	}
	
	private double calcularPreco() throws InterruptedException
	{	this.delay();
		return ThreadLocalRandom.current().nextDouble() * 100;
	}
	private static void delay() throws InterruptedException	
	{TimeUnit.SECONDS.sleep(2);}
}
