package br.edu.maratona.concorrencia;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ColecoesConcorrentesTeste 
{	public static void main(String[] args) 
	{	//ConcurrentHashMap
		//ConcurrentLinkedDeque
		//ConcurrentLinkedQueue
		//ConcurrentSkipListMap
		//ConcurrentSkipListSet
		/*Essas classes de lists permitem multiplas threads a
		 *lerem e escreverem concorrentemente, sem ter que criar
		 *multiplas cópias internas numa coleção. No java 8, os
		 *métodos de ConcurrentHashMap por exemplo foram adicionados
		 *na interface Map*/
		Map<String, String> map = new HashMap<>();
		ConcurrentHashMap<String, String> cmap = new ConcurrentHashMap<>();
		
		//valores de map
		map.put("1", "1");
		map.put("1", "2");
		
		//valores de cmap
		cmap.put("1", "1");
		//irá permitir inserir um valor se já não existir.
		cmap.putIfAbsent("1", "2");
		
		System.out.println(map.get("1"));
		
		//lembrando que esse map é atômico, ou seja
		//não sofre alterações
		System.out.println(cmap.get("1"));
	}
}