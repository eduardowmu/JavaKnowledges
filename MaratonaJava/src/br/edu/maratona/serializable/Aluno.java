package br.edu.maratona.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Aluno implements Serializable
{	private Long id;
	private String name;
	private transient String password;
	private static String nomeEscola = "DevDojo";
	private transient Turma turma;
	
	public Aluno(Long id, String name, String password) 
	{	this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) 
	{this.password = password;}
	
	public static String getNomeEscola() {return nomeEscola;}
	public static void setNomeEscola(String nomeEscola) 
	{Aluno.nomeEscola = nomeEscola;}
	
	public Turma getTurma() {return turma;}
	public void setTurma(Turma turma) {this.turma = turma;}
	
	/*na hr da serialização, ele vai verificar existe o método
	 *Se existir, será chamado este writeObject()*/
	private void writeObject(ObjectOutputStream oos)
	{	//a órdem não importa, contanto que na hora da leitura 
		//siga a mesma órdem que foi colocado
		try
		{	oos.defaultWriteObject();
			oos.writeUTF(turma.getNome());
		}
		catch(IOException ioe)
		{System.out.println(ioe.getMessage());}
	}
	
	private void readObject(ObjectInputStream ois)
	{	try
		{	ois.defaultReadObject();
			turma = new Turma(ois.readUTF());
		}
		catch(IOException | ClassNotFoundException e)
		{System.out.println(e.getMessage());}
	}

	@Override public String toString() 
	{	return "Aluno ["
			+ "id=" + id 
			+ ", name=" + name 
			+ ", password=" + password 
			+ ", turma="+ turma 
			+"]";
	}
}