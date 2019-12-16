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
		logger.info("글등록 요청(GET)...............");
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("글등록 요청(POST)...............");
		logger.info(board.toString());
		service.regist(board);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/listPage"; ///////////
	}
//	@RequestMapping(value="/listAll",method=RequestMethod.GET)
//	public void listALL(Model model) throws Exception{
//		logger.info("게시글 요청");
//		model.addAttribute("list",service.listAll());
//	}
	
	@RequestMapping(value="/listCri",method=RequestMethod.GET)
	public void listALL(Criteria cri, Model model) throws Exception{
		logger.info("게시글 요청");
		model.addAttribute("list",service.listCriteria(cri));
	}
	
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception{
		logger.info("하단 페이지 바 까지 보기 요청");
		model.addAttribute("list",service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		//pageMaker.setTotalCount(131);
		model.addAttribute("pageMaker", pageMaker);
	}
	
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno)); //이름생략해서 boardVO로(read.jsp)
	}
	
	@RequestMapping(value="/readPage",method=RequestMethod.GET) //목록
	public void readPage(int bno, @ModelAttribute("cri") Criteria cri,Model model) throws Exception { //이름 같아서 request생략
		model.addAttribute(service.read(bno)); 
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST) //삭제
	public String remove(int bno,Criteria cri,RedirectAttributes rttr) throws Exception {
		service.remove(bno);
		rttr.addFlashAttribute("msg", "success"); //addFlashAttribute임시데이터라 한번만 뜸
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.GET) //수정
	public void modifyGET(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST) //수정
	public String modifyPOST(BoardVO board, Criteria cri, RedirectAttributes rttr) throws Exception{
		logger.info("mod post....");
		service.modify(board);
		rttr.addFlashAttribute("result", "success"); //addFlashAttribute임시데이터라 한번만 뜸
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		return "redirect:/board/listPage";
	}
}



















