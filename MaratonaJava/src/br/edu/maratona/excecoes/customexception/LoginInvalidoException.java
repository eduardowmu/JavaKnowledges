package br.edu.maratona.excecoes.customexception;

/*Exceção do tipo checked, pois está sendo diretamente uma
 *subclasse de exception*/
public class LoginInvalidoException extends Exception
{	//exceção customizada para o nosso problema
	public LoginInvalidoException() 
	{super("Usuario ou Senha invalida");}
}