package br.edu.maratona.excecoes.runtimeecption;

import java.io.File;
import java.io.IOException;

public class CheckedException 
{	public static void main(String[] args)
	{criarNovoArquivo();}

	public static void criarNovoArquivo()
	{	File file = new File("F:/Users/eduardowmu/Desktop/meusdoc/"
			+ "estudo/FATEC/7 - OUTROS SEMESTRES/YOUTUBE/"
			+ "Maratona java/teste.txt");
		
		//isso recomenda tentar executar algo que pode 
		//gerar uma exceção.
		try {System.out.println("Arquivo criado: " + file.createNewFile());} 
		
		//caso ocorra a exceção, o java criará o objeto "e" poderá 
		//usa-lo para retornar algo como o motivo da 
		//ocorrencia da exceção.
		catch (IOException e) 
		{System.out.println(e.getMessage());}
	}
}