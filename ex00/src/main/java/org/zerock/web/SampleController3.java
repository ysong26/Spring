package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController3 {

@RequestMapping("doD")
public String doD(Model model) { //void아니구 String이면
	System.out.println("doD 호출");
	
	ProductVO product = new ProductVO();
	product.setName("Sample Product");
	product.setPrice(12900);
	
	//model.addAttribute("abc",product); //이름표시하면 이름으로감(abc)
	model.addAttribute(product); //ProductVO에서 앞글자 소문자로 바뀐 productVO로 감
	return "productDetail"; //productDetail.jsp로 연결
}


}
