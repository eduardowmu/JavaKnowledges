package br.edu.maratona.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributeTeste 
{	public static void main(String[] args) 
	{	Path path = Paths.get("folder\\filetest.txt");
		try 
		{	if(!Files.exists(path))
			{Files.createFile(path);}
			//setando atributos
			Files.setAttribute(path, "dos:hidden", true);
			//lembrando que em muitas partes o java é 
			//case sensitive, ou seja, tem diferenças com
			//letras maiusculas e minusculas
			Files.setAttribute(path, "dos:readonly", true);
			DosFileAttributes dosFileAtt = Files.readAttributes(
					//embora seja uma interface, devemos encará-la
					//como uma classe
					path, DosFileAttributes.class);
			System.out.println(dosFileAtt.isHidden());
			System.out.println(dosFileAtt.isReadOnly());
		} 
		catch (IOException e) 
		{System.out.println(e.getMessage());}
	}
}