package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.NumberVO;



@Controller

public class TestController2 {
	@RequestMapping("test/test1")
	public String sumpage() {
		return "test/test1";
	}
	
	@RequestMapping(value="test/test1",method=RequestMethod.POST)
	public String resultpage(NumberVO vo, Model model) {
		int c=vo.getNum1()+vo.getNum2();
		int a=vo.getNum1();
		int b=vo.getNum2();
		model.addAttribute("num1",a);
		model.addAttribute("num2",b);
		model.addAttribute("result",c);
		return "/test/test2";
	}
	
//	@RequestMapping(value="test/test1",method=RequestMethod.POST)
//	public String cal(NumberVO number, Model aaa) {
//		int result=number.getNum1()+number.getNum2();
//		aaa.addAttribute("num1", number.getNum1());
//		aaa.addAttribute("num2", number.getNum2());
//		aaa.addAttribute("result",result);
//		return "/test/test2";
//	}
	
}



















