package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

@RequestMapping("doA") 
public void doA() { //void�� doA.jsp�ο���
	System.out.println("doA ȣ��");
}

@RequestMapping("doB")
public void doB() {
	System.out.println("doB ȣ��");
}

}
