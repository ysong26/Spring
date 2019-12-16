package org.zerock.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ComonExceptionAdvice {

//@ExceptionHandler(Exception.class)
//public String common(Exception e) {
//	System.out.println(e.toString());
//	return "error_common";
//	}
	
@ExceptionHandler(Exception.class)
public ModelAndView errorModelAndView(Exception e) {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("/error_common");
	mav.addObject("exception",e);
	
	return mav;
	}
}
