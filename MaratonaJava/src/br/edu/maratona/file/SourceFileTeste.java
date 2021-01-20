package br.edu.maratona.file;

import java.io.File;
import java.io.IOException;

public class SourceFileTeste 
{	public static void main(String[] args) 
	{	/*
		File file = new File("folder");
		//para quem estiver acostumado com linux
		boolean mkdir = file.mkdir();
		System.out.println("Diretório criado " + mkdir);
		File file2 = new File("folder\\arquivo.txt");
		try 
		{	file2.createNewFile();
			System.out.println("Arquivo criado " + 
					file2.getName());
		} 
		catch (IOException e) 
		{System.out.println(e.getMessage());}
		
		//renomeando arquivo existente
		File renamedFile = new File("folder\\novoArquivo.txt");
		System.out.println("Arquivo renomeado: " + 
				file2.renameTo(renamedFile));
		*/
		findSourceFile();
	}

	public static void findSourceFile()
	{	File file = new File("folder");
		//método que retorna os arquivos dentro
		//do dietório
		for(String fileName:file.list())
		{System.out.println(fileName);}
	}
}