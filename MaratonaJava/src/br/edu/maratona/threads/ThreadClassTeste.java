package br.edu.maratona.threads;

import javax.swing.JOptionPane;

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
		
		/*como boas pr�tica, sempre usar o atributo
		 *est�tico*/
		t4.setPriority(Thread.MAX_PRIORITY);
		/*M�todo da interface runnable*/
		t1.start();
		try {t1.join();}
		catch (InterruptedException e) 
		{JOptionPane.showMessageDialog(null, e);}
		t2.start();
		/*
		 * t3.start(); t4.start();
		 */
		//tentando iniciar t1 novamente
		//t1.start();
	}
}

class ThreadExemplo extends Thread
{	private char c;

	public ThreadExemplo(char c) 
	{this.c = c;}
	
	/*Tudo funciona atrav�s desse
	 *m�todo. Que quisermos que 
	 *mais de uma coisa aconte�a ao
	 *mesmo tempo, devemos inserir
	 *nesse m�todo.*/
	@Override public void run()
	{	/*para sabermos o nome da thread que estamos
	 	executando no momento � chamando da seguinte
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
			if(!Thread.currentThread().getName().equalsIgnoreCase("t4"))
			{Thread.yield();}
			//exemplo de uso do sleep
			try {Thread.sleep(500);} 
			catch (InterruptedException e)
			{System.out.println(e.getMessage());}
		}
	}
}