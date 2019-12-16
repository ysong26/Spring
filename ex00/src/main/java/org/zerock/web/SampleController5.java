package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController5 {

@RequestMapping("doJSON")
public @ResponseBody ProductVO doJSON(Model model) {
	System.out.println("doJSON »£√‚");
	
	ProductVO product = new ProductVO();
	product.setName("Sample Product");
	product.setPrice(12900);
	
	return product; 
}


}
