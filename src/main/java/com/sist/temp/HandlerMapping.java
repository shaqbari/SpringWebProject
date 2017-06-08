package com.sist.temp;


import java.util.*;
public class HandlerMapping {
	private List<String> list=new ArrayList<String>();
	public HandlerMapping(){
	
		//XMLÆÄ½Ì ==> application-context.xml <bean class="com.sist.temp.AController">
		list.add("com.sist.temp.AController");
		list.add("com.sist.temp.BController");
		list.add("com.sist.temp.CController");
		
	}
	
	public List<String> getList() {
		return list;
	}
}
