package br.edu.maratona.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CriandoPathTeste 
{	public static void main(String[] args) 
	{	Path path = Paths.get("files\\arquivo.txt");
		//outra forma de separar cada local e recuperar
		//os arquivos
		Path path2 = Paths.get("folder", "novoArquivo.txt");
		
		//Transformando um tipo Path em um tipo File
		File file = path2.toFile();
		
		//Processo inverso
		Path path3 = file.toPath();
		
		Path path4 = Paths.get("diretorio");
		
		Path path5 = Paths.get("diretorio\\arquivo.txt");
		
		try 
		{	/*if(Files.notExists(path4))
			{Files.createDirectory(path4);}*/
			
			/*if(Files.notExists(path5))
			{Files.createFile(path5);}*/
			
			if(Files.notExists(path5.getParent()))
			{Files.createDirectory(path5.getParent());}
		
			else {System.out.println("Diretório já existente");} 
		} 
		catch (IOException e) 
		{System.out.println(e.getMessage());}
		
		try	//copia um arquivo existente de um diretório para outro
		{	Files.copy(path, path4, 
				StandardCopyOption.REPLACE_EXISTING);
			//deleta arquivo caso exista.
			Files.deleteIfExists(path2);
		}
		catch(IOException e2)
		{System.out.println(e2.getMessage());}
	}
}