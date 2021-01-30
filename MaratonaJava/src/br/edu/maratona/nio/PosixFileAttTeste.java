package br.edu.maratona.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;

public class PosixFileAttTeste 
{	public static void main(String[] args) 
	{	Path path = Paths.get("files\\diretorio\\teste.txt");
		try 
		{	PosixFileAttributes pfa = Files.readAttributes(path, 
				PosixFileAttributes.class);
			System.out.println(pfa.permissions());
		} 
		catch (IOException e) 
		{System.out.println(e.getMessage());}
	}
}