package br.edu.maratona.wrapper;

public class WrappersTest 
{	public static void main(String[] args) 
	{	//os 8 tipos primitivos do menor para o maior numericos
		byte byteValue = 1;
		short shortValue = 1;
		int intValue = 10;
		//� para numeros inteiros mas possui mais espa�o
		//ne mem�ria que o int
		long longValue = 10;
		
		//para numeros decimais, como o double, mas possui
		//menos espa�o na mem�ria. Se caso colocarmos 10.0
		//precisamos fazer um cast expl�cito, pois pode ser
		//que o valor n�o caiba em um espa�o de mem�ria em
		//um float
		float floatValue = 10.0F;
		double doubleBlue = 100.0;
		
		//n�o numericos
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