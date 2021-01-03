package br.edu.maratona;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTeste 
{	public static void main(String[] args) 
	{	String texto = "abababa";
		
		//queremos encontrar "ab" dentro da vari�vel texto
		String regex = "aba";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		
		System.out.println("texto: " + texto);
		System.out.println("indice: 0123456789");
		System.out.println("expressao: " + matcher.pattern());
		System.out.println("posi��es encontradas");
		
		//enquanto o matcher encontra padr�o desse texto
		while(matcher.find())
		{System.out.println(matcher.start() + " ");}
	}
}