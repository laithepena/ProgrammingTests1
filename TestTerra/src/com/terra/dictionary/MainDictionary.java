package com.terra.dictionary;

public class MainDictionary {
	
	
	
public static void main(String[] args) {
	ArrayDictionary<String, String> a=new ArrayDictionary<String, String>();
	
	a.add("w1", "meaning 1"); a.add("w2", "meaning 2");
	a.add("w3", "meaning 3"); a.add("k4", "meaning 4");
	
	a.add(null, "meaning 4");
	

	a.displayAll();
	System.out.println("\n");
	
	/*System.out.println(a.remove("w2"));
	a.add("w22", "meaning 22");
	System.out.println("\n");*/
	
	
	//First check if it contains or not  then getValue
	System.out.println("w21 -- "+a.contains("w21"));
	
	System.out.println(a.getValue("w3"));
	System.out.println(a.getSize());
	
	a.prefixSearch("w");
	//a.displayAll();
	
	// ##############################################################
	
	ListDictionary<String, String> a1=new ListDictionary<String, String>();
	
	System.out.println("##########################################");
	a1.add("pom", "meaning 1");
	
	a1.add("pim", "meaning 2");
	
	a1.add("jyoti", "meaning 3");
	a1.add("qwq", "meaning 4");
	/*a.add("qwq", "meaning 4");
	a.add("qwq123", "meaning 5");*/
	/*a.add("jyoti", "meaning 3");
	
	a.add("qwq", "meaning 4");*/
	
	a1.add("qwq1", "meaning 5");
	a1.add("qwq11", "meaning 6");
	a1.add("qwq111212", "meaning 7");
	a1.add("zasasaqw", "meaning 8");
	a1.getValue("zasasaqw");
	
	a1.add("lmnbsgio", "meaning 9");
	//a.remove("zasasaqw");
	a1.remove("zasasaqw");
	a1.displayAll();
	
	System.out.println(a.getSize());
	
}
}
