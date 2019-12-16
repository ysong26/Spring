package org.zerock.controller;

import javax.inject.Inject;

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
import org.zerock.domain.SearchCriteria;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

	@Inject
	private BoardService service;
	
	@RequestMapping("list")
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		//model.addAttribute("list",service.listCriteria(cri));
		model.addAttribute("list",service.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMaker.setTotalCount(service.listCountCriteria(cri));
		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value="/readPage",method=RequestMethod.GET) //���
	public void readPage(int bno, @ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception { //�̸� ���Ƽ� request����
		model.addAttribute(service.read(bno)); 
	}
	
	@RequestMapping(value="/removePage",method=RequestMethod.POST) //����
	public String remove(int bno,SearchCriteria cri,RedirectAttributes rttr) throws Exception {
		service.remove(bno);
		rttr.addFlashAttribute("msg", "success"); //addFlashAttribute�ӽõ����Ͷ� �ѹ��� ��
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		rttr.addAttribute("searchType",cri.getSearchType());
		rttr.addAttribute("keyword",cri.getKeyword());
		return "redirect:/sboard/list";
	}
	
	@RequestMapping(value="/modifyPage",method=RequestMethod.GET) //����
	public void modifyGET(int bno,SearchCriteria cri, Model model) throws Exception {
		model.addAttribute(service.read(bno));
		model.addAttribute("cri",cri); //cri �����������
	}
	
	@RequestMapping(value="/modifyPage",method=RequestMethod.POST) //����
	public String modifyPOST(BoardVO board, SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		service.modify(board);
		rttr.addFlashAttribute("result", "success"); //addFlashAttribute�ӽõ����Ͷ� �ѹ��� ��
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		rttr.addAttribute("searchType",cri.getSearchType());
		rttr.addAttribute("keyword",cri.getKeyword());
		return "redirect:/sboard/list";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void registerGET() {
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		service.regist(board);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/sboard/list"; ///////////
	}
	
}