package com.sist.temp;

//return "list" redirect:list.do
//js로 보낼 때 @ResponseBody => script (history.back 이용가능)
@Controller
public class BController {

	@RequestMapping("update.do")
	public void update(String id, String pwd) {
		System.out.println("update() Call... "+id+" "+pwd);
	}
	
	@RequestMapping("delete.do")
	public void delete(String id, String pwd) {
		System.out.println("delete() Call... "+id+" "+pwd);
	}
}
