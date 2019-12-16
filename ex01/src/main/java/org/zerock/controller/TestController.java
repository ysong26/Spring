package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.NumberVO;



@Controller

public class TestController {
	@RequestMapping("sum")
	public String sumpage() {
		
		return "test/sum";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String resultpage(NumberVO vo, Model model) {
		int c=vo.getNum1()+vo.getNum2();
		model.addAttribute("result",c);
		return "/test/result";
	}
	
}



















