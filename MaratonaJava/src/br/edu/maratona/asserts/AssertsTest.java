package br.edu.maratona.asserts;

public class AssertsTest 
{	public static void main(String[] args) 
	{	calculaSalario(-1000.0);
		
		try {calculaSalario(-10);}
		catch(IllegalArgumentException e)
		{System.out.println(e.getMessage());}
	}

	private static void calculaSalario(double salario) 
	{	//estamos falando que a compara��o dentro do assert
		//deve ser verdadeiro, pois caso contr�rio, nos dir�
		//que nosso c�digo tem um erro muito s�rio e n�o est�vemos
		//preparados para esse tipo de erro. Com isso podemos
		//garantir, em tempo de fase de testes que salario sempre
		//v� ser maior que zero.
		assert(salario > 0): "Salario negativo!";
	}
	
	public static void calculaSalario(int salario) 
		throws IllegalArgumentException
	{	if(salario < 0)
		{throw new IllegalArgumentException("Salario negativo!");}
	}
}