package br.edu.maratona.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class FindAllTest extends SimpleFileVisitor<Path>
{	private PathMatcher matcher = FileSystems.getDefault()
		.getPathMatcher("glob:**/*{Teste*}.{java,class}");
	@Override public FileVisitResult visitFile(Path file, 
			BasicFileAttributes attrs) throws IOException
	{	if(matcher.matches(file))
		{System.out.println(file.getFileName());}
	
		return FileVisitResult.CONTINUE;
	}
}

public class PathMactherTeste 
{	public static void main(String[] args) throws IOException 
	{	Path path = Paths.get("files/diretorio/teste.txt");
		Path path2 = Paths.get("arquivo.txt");
		
		PathMatcher matcher = FileSystems.getDefault()
			//aqui começamos com REGEX e sempre iniciamos
			//com um padrão glob
			.getPathMatcher("glob:*.txt");
		System.out.println(matcher.matches(path));
		System.out.println(matcher.matches(path2));
		matches(path, "glob:*.txt");
		//para incluir os diretórios são **
		matches(path, "glob:**/*.txt");
		Files.walkFileTree(Paths.get("./"), new FindAllTest());
	}

	private static void matches(Path path, String glob)
	{	PathMatcher matcher = FileSystems.getDefault()
			.getPathMatcher(glob);
		System.out.println(glob + ": " + matcher.matches(path));
	}
}