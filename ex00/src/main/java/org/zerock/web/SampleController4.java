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
	System.out.println("doE ȣ��");
	rttr.addFlashAttribute("msg","This is the message!"); //������
	return "redirect:/doF";
}
@RequestMapping("doF")
public void doF(@ModelAttribute("msg") String abc) { //�ޱ�
	System.out.println("doF ȣ��");
	System.out.println(abc);
	}
}
