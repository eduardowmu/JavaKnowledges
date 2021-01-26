package br.edu.maratona.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizarTeste 
{	public static void main(String[] args) 
	{	Path dir = Paths.get("/home/willian");
		Path classe = Paths.get("/home/willian/java/Pessoa.java");
		
		//partindo do objeto "dir", como chegar em "classe".
		Path dirToClasse = dir.relativize(classe);
		
		System.out.println(dirToClasse);
		
		//paths absolutos
		Path abs1 = Paths.get("/home/willian");
		Path abs2 = Paths.get("/usr/local");
		Path abs3 = Paths.get("/home/willian/java/Pessoa.java");
		
		//paths relativos
		Path rel1 = Paths.get("temp");
		Path rel2 = Paths.get("temp/Funcionario.java");
		
		System.out.println("1: " + abs1.relativize(abs3));
		System.out.println("2: " + abs3.relativize(abs1));
		System.out.println("3: " + abs1.relativize(abs2));
		System.out.println("4: " + rel1.relativize(rel2));
		//System.out.println("5: " + abs1.relativize(rel1));
	}
}