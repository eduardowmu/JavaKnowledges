package br.edu.maratona.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CriandoPathTeste 
{	public static void main(String[] args) 
	{	Path path = Paths.get("files\\arquivo.txt");
		//outra forma de separar cada local e recuperar
		//os arquivos
		Path path2 = Paths.get("folder", "novoArquivo.txt");
	}
}