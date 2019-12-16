package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.service.BoardService;


@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void registerGET() {
		logger.info("�۵�� ��û(GET)...............");
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("�۵�� ��û(POST)...............");
		logger.info(board.toString());
		service.regist(board);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/listPage"; ///////////
	}
//	@RequestMapping(value="/listAll",method=RequestMethod.GET)
//	public void listALL(Model model) throws Exception{
//		logger.info("�Խñ� ��û");
//		model.addAttribute("list",service.listAll());
//	}
	
	@RequestMapping(value="/listCri",method=RequestMethod.GET)
	public void listALL(Criteria cri, Model model) throws Exception{
		logger.info("�Խñ� ��û");
		model.addAttribute("list",service.listCriteria(cri));
	}
	
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception{
		logger.info("�ϴ� ������ �� ���� ���� ��û");
		model.addAttribute("list",service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		//pageMaker.setTotalCount(131);
		model.addAttribute("pageMaker", pageMaker);
	}
	
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno)); //�̸������ؼ� boardVO��(read.jsp)
	}
	
	@RequestMapping(value="/readPage",method=RequestMethod.GET) //���
	public void readPage(int bno, @ModelAttribute("cri") Criteria cri,Model model) throws Exception { //�̸� ���Ƽ� request����
		model.addAttribute(service.read(bno)); 
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST) //����
	public String remove(int bno,Criteria cri,RedirectAttributes rttr) throws Exception {
		service.remove(bno);
		rttr.addFlashAttribute("msg", "success"); //addFlashAttribute�ӽõ����Ͷ� �ѹ��� ��
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.GET) //����
	public void modifyGET(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST) //����
	public String modifyPOST(BoardVO board, Criteria cri, RedirectAttributes rttr) throws Exception{
		logger.info("mod post....");
		service.modify(board);
		rttr.addFlashAttribute("result", "success"); //addFlashAttribute�ӽõ����Ͷ� �ѹ��� ��
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		return "redirect:/board/listPage";
	}
}



















