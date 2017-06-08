package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_page(
			@RequestParam("id")String id
			, @RequestParam("page")int page
			, Model model
			, HttpSession session){
		
		//자료형이 VO일때는 @ModelAttribute("EmpVO")
		//page=1&id=admin 여기서 매개변수와 parameter name과 type이 같아야 받아올 수 있다. 같으면 @RequestParam("id")생략가능
		model.addAttribute("msg", "id: "+id+"& page: "+page+"안녕 Spring MVC"); //request.setAttribute("", "");
		return "main/main";// /main/main.jsp로 찾아가라
	}
}
