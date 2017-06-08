package com.sist.temp;

//return "list" redirect:list.do
//js�� ���� �� @ResponseBody => script (history.back �̿밡��)
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
