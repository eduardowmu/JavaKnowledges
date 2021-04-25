package br.edu.maratona.pattherns;

public class PessoaTeste 
{	public static void main(String[] args) 
	{	Pessoa pessoa = new Pessoa.PessoaBuilder()
			.nome("Eduardo").apelido("Dudu")
			.ultimoNome("Murakoshi").meioNome("Watanabe")
			.nomePai("Osamu").criatePessoa();
	
		System.out.println(pessoa);
	}
}