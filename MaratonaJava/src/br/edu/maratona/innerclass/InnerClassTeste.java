package br.edu.maratona.innerclass;

public class InnerClassTeste 
{	public static void main(String[] args) 
	{	Externa e = new Externa();
		Externa.Interna i = e.new Interna();
		i.verClasseExterna();
		Externa.Interna i2 = new Externa().new Interna();
		i2.verClasseExterna();
		i2.verParametroInterno();
	}
}

class Externa
{	private String nome = "Eduardo W. Murakoshi";
	
	/*Classe interna é como se fosse um método,
	 *pois tem acesso a todos os atributos da
	 *classe externa, inclusive os privados.*/
	class Interna
	{	private int id = 10;
		public void verClasseExterna()
		{System.out.println(Externa.this.nome);}
		
		public void verParametroInterno()
		{System.out.println(this.id);}
	}
}