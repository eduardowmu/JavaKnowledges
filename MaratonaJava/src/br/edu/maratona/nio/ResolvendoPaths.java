package br.edu.maratona.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvendoPaths 
{	public static void main(String[] args) 
	{	Path dir = Paths.get("home\\willian");
		Path file = Paths.get("dev\\arquito.txt");
		Path result = dir.resolve(file);
		System.out.println(result);
		
		Path absoluto = Paths.get("/home/willian");
		Path relativo = Paths.get("dev");
		Path file2 = Paths.get("file.txr");
		
		System.out.println("1: " + absoluto.resolve(relativo));
		System.out.println("2: " + absoluto.resolve(file));
		System.out.println("3: " + relativo.resolve(file));
		System.out.println("4: " + relativo.resolve(absoluto));
		System.out.println("5: " + file.resolve(absoluto));
		System.out.println("6: " + file.resolve(relativo));
	}
}