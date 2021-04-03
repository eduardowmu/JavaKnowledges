package br.edu.maratona.concorrencia;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest 
{	public static void main(String[] args) throws InterruptedException
	{	final ReentrantLock lock = new ReentrantLock();
		new Thread(new Worker("A", lock)).start();
		new Thread(new Worker("B", lock)).start();
		new Thread(new Worker("C", lock)).start();
		new Thread(new Worker("D", lock)).start();
		new Thread(new Worker("E", lock)).start();
		new Thread(new Worker("F", lock)).start();
		new Thread(new Worker("G", lock)).start();
	}

	static class Worker implements Runnable
	{	private String nome;
		private ReentrantLock rlock;
		
		public Worker(String nome, ReentrantLock rlock)
		{	this.nome = nome;
			this.rlock = rlock;
		}
		
		@Override public void run() 
		{	this.rlock.lock();
			try
			{	if(this.rlock.isHeldByCurrentThread())
				{	System.out.printf("\n Thread %s entrou "
						+ "em uma sessão crítica ", this.nome);
					
					System.out.printf("\n %d Threads entrando na fila ", 
							this.rlock.getQueueLength());
					
					System.out.printf("\n Thread %s vai trabalhar por ?"
							+ " segundos ", this.nome);
					
					System.out.printf("\n Thread %s finalizou o trabalho"
							+ " ", this.nome);
					
					System.out.println("\n---------------------------------------------");
				}
			}
			finally {this.rlock.unlock();}
		}
	}
}