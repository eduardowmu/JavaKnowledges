package br.edu.maratona.defaultinterface;

public interface MyList 
{	/*Todo método estatico precisa de corpo*/
	static void sort() 
	{System.out.println("dentro do sort");};
	
	default void remove() {System.out.println("removendo...");}
}