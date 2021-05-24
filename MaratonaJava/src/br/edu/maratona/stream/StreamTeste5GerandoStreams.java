package br.edu.maratona.stream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class StreamTeste5GerandoStreams 
{	public static void main(String[] args) 
	{	//Stream de tipo primitivo inteiro
		IntStream.rangeClosed(0, 100).filter(n -> n % 2 == 0)
			.forEach(s -> System.out.print(s + " "));
		System.out.println("\n--------------------------------------------------");
		IntStream.range(0, 100).filter(n -> n % 2 == 0)
			.forEach(s -> System.out.print(s + " "));
		System.out.println("\n--------------------------------------------------");
		
		Stream<String> nomes = Stream.of("Eduardo", "Watanabe", "Murakoshi");
		nomes.map(String::toUpperCase).forEach(s -> System.out.print(s + " "));
		
		System.out.println("\n--------------------------------------------------");
		//gerando stream que calcula média de numeros inteiros
		int numeros[] = {1,2,3,4,5};
		OptionalDouble avg = Arrays.stream(numeros).average();
		System.out.println(avg.getAsDouble());
		
		System.out.println("\n--------------------------------------------------");
		//pegando todas as palavras de um arquivo
		try(Stream<String> lines = Files.lines(Paths.get("folder/diretorio"), 
				Charset.defaultCharset()))
		{	//filtrando por todas as linhas que possui a palavra 'uma'
			lines.flatMap(line -> Arrays.stream(line.split("\n")))
				.filter(p -> p.contains("uma")).forEach(System.out::println);
		}
		catch(IOException ioe) {System.out.println(ioe.getMessage());}
		
		System.out.println("\n---------------------Stream Infinito----------------------");
		Stream.iterate(1, n -> n + 2).limit(10).forEach(System.out::println);
		
		System.out.println("\n---------------------UnaryOperator------------------------");
		Stream.iterate(new int[] {0, 1}, a -> new int[] {a[1], a[0]+a[1]}).limit(5)
			.forEach(b -> System.out.print(Arrays.toString(b)));
		//queremos apenas os números
		System.out.println("");
		Stream.iterate(new int[] {0, 1}, a -> new int[] {a[1], a[0]+a[1]}).limit(10)
			.map(c -> c[0])
			.forEach(System.out::println);
		
		System.out.println("\n---------------------Generate-----------------------------");
		//geração de numeros aleatórios inteiros com limite de 10
		Stream.generate(Math::random).limit(10).forEach(r -> System.out.print(Math.round(
				r.doubleValue()*100) + " "));
		
		System.out.println("\n---------------------ThreadLocalRandom--------------------");
		ThreadLocalRandom r = ThreadLocalRandom.current();
		Stream.generate(() -> r.nextInt(1,100)).limit(10)
			.forEach(n -> System.out.print(n + " "));
	}
}