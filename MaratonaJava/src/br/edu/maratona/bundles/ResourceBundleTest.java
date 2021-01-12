package br.edu.maratona.bundles;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest 
{	public static void main(String[] args) 
	{	//instanciando um ResourceBundle, com apenas o nome do arquivo
		//e um objeto do tipo Locale, para pegar a localização do
		//idioma que queremos traduzir
		//System.out.println(Locale.getDefault());
		ResourceBundle rb = ResourceBundle.getBundle(
				"messages", new Locale("en", "US"));
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("good.morning"));
		System.out.println(rb.getString("show"));
	}
}