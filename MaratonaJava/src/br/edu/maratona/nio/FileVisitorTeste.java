package br.edu.maratona.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTeste 
{	public static void main(String[] args) throws IOException 
	{Files.walkFileTree(Paths.get("files"), new PrintPaths());}
}

class FindAllTxt extends SimpleFileVisitor<Path>
{	@Override public FileVisitResult visitFile(Path file, 
		BasicFileAttributes attrs)
	{	if(file.getFileName().toString().endsWith(".txt"))
		{System.out.println(file.getFileName());}
		
		return FileVisitResult.CONTINUE;	
	}
}

class PrintPaths extends SimpleFileVisitor<Path>
{	public FileVisitResult preVisitDirectory(Path path, 
		BasicFileAttributes attrs)
	{	System.out.println("pre " + path);
		
		return FileVisitResult.CONTINUE;
	}
	
	@Override public FileVisitResult visitFile(Path path, 
		BasicFileAttributes attrs)
	{	System.out.println(path.getFileName());
		
		return FileVisitResult.CONTINUE;
	}
	
	@Override public FileVisitResult visitFileFailed(Path path, 
		IOException exc)
	{	if(path.getFileName().toString().contains("diretorio"))
		{return FileVisitResult.TERMINATE;}
		
		return FileVisitResult.CONTINUE;
	}
	
	public FileVisitResult postVisitFileDirectory(Path path, 
			IOException ioe)
	{	System.out.println(path);
		
		return FileVisitResult.CONTINUE;
	}
}