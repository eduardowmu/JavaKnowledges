package br.edu.maratona;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTeste 
{	public static void main(String[] args) 
	{	//idioma inglês
		Locale locale = new Locale("fr", "FR");
		
		//idioma inglês americano
		Locale locale2 = new Locale("pt", "BR");
		
		//instanciando um calendar
		Calendar calendar = Calendar.getInstance();
		
		//instanciando um DateFormat
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale2);
		
		System.out.println(df.format(calendar.getTime()));
		
		DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, locale);
		
		System.out.println(df2.format(calendar.getTime()));
		System.out.println(locale.getDisplayLanguage() + ", " + 
				locale.getDisplayLanguage(locale));
		System.out.println(locale.getDisplayCountry());
	}
}