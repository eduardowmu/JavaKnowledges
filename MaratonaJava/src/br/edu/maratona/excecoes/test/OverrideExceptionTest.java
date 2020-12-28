package br.edu.maratona.excecoes.test;

import java.io.FileNotFoundException;

import br.edu.maratona.excecoes.customexception.LoginInvalidoException;
import br.edu.maratona.finalmodify.Funcionario;
import br.edu.maratona.finalmodify.Pessoa;

public class OverrideExceptionTest 
{	public static void main(String[] args) 
	{	Funcionario funcionario = new Funcionario();
	
		Pessoa pessoa = new Pessoa();
		
		//sem lançamento de exceção.
		try {funcionario.salvar();} 
		catch (FileNotFoundException | RuntimeException e1) 
		{System.out.println(e1.getMessage());}
		
		try {pessoa.salvar();} 
		catch (FileNotFoundException | LoginInvalidoException e) 
		{System.out.println(e.getMessage());}
	}
}