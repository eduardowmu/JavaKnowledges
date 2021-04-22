package br.edu.maratona.concorrencia;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
/*N�o � recomend�vel usar os m�todos wait(), notify() e
 *notifyAll() quando dentro de metodo run() ou call()
 *quando estivermos utilizando algum tipo de executor,
 *pois n�o sabemos como � o comportamento da thread de
 *Executor. Portanto � boa pratica evitar usar esses metodos
 *que possam interferir com a execu��o das threads com Executors.*/
public class CallableTeste implements Callable<String>
{	@Override public String call() throws Exception 
	{	/*a partir do java 7, a diferen�a deste para o
	 	Math.random � que estamos usando m�todo sincronizado
	 	ou seja, se estivermos em um ambiente concorrente
	 	teremos o problema de adquirir o lock do objeto.
	 	J� com o ThreadLocalRandom n�o teremos esse problema,
	 	cada thread ter� seu n�mero aleat�rio sendo gerado 
	 	exclusivamente para ela*/
		int count = ThreadLocalRandom.current().nextInt(1, 11);
		for(int i = 0; i < count; i++)
		{	System.out.println(Thread.currentThread().getName() 
				+ " executando...");
		}
		return "Trabalho finalizado o numero aleatorio � " + count;
	}

	public static void main(String[] args)
	{	CallableTeste ct = new CallableTeste();
		ExecutorService eService = Executors.newCachedThreadPool();
		Future<String> resultFuture = eService.submit(ct);
		//isso bloqueia a impress�o antes das threads serem executados
		try 
		{	String result = resultFuture.get();
			System.out.println(result);
		} 
		catch (InterruptedException | ExecutionException e) 
		{System.out.println(e.getMessage());}
		eService.shutdown();
	}
}