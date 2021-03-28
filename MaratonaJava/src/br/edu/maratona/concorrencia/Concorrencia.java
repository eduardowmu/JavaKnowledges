package br.edu.maratona.concorrencia;

import java.util.concurrent.atomic.AtomicInteger;

class Contador
{	private int count;
	private AtomicInteger atomicInteger = new AtomicInteger();
	
	public void increment()	
	{	this.count++;
		this.atomicInteger.getAndIncrement();
	}
	
	public int getCount()	{return this.count;}

	public int getAtomicInteger() 
	{return atomicInteger.intValue();}
}

class IncrementadorThread extends Thread
{	private Contador contador;

	public IncrementadorThread(Contador contador) 
	{this.contador = contador;}

	public void run()
	{	for(int i = 0; i < 10000; i++)
		{contador.increment();}
	}
}

public class Concorrencia 
{	public static void main(String[] args)
	{	Contador c = new Contador();
		IncrementadorThread ic1 = new IncrementadorThread(c);
		IncrementadorThread ic2 = new IncrementadorThread(c);
		
		ic1.start();
		ic2.start();
		
		try
		{	ic1.join();
			ic2.join();
			System.out.println(c.getCount());
			System.out.println(c.getAtomicInteger());
		}
		catch(InterruptedException ie) 
		{System.out.println(ie.getMessage());}
	}
}