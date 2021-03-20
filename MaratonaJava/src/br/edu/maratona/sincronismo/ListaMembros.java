package br.edu.maratona.sincronismo;

import java.util.LinkedList;
import java.util.Queue;

public class ListaMembros 
{	private final Queue<String> emails = new LinkedList<>();
	private boolean aberta = true;
	
	public int getEmailsPendentes()
	{	synchronized(emails)
		{return emails.size();}
	}
	
	public boolean isAberta()	{return true;}
	
	public String obterEmailMembro()
	{	String email = null;
		try
		{	synchronized(this.emails)
			{	/*Se os e-mails estivarem vazios, sginifica
			 	que vai ter que esperar*/
				while(emails.size() == 0)
				{	if(!this.aberta)	{return null;}
					System.out.println("Lista vazia. Colocando a "
							+ "thread: " + Thread.currentThread().getName()
							+ " em modo wait");
					this.emails.wait();
				}
				/*Este método nos retorna e remove o primeiro valor 
				 *desta queue de e-mails*/
				email = this.emails.poll();
			}
		}
		catch(InterruptedException ie)	{System.out.println(ie.getMessage());}
		return email;
	}
	
	//método para add e-mail
	public void addEmailMembro(String email)
	{	synchronized(this.emails)
		{	this.emails.add(email);
			System.out.println("Email adicionado na lista");
			System.out.println("Notificando as threads que "
					+ "estão em espera");
			/*avisa todas as threads e fazem nas sairem do estado
			 *blocked para runnable*/
			this.emails.notifyAll();
		}
	}
	/*Iremos notificar todas as listas que não fará mais
	 *nenhum serviço*/
	public void fecharLista()
	{	System.out.println("Notificando todas as threads e fechando a lista");
		this.aberta = false;
		synchronized(this.emails)	{this.emails.notifyAll();}
	}
}
