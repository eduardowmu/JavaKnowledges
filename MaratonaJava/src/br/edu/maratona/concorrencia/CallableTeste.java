package br.edu.maratona.concorrencia;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
/*Não é recomendável usar os métodos wait(), notify() e
 *notifyAll() quando dentro de metodo run() ou call()
 *quando estivermos utilizando algum tipo de executor,
 *pois não sabemos como é o comportamento da thread de
 *Executor. Portanto é boa pratica evitar usar esses metodos
 *que possam interferir com a execução das threads com Executors.*/
public class CallableTeste implements Callable<String>
{	@Override public String call() throws Exception 
	{	/*a partir do java 7, a diferença deste para o
	 	Math.random é que estamos usando método sincronizado
	 	ou seja, se estivermos em um ambiente concorrente
	 	teremos o problema de adquirir o lock do objeto.
	 	Já com o ThreadLocalRandom não teremos esse problema,
	 	cada thread terá seu número aleatório sendo gerado 
	 	exclusivamente para ela*/
		int count = ThreadLocalRandom.current().nextInt(1, 11);
		for(int i = 0; i < count; i++)
		{	System.out.println(Thread.currentThread().getName() 
				+ " executando...");
		}
		return "Trabalho finalizado o numero aleatorio é " + count;
	}

	public static void main(String[] args)
	{	CallableTeste ct = new CallableTeste();
		ExecutorService eService = Executors.newCachedThreadPool();
		Future<String> resultFuture = eService.submit(ct);
		//isso bloqueia a impressão antes das threads serem executados
		try 
		{	String result = resultFuture.get();
			System.out.println(result);
		} 
		catch (InterruptedException | ExecutionException e) 
		{System.out.println(e.getMessage());}
		eService.shutdown();
	}
}