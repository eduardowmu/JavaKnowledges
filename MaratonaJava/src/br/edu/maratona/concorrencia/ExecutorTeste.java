package br.edu.maratona.concorrencia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class ThreadTrabalhadoraExecutor implements Runnable
{	private String num;
	
	public ThreadTrabalhadoraExecutor(String num) 
	{this.num = num;}

	@Override public void run() 
	{	System.out.println(Thread.currentThread().getName() 
			+ " iniciou " + num);
		//parada de 3s
		try {Thread.sleep(3000);} 
		catch (InterruptedException e) 
		{System.out.println(e.getMessage());}
		
		System.out.println(Thread.currentThread().getName() 
				+ " finalizou.");
	}
}

public class ExecutorTeste 
{	public static void main(String[] args) 
	{	/*M�todo mais comum utilizado pelo framework Executors
	 	e � constru�do utilizando n�mero de threads que desejamos
	 	executar para a tarefa que passaremos aqui no Runnable*/
		//Executors.newFixedThreadPool(4);
		//System.out.println(Runtime.getRuntime().availableProcessors());
	
		/*Criaremos servi�os de execu��o, ExecutorService que extende
		 *de Executor*/
		//ExecutorService eService = Executors.newFixedThreadPool(4);
		//ExecutorService eService = Executors.newCachedThreadPool();
		ExecutorService eService = Executors.newSingleThreadExecutor();
		/*Al�m do ExecutorService, podemos usar isso*/
		/*
		 * ThreadPoolExecutor tpe = (ThreadPoolExecutor) eService;
		 * tpe.setCorePoolSize(Runtime.getRuntime().availableProcessors());
		 */
		
		eService.execute(new ThreadTrabalhadoraExecutor(String.valueOf(1)));
		eService.execute(new ThreadTrabalhadoraExecutor(String.valueOf(2)));
		eService.execute(new ThreadTrabalhadoraExecutor(String.valueOf(3)));
		eService.execute(new ThreadTrabalhadoraExecutor(String.valueOf(4)));
		eService.execute(new ThreadTrabalhadoraExecutor(String.valueOf(5)));
		eService.execute(new ThreadTrabalhadoraExecutor(String.valueOf(6)));
		/*O problema � que, mesmo que executemos o shutdown, n�o quer dizer
		 *que ir� simplesmente parar, pois isso s� ir� finalizar mesmo depois que
		 *todas as threads pararem.*/
		eService.shutdown();
		//para resolver isso
		while(!eService.isTerminated()) {}
		//a prova disso esta nessa verifica��o.
		System.out.println(eService.isTerminated());
		System.out.println("Finalizado");
	}
}