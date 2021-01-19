package br.edu.maratona.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritterReaderTeste 
{	public static void main(String[] args) 
	{	//criando um arquivo
		File file = new File("files\\arquivo.txt");
		if(file.exists())
		{	try 
			{	FileWriter fw = new FileWriter(file, true);
				fw.write("Escrevendo uma mensagem no arquivo"
						+ "\nEscrevendo mais mensagem.");
				fw.flush();
				//fecha o arquivo.
				fw.close();
				
				//leitura do arquivo
				FileReader fr = new FileReader(file);
				char[] text = new char[500];
				int size = fr.read(text);
				for(char c:text) {System.out.print(c);}
				fr.close();
			} 
			catch (IOException e) 
			{System.out.println(e.getMessage());}
		}
		else
		{	try {file.createNewFile();} 
			catch (IOException e) 
			{System.out.println(e.getMessage());}
		}
	}
}