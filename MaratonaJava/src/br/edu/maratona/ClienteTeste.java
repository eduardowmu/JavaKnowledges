package br.edu.maratona;

import br.edu.maratona.enumeracao.Cliente;
import br.edu.maratona.enumeracao.EnumCliente;

public class ClienteTeste 
{	public static void main(String[] args) 
	{	//definindo um cliente tipo pessoa fisica
		Cliente cliente = new Cliente("Eduardo", 
				EnumCliente.PESSOA_FISICA);
		
		//System.out.println(cliente.toString());
		System.out.println(EnumCliente.PESSOA_JURIDICA.getId());
	}
}