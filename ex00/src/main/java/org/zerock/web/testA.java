package org.zerock.web;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ProductVO;
//테스트4로 요청하면 주소창에 테스트5뜨고 내용은 테스트6인거
@Controller
public class testA {

@RequestMapping("test4")
public String doE() { 
	System.out.println("test4");
	return "redirect:/test5";
}
@RequestMapping("test5")
public String doF() { //받기
	System.out.println("test5");
	return "test6";
	}
}
