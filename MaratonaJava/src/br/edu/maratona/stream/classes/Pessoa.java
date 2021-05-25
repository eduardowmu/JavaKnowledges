package br.edu.maratona.stream.classes;

import java.util.List;
import static java.util.Arrays.asList;
public class Pessoa 
{	private String nome;
	private int idade;
	private double salario;
	private Genero genero;
	private Maioridade maioridade;
	
	public Pessoa(String nome, int idade, double salario) 
	{	this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}
	
	public Pessoa(String nome, int idade, double salario, Genero genero) 
	{	this.nome = nome;
		this.idade = idade;
		this.salario = salario;
		this.genero = genero;
	}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public int getIdade() {return idade;}
	public void setIdade(int idade) {this.idade = idade;}

	public double getSalario() {return salario;}
	public void setSalario(double salario) {this.salario = salario;}
	
	public Genero getGenero() {return genero;}

	public static List<Pessoa> bancoDePessoas()
	{	return asList(new Pessoa("Eduardo Murakoshi", 37, 4000.0, Genero.MASCULINO),
					  new Pessoa("Rodrigo Murakoshi", 41, 20000.0, Genero.MASCULINO),
					  new Pessoa("Osamu Murakoshi", 73, 10000.0, Genero.MASCULINO),
					  new Pessoa("Marie Murakoshi", 67, 10000.0, Genero.FEMININO),
					  new Pessoa("Camila da Costa", 31, 4000.0, Genero.FEMININO),
					  new Pessoa("Camila da Costa", 32, 5000.0, Genero.FEMININO),
					  new Pessoa("Biatriz Murakoshi", 5, 0.0, Genero.FEMININO),
					  new Pessoa("Mateus Murakoshi", 7, 0.0, Genero.MASCULINO));
	}

	@Override public int hashCode() 
	{	final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) 
	{	if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override public String toString() 
	{return "Pessoa [nome=" + nome + ", idade=" + idade + ", salario=" + salario + "]";}
}