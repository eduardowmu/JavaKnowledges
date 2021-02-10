package br.edu.maratona.serializable.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.edu.maratona.serializable.Aluno;
import br.edu.maratona.serializable.Turma;

public class SerializableTeste 
{	public static void main(String[] args) 
	{	gravadorObjeto();
		leitorObjeto();
	}

	private static void gravadorObjeto()
	{	Turma turma = new Turma("Maratona Java");
		Aluno aluno = new Aluno(1L, "Eduardo", "123");
		aluno.setTurma(turma);
		try(ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("aluno.ser")))
		{out.writeObject(aluno);} 
		catch (IOException e) 
		{System.out.println(e.getMessage());}
	}
	
	private static void leitorObjeto()
	{	try(ObjectInputStream input = new ObjectInputStream(
				new FileInputStream("aluno.ser")))
		{	Aluno aluno = (Aluno)input.readObject();
			System.out.println(aluno);
		} 
		catch (IOException | ClassNotFoundException e) 
		{System.out.println(e.getMessage());}
	}
}