package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.CalVO;

@Controller
public class test1 {

	@RequestMapping("test")
	public  @ResponseBody CalVO abc() { //void아니구 String이면
		int a = 9;
		int b = 3;
		
		CalVO calvo=new CalVO();
		calvo.setAdd(a+b);
		calvo.setSub(a-b);
		calvo.setMul(a*b);
		calvo.setDivi(a/b);
		
		return calvo;
	}

	
@RequestMapping("test2") 
public void test2() {
	}
}
