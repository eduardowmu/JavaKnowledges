package br.edu.maratona.stream;

import java.util.Comparator;
import java.util.List;

import br.edu.maratona.stream.classes.Pessoa;

public class StreamTeste3 
{	public static void main(String[] args) 
	{	List<Pessoa> pessoas = Pessoa.bancoDePessoas();
		//anyMatch()
		System.out.println(pessoas.stream().anyMatch(p->p.getSalario() > 4000));
		
		//allMatch()
		System.out.println(pessoas.stream().allMatch(p->p.getIdade() > 20));
		System.out.println(pessoas.stream().allMatch(p->p.getIdade() > 20 && 
				p.getIdade() < 40));
		
		//noneMatch(). Este é equivalente ao allMatch() porém negado
		System.out.println(pessoas.stream().noneMatch(p->p.getIdade() > 20));
		System.out.println(pessoas.stream().noneMatch(p->p.getIdade() < 20));
		
		//findAny() 
		System.out.println(pessoas.stream().filter(p->p.getIdade() < 40)
				//encontra algum registro, o primeiro que encontrar
				.findAny()
				//retorna em forma de objeto
				.get()
				//identifica o objeto.
				.toString());
		/*este mesmo processo poderia ser feito usando ifPresent() ao 
		 *invés de get*/
		pessoas.stream().filter(p->p.getIdade() < 40).findAny()
			.ifPresent(p->System.out.println(p.toString()));
		//findFirst()
		pessoas.stream().filter(p->p.getIdade() < 40).findFirst()
		.ifPresent(p->System.out.println(p.toString()));
		System.out.println("-------------------------EXTRAS-----------------------------");
		//se quisermos encontrar todos
		pessoas.stream().filter(p->p.getIdade() < 40).forEach(
				p->System.out.println(p.toString()));
		System.out.println("------------------------------------------------------------");
		//usando métodos do tipo sort
		pessoas.stream().filter(p->p.getIdade() < 40)
			.sorted(Comparator.comparing(Pessoa::getNome))
			.findFirst().ifPresent(p->System.out.println(p.toString()));
		System.out.println("------------------------------------------------------------");
		pessoas.stream().filter(p->p.getIdade() < 40)
			.sorted(Comparator.comparing(Pessoa::getNome).reversed())
			.findFirst().ifPresent(p->System.out.println(p.toString()));
	}
}