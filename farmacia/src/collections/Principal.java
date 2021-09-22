package collections;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

public class Principal {

	public static void main(String[] args) {
		// Lista
		List<String> lst = new ArrayList<String>();
		// Lista que não deixa repetir
		Set<String> lstSet = new HashSet<String>();
		
		// Pilha
		Stack<String> sck = new Stack<String>();
		// Fila
		Queue<String> que = new PriorityQueue<String>();		
		// Map
		Map<Integer, String>  mapa = new HashMap<Integer, String>();
		
		//tests
		List<Integer> lstInt = new ArrayList<>();
		lstInt.add(3);
		lstInt.add(5);
		lstInt.add(2);
		lstInt.add(1);
		Collections.sort(lstInt);
		
		for(Integer i: lstInt) {
			System.out.println(i);
		}
		
		List<String> lstString = new ArrayList<>();
		lstString.add("João");
		lstString.add("Marcos");
		lstString.add("Bruno");
		Collections.sort(lstString);
		
		for(String i: lstString) {
			System.out.println(i);
		}
		
	}

}
