package br.edu.maratona.sincronismo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListaMembros 
{	private final Queue<String> emails = new LinkedList<>();
	
	//quando criamos uma variavel final inicializadas, todas as threads
	//vem com aquele objeto imediatamente 
	private final ReentrantLock reentrantLock = new ReentrantLock();
	
	//vamos agora criar a condição, que vem através do lock
	private final Condition condition = this.reentrantLock.newCondition(); 
	
	private boolean aberta = true;
	
	public int getEmailsPendentes()
	{ 	this.reentrantLock.lock();
		try {return emails.size();}
		finally {this.reentrantLock.unlock();}
		/*
		 * synchronized(emails) {return emails.size();}
		 */
	}
	
	public boolean isAberta()	{return this.aberta;}
	
	public String obterEmailMembro()
	{	String email = null;
		try
		{	this.reentrantLock.lock();
			//synchronized(this.emails)
			//{	/*Se os e-mails estivarem vazios, sginifica
			 	//que vai ter que esperar*/
				while(emails.size() == 0)
				{	if(!this.aberta)	{return null;}
					System.out.println("Lista vazia. Colocando a "
							+ "thread: " + Thread.currentThread().getName()
							+ " em modo wait");
					//this.emails.wait();
					
					//precisamos liberar o lock após o try, e não o lock do
					//emails. 
					this.condition.await();
				}
				
				/*Este método nos retorna e remove o primeiro valor 
				 *desta queue de e-mails*/
				email = this.emails.poll();
			//}
		}
		catch(InterruptedException ie)	{System.out.println(ie.getMessage());}
		finally {this.reentrantLock.unlock();}
		return email;
	}
	
	//método para add e-mail
	public void addEmailMembro(String email)
	{	this.reentrantLock.lock();
		try
		{	this.emails.add(email);
			System.out.println("Email adicionado na lista");
			System.out.println("Notificando as threads que "
					+ "estão em espera");
			this.condition.signalAll();
		}
		finally {this.reentrantLock.unlock();}
		//synchronized(this.emails)
		//{	
			
			/*avisa todas as threads e fazem nas sairem do estado
			 *blocked para runnable*/
			//this.emails.notifyAll();
		//}
	}
	/*Iremos notificar todas as listas que não fará mais
	 *nenhum serviço*/
	public void fecharLista()
	{	System.out.println("Notificando todas as threads e fechando a lista");
		this.aberta = false;
		this.reentrantLock.lock();
		try {this.emails.notifyAll();}
		finally {this.reentrantLock.unlock();}
		//synchronized(this.emails)	{this.emails.notifyAll();}
	}
}