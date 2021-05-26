package br.edu.maratona.stream;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamTeste 
{	public static void main(String[] args) 
	{	long num = 10_000_000;
//		somaFor(num);
		System.out.println("-----------usando stream------------");
//		somaStreamIterate(num);
		System.out.println("-----------usando parallel stream------------");
		somaParallelStreamIterate(num);
//		System.setProperty("java.util.concurrent.ForkJoinPool"
//				+ ".common.parallellism", "12");
		System.out.println("-----------usando LongStream------------");
		somaRangeClosedStream(num);
		System.out.println("-----------usando ParallelLongStream------------");
		somaRangeClosedParallelStream(num);
		System.out.println("Numero de processamentos " 
				+ Runtime.getRuntime().availableProcessors());
	}

	private static void somaFor(long num)
	{	long result = 0;
		//tempo de início da execução.
		long init = System.currentTimeMillis();
		//looping
		for(long i = 1L; i <= num; i++)	{result += i;}
		//pegando o tempo final
		long end = System.currentTimeMillis();
		
		System.out.println(result + " " + (end - init));
	}
	
	private static void somaStreamIterate(long num)
	{	long result = 0;
		//tempo de início da execução.
		long init = System.currentTimeMillis();
		//looping
		result = Stream.iterate(1L, i -> i + 1).limit(num)
				.reduce(0L, Long::sum);
		//pegando o tempo final
		long end = System.currentTimeMillis();
		
		System.out.println(result + " " + (end - init));
	}
	
	private static void somaParallelStreamIterate(long num)
	{	long result = 0;
		//tempo de início da execução.
		long init = System.currentTimeMillis();
		//looping
		result = Stream.iterate(1L, i -> i + 1).limit(num)
				/*se usarmos sequencial() ou chamar o parallel no mesmo
				 *nunca será executado os dois, mas sim o ultimo que foi
				 *chamado.*/
				.parallel().sequential().reduce(0L, Long::sum);
		//pegando o tempo final
		long end = System.currentTimeMillis();
		
		System.out.println(result + " " + (end - init));
	}
	
	private static void somaRangeClosedStream(long num)
	{	long result = 0;
		//tempo de início da execução.
		long init = System.currentTimeMillis();
		//looping
		result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
		//pegando o tempo final
		long end = System.currentTimeMillis();
		
		System.out.println(result + " " + (end - init));
	}
	
	private static void somaRangeClosedParallelStream(long num)
	{	long result = 0;
		//tempo de início da execução.
		long init = System.currentTimeMillis();
		//looping
		result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);
		//pegando o tempo final
		long end = System.currentTimeMillis();
		
		System.out.println(result + " " + (end - init));
	}
}