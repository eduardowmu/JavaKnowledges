package br.edu.maratona.excecoes.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import br.edu.maratona.Valor;

public class TryWithResources 
{	public static void main(String[] args) 
	{	lerArquivo();
		criaValor();
	}

	public static void lerArquivo()
	{	//podemos inserir mais de um parâmetro
		try(Reader reader = new BufferedReader(
			new FileReader("F:/Users/eduardowmu/Desktop/"
					+ "meusdoc/estudo/FATEC/7 - OUTROS SEMESTRES/"
					+ "YOUTUBE/Maratona java/teste.txt")))
		{	System.out.println("Arquivo aberto");
			reader.close();
		}
		catch(IOException e) 
		{System.out.println(e.getMessage());}
	}
	
	public static void criaValor()
	{	try(Valor valor1 = new Valor("valor 1");
			Valor valor2 = new Valor("valor 2"))
		{	valor1.close();
			valor2.close();
		}
		catch(Exception e) 
		{System.out.println(e.getMessage());}
	}
}