package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

@RequestMapping("doA") 
public void doA() { //void는 doA.jsp로연결
	System.out.println("doA 호출");
}

@RequestMapping("doB")
public void doB() {
	System.out.println("doB 호출");
}

}
