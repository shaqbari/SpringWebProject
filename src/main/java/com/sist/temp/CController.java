package com.sist.temp;

public class CController {
	
	@RequestMapping("find.do")
	public void find(String id, String pwd) {
		System.out.println("find() Call... "+id+" "+pwd);
	}
	
	@RequestMapping("reply.do")
	public void reply(String id, String pwd) {
		System.out.println("reply() Call... "+id+" "+pwd);
	}
}
