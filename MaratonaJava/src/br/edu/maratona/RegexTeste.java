package br.edu.maratona;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTeste 
{	public static void main(String[] args) 
	{	String texto = "bab1278abby_ hgaa92178";
		
		//queremos encontrar "ab" dentro da variável texto
		String regex = "\\W";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		
		System.out.println("texto: " + texto);
		System.out.println("indice: 0123456789");
		System.out.println("expressao: " + matcher.pattern());
		System.out.println("posições encontradas");
		
		//enquanto o matcher encontra padrão desse texto
		while(matcher.find())
		{System.out.print(matcher.start() + " ");}
	}
}