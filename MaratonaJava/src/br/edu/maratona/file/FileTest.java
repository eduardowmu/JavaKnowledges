package br.edu.maratona.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest 
{	public static void main(String[] args) 
	{	//Criando um novo arquivo 
		//se for criado com apenas o nome, o
		//mesmo será criado dentro do projeto.
		File file = new File("files\\arquivo.txt");
		//método que retorna booleano indicando
		//se o arquivo foi gerado.
		try 
		{	if(!file.exists())
			{	if(file.createNewFile())
				{	System.out.println("Arquivo criado com "
						+ "sucesso em " + file.getPath() + 
						" na data: " + new Date(
								file.lastModified()));
				}
			}
		
			else
			{	System.out.println(file.getAbsolutePath());
				if(file.delete())
				{	System.out.println("Arquivo ja "
						+ "existe e foi deletado");
				}
			}
		} 
		catch (IOException e) 
		{System.out.println(e.getMessage());}
	}
}