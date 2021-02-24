package br.edu.maratona.threads;

public class ThreadClassTeste 
{	public static void main(String[] args) 
	{	/*ThreadExemplo t1 = new ThreadExemplo('A');
		ThreadExemplo t2 = new ThreadExemplo('B');
		ThreadExemplo t3 = new ThreadExemplo('C');
		ThreadExemplo t4 = new ThreadExemplo('D');
		*/
		Thread t1 = new Thread(new ThreadExemploRunnable('A'));
		Thread t2 = new Thread(new ThreadExemploRunnable('B'));
		Thread t3 = new Thread(new ThreadExemploRunnable('C'));
		Thread t4 = new Thread(new ThreadExemploRunnable('D'));
		
		/*Método da interface runnable*/
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		//tentando iniciar t1 novamente
		//t1.start();
	}
}

class ThreadExemplo extends Thread
{	private char c;

	public ThreadExemplo(char c) 
	{this.c = c;}
	
	/*Tudo funciona através desse
	 *método. Que quisermos que 
	 *mais de uma coisa aconteça ao
	 *mesmo tempo, devemos inserir
	 *nesse método.*/
	@Override public void run()
	{	/*para sabermos o nome da thread que estamos
	 	executando no momento é chamando da seguinte
	 	maneira logo abaixo*/
		System.out.println(Thread.currentThread().getName());
		for(int i = 0; i < 1000; i++)
		{	System.out.print(c);
			if(i%100 == 0)	{System.out.println();}
		}
	}
}

class ThreadExemploRunnable implements Runnable
{	private char c;

	public ThreadExemploRunnable(char c) 
	{this.c = c;}
	
	@Override public void run() 
	{	System.out.println(Thread.currentThread().getName());
		for(int i = 0; i < 1000; i++)
		{	System.out.print(c);
			if(i%100 == 0)	{System.out.println();}
		}
	}
}