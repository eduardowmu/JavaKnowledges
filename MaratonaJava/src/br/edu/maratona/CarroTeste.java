package br.edu.maratona;

import br.edu.maratona.finalmodify.Carro;
import br.edu.maratona.finalmodify.Comprador;

public class CarroTeste 
{	public static void main(String[] args) 
	{	//criando instancia de carro
		Carro carro = new Carro();
		System.out.println(carro.getComprador());
		
		//Definindo um nome do comprador do carro
		carro.getComprador().setNome("Eduardo");
		
		//Instanciando um tipo Comprador, através de um atributo
		//de classe referenciada.
		Comprador comprador = carro.getComprador();
		System.out.println(comprador.getNome());
		
		//tentativa de criar uma nova instância em uma já existente
		
	}
}