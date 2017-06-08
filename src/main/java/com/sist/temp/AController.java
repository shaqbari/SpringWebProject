package com.sist.temp;

//Model ==> service
// invoke(Object...)
@Controller
public class AController {
	
	@RequestMapping("select.do")
	public void select(String id, String pwd) {
		System.out.println("select() Call... "+id+" "+pwd);
	}
	
	@RequestMapping("insert.do")
	public void insert(String id, String pwd) {
		System.out.println("insert() Call... "+id+" "+pwd);
	}
}
