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
		//gerar uma exce��o.
		try {System.out.println("Arquivo criado: " + file.createNewFile());} 
		
		//caso ocorra a exce��o, o java criar� o objeto "e" poder� 
		//usa-lo para retornar algo como o motivo da 
		//ocorrencia da exce��o.
		catch (IOException e) 
		{System.out.println(e.getMessage());}
	}
}