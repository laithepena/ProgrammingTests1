package com.demo;

import java.util.Calendar;

public class MainDictionary {
	
	
	
public static void main(String[] args) {
	ListDictionary<String, String> a=new ListDictionary<String, String>();
	
		
	a.add("pom", "meaning 1");
	
	a.add("pim", "meaning 2");
	
	a.add("jyoti", "meaning 3");
	a.add("qwq", "meaning 4");
	/*a.add("qwq", "meaning 4");
	a.add("qwq123", "meaning 5");*/
	/*a.add("jyoti", "meaning 3");
	
	a.add("qwq", "meaning 4");*/
	
	a.add("qwq1", "meaning 5");
	a.add("qwq11", "meaning 6");
	a.add("qwq111212", "meaning 7");
	a.add("zasasaqw", "meaning 8");
	a.getValue("zasasaqw");
	
	a.add("lmnbsgio", "meaning 9");
	//a.remove("zasasaqw");
	a.remove("zasasaqw");
	a.displayAll();
	
	System.out.println(a.getSize());
	
	
	
	//System.out.println(a.getValue("pom"));
	
	
	
	
}
}
