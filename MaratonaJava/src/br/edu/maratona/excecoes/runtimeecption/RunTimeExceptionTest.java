package br.edu.maratona.excecoes.runtimeecption;

public class RunTimeExceptionTest 
{	public static void main(String[] args) 
	{	try{divisao(10, 0);}
		catch(IllegalArgumentException e)
		{System.out.println(e.getMessage());}
	}

	private static void divisao(int num1, int num2)
	{	if(num2 == 0)
		{	throw new IllegalArgumentException(
				"Divisão por zero");
		}
		System.out.println(num1/num2);
	}
}