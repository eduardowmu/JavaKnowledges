package br.edu.maratona.excecoes.customexception;

/*Exce��o do tipo checked, pois est� sendo diretamente uma
 *subclasse de exception*/
public class LoginInvalidoException extends Exception
{	//exce��o customizada para o nosso problema
	public LoginInvalidoException() 
	{super("Usuario ou Senha invalida");}
}