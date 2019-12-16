package org.zerock.web;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController4 {

@RequestMapping("doE")
public String doE(RedirectAttributes rttr) { 
	System.out.println("doE 호출");
	rttr.addFlashAttribute("msg","This is the message!"); //보내기
	return "redirect:/doF";
}
@RequestMapping("doF")
public void doF(@ModelAttribute("msg") String abc) { //받기
	System.out.println("doF 호출");
	System.out.println(abc);
	}
}
