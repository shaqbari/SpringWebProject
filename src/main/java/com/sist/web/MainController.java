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
		
		//�ڷ����� VO�϶��� @ModelAttribute("EmpVO")
		//page=1&id=admin ���⼭ �Ű������� parameter name�� type�� ���ƾ� �޾ƿ� �� �ִ�. ������ @RequestParam("id")��������
		model.addAttribute("msg", "id: "+id+"& page: "+page+"�ȳ� Spring MVC"); //request.setAttribute("", "");
		return "main/main";// /main/main.jsp�� ã�ư���
	}
}
