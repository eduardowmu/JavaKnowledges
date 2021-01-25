package br.edu.maratona.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizacaoTeste 
{	public static void main(String[] args) 
	{	Path p1 = Paths.get("files\\..\\teste.txt");
		if(Files.notExists(p1.getParent()))
		{	try {Files.createDirectories(p1.getParent());} 
			catch (IOException e) 
			{System.out.println(e.getMessage());}
		}
		if(Files.notExists(p1))
		{	try {Files.createFile(p1);} 
			catch (IOException e) 
			{System.out.println(e.getMessage());}
		}
		System.out.println(p1);
		System.out.println(p1.normalize());
	}
}