package br.edu.maratona.wrapper;

public class WrappersTest 
{	public static void main(String[] args) 
	{	//os 8 tipos primitivos do menor para o maior numericos
		byte byteValue = 1;
		short shortValue = 1;
		int intValue = 10;
		//é para numeros inteiros mas possui mais espaço
		//ne memória que o int
		long longValue = 10;
		
		//para numeros decimais, como o double, mas possui
		//menos espaço na memória. Se caso colocarmos 10.0
		//precisamos fazer um cast explícito, pois pode ser
		//que o valor não caiba em um espaço de memória em
		//um float
		float floatValue = 10.0F;
		double doubleBlue = 100.0;
		
		//não numericos
		char charValue = 'A';
		boolean booleanValue = true;
		
		//classes Wrapper
		Byte byteWrapper = 1;
		Short shortWrapper = 1;
		Integer intWrapper = 10;
		Long longWrapper = 10L;
		Float floatWrapper = 10F;
		Double doubleWrapper = 100.0;
		Character charWrapper = 'A';
		Boolean booleanWrapper = true;
	}
}