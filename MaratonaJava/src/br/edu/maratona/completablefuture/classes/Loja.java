package br.edu.maratona.completablefuture.classes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja 
{	private String nome;

	public Loja(){}
	
	public Loja(String nome)	{this.nome = nome;}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public double getPreco()
	{return this.calcularPreco();}

	public Future<Double> getPrecoAsync()  throws InterruptedException
	{	CompletableFuture<Double> precoFuturo = new CompletableFuture<>();
		new Thread(() -> {
			precoFuturo.complete(calcularPreco()); 
		}).start();
		return precoFuturo;
	}
	
	public Future<Double> getPrecoSupplyAsyncTunado()
	{return CompletableFuture.supplyAsync(this::calcularPreco);}
	
	private double calcularPreco()
	{	this.delay();
		//simulando uma exceção
		//System.out.println(1/0);
		return ThreadLocalRandom.current().nextDouble() * 100;
	}
	private static void delay()
	{	try {TimeUnit.SECONDS.sleep(1);} 
		catch (InterruptedException e) {System.out.println(e.getMessage());}
	}
}