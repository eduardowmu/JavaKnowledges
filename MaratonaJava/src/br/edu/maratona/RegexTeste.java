package br.edu.maratona;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTeste 
{	public static void main(String[] args) 
	{	//int numeroHex = 0xaff;
		String texto = "12 0x 0X 0xFFABC 0x10G 0x1";
		
		//queremos encontrar "ab" dentro da variável texto
		String regex = "0[xX][0-9a-fA-F]";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		
		System.out.println("texto: " + texto);
		System.out.println("indice: 0123456789");
		System.out.println("expressao: " + matcher.pattern());
		System.out.println("posições encontradas");
		
		//enquanto o matcher encontra padrão desse texto
		while(matcher.find())
		{	//toda vez que encontrar um valor que esta no 
			//regex, vai escrever
			System.out.println("posição " + matcher.start() + 
				": " + matcher.group());
		}
		
		//System.out.println(numeroHex);
	}
}