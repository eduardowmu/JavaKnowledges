package br.edu.maratona.excecoes.test;

import br.edu.maratona.excecoes.customexception.LoginInvalidoException;

public class CustomExceptionTest 
{	public static void main(String[] args) 
	{	try {logar();} 
		catch (LoginInvalidoException e) 
		{System.out.println(e.getMessage());}
	}

	private static void logar() throws LoginInvalidoException
	{	//dados de autenticação
		String userBD = "123";
		String senhaBD = "111";
		
		//dados digitado pelo usuario
		String usuarioDig = "Goku";
		String senhaDig = "123";
		
		if(!userBD.equals(usuarioDig) ||
			!senhaBD.equals(senhaDig))
		{throw new LoginInvalidoException();}
		
		else {System.out.println("Logado");}
	}
}