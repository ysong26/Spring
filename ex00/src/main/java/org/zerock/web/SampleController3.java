package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController3 {

@RequestMapping("doD")
public String doD(Model model) { //void�ƴϱ� String�̸�
	System.out.println("doD ȣ��");
	
	ProductVO product = new ProductVO();
	product.setName("Sample Product");
	product.setPrice(12900);
	
	//model.addAttribute("abc",product); //�̸�ǥ���ϸ� �̸����ΰ�(abc)
	model.addAttribute(product); //ProductVO���� �ձ��� �ҹ��ڷ� �ٲ� productVO�� ��
	return "productDetail"; //productDetail.jsp�� ����
}


}
