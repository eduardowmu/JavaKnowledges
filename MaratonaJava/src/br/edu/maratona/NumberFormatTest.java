package br.edu.maratona;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest 
{	public static void main(String[] args) 
	{	double valor = 123.4567;
		
		//definindo tipos de moedas pelo país
		Locale franca = new Locale("fr", "FR");
		Locale port = new Locale("pt", "PT");
		Locale brasil = new Locale("pt", "BR");
		Locale eua = new Locale("en", "US");
		
		NumberFormat[] nf = new NumberFormat[4];
		nf[0] = NumberFormat.getCurrencyInstance(franca);
		nf[1] = NumberFormat.getCurrencyInstance(port);
		nf[2] = NumberFormat.getCurrencyInstance(brasil);
		nf[3] = NumberFormat.getCurrencyInstance(eua);
		
		for(NumberFormat n:nf)
		{System.out.println(n.format(valor));}
		
		NumberFormat df = new DecimalFormat();
		
		String valorString = "123.4567";
		//convertendo valor String numerico em double
		try 
		{	System.out.println(df.parse(valorString));
			df.setParseIntegerOnly(true);
			System.out.println(df.parse(valorString));
		} 
		catch (ParseException e) 
		{System.out.println(e.getMessage());}
		
		
	}
}