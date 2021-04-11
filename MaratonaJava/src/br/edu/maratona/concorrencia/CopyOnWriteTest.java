package br.edu.maratona.concorrencia;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

//para tornar essa classe imutável, a palavra chave
//final é a que torna imutável se não houver SETTER.
/*final class Pessoa
{	private String nome;
	
	public Pessoa(String nome) {this.nome = nome;}

	//não é deixado nenhum método SETTER, impedindo
	//de torná-lo mutável
	public String getNome() {return nome;}
}*/

public class CopyOnWriteTest implements Runnable
{	private List<Integer> list = new CopyOnWriteArrayList<>();
	
	public CopyOnWriteTest()
	{	for(int i = 0; i < 9000; i++)
		{list.add(i);}
	}

	@Override public void run() 
	{	/*O Iterator sempre irá manter a referência pro momento
	 	em que este pegou.*/
		Iterator<Integer> iterator = list.iterator();
		
		try {TimeUnit.SECONDS.sleep(2);}
		catch (InterruptedException e) 
		{System.out.println(e.getMessage());}
		
		while(iterator.hasNext())
		{	System.out.println(Thread.currentThread().getName() 
				+ " " + iterator.next());
		}
	}
	
	public List<Integer> getList() {return list;}
	
	public static void main(String[] args)
	{	CopyOnWriteTest ct = new CopyOnWriteTest();
		Thread t1 = new Thread(ct);
		Thread t2 = new Thread(ct);
		Thread removedor = new Thread(new RemoveMembros(ct.getList()));
		t1.start();
		t2.start();
		removedor.start();
	}
	
	private static class RemoveMembros implements Runnable
	{	private List<Integer> lista;
	
		public RemoveMembros(List<Integer> list)
		{lista = list;}
	
		@Override public void run() 
		{	for(int i = 0; i < 500; i++)
			{	System.out.println(Thread.currentThread().getName() 
					+ " removeu " + lista.remove(i));
			}
		}
	}
}