package br.edu.maratona;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTeste 
{	public static void main(String[] args) 
	{	//int numeroHex = 0xaff;
		//String texto = "12 0x 0X 0xFFABC 0x10G 0x1";
		
		//queremos encontrar "ab" dentro da vari�vel texto
		//String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
		
		/*String texto = "fulano@hotmail.com, 102Abc@gmail.com, "
			+ "*@!abrao@mail.br, teste@gmail.com.br, teste@mail";*/
		
		//String texto = "05/10/2010 05/05/2015 1/1/01 01/05/95";
		
		/*o ponto "." � um coringa usado em express�es
		 *regulares, portanto devemos sempre usar "\\." 
		 *no lugar, para dizer que estamos usando um "."
		 *texto e n�o como caractere coringa*/
		//String regex = "([a-zA-Z0-9\\._-])+@([a-zA-z])+(\\.([a-zA-z])+)+";
		//String regex = "([\\w\\.])+@([a-zA-z])+(\\.([a-zA-z])+)+";
	
		String texto = "projeto1.bkp, proj1.java, proj1.class, "
				+ "proj1final.java, proj2.bkp, proj3.java";
		
		//queremos pegar tudo que comece com proj, mas...
		String regex = "proj([^,])*";
		
		/*recomend�vel usar String*/
		System.out.println("E-mail valido: "+"*@!abrao@mail.br".matches(regex));
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		
		System.out.println("texto: " + texto);
		System.out.println("indice: 0123456789");
		System.out.println("expressao: " + matcher.pattern());
		System.out.println("posi��es encontradas");
		
		//enquanto o matcher encontra padr�o desse texto
		while(matcher.find())
		{	//toda vez que encontrar um valor que esta no 
			//regex, vai escrever
			System.out.println("posi��o " + matcher.start() + 
				": " + matcher.group());
		}
		
		//System.out.println(numeroHex);
	}
}