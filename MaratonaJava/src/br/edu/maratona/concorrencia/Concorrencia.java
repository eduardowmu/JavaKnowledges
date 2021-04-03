package br.edu.maratona.concorrencia;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Contador
{	private int count;
	private AtomicInteger atomicInteger = new AtomicInteger();
	//classe Lock, cuja interface que esta classe implementa é
	//ReentrantLock. O parâmetro "true" é para indicar o fernes.
	//Se não tiver esse parametro booleano, por default é false.
	private Lock lock = new ReentrantLock(true);
	
	public void increment()	
	{	//obtendo o lock.
		this.lock.lock();
		//toda vez que obtemos o lock, também
		//precisamos liberá-lo. Pelas boas práticas
		//devemos fazer isso com try-finally
		try
		{	this.count++;
			this.atomicInteger.getAndIncrement();
		}
		finally {this.lock.unlock();}
		
		//this.count++;
		//this.atomicInteger.getAndIncrement();
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