package br.edu.maratona.lambda;

import br.edu.maratona.comportamento.Carro;

public class ComparadorCarro 
{	public static int compareByColor(Carro c1, Carro c2)
	{return c1.getCor().compareToIgnoreCase(c2.getCor());}

	public int compareByYear(Carro c1, Carro c2)
	{return Integer.compare(c1.getAno(), c2.getAno());}
	
	
}