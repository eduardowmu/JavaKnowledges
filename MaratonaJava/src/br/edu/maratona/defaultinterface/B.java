package br.edu.maratona.defaultinterface;

public interface B extends A 
{	default void oi()
	{System.out.println("Oi B");}
}