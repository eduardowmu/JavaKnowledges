package br.edu.maratona.pattherns;

import br.edu.maratona.pattherns.entities.Dolar;
import br.edu.maratona.pattherns.entities.Moeda;
import br.edu.maratona.pattherns.entities.Pais;
import br.edu.maratona.pattherns.entities.Real;

public class MoedaFactory 
{	public static Moeda createCoin(Pais country)
	{	if(country.equals(Pais.BRASIL)) {return new Real();}
	
		else if(country.equals(Pais.EUA))
		{return new Dolar();}
	
		throw new IllegalArgumentException("Não existe este país");
	}
}