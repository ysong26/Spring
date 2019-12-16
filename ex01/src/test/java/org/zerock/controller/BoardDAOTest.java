package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.BoardDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (
		locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class BoardDAOTest {

	@Inject
	private BoardDAO dao;
	
	@Inject
	private BoardDAO svc;
	
	@Test
	public void createtest() throws Exception {
		BoardVO vo= new BoardVO();
		vo.setTitle("제목1");
		vo.setContent("냉무");
		vo.setWriter("양현일");
		dao.create(vo);
	}
	
	@Test
	public void readtest() throws Exception {
		BoardVO vo=dao.read(2);
		System.out.println(vo.getWriter());
	
	}
	@Test
	public void updatetest() throws Exception {
		BoardVO vo= new BoardVO();
		vo.setBno(2);
		vo.setTitle("진짜수정제목");
		vo.setContent("진짜수정냉무");
		dao.update(vo);
	}
	@Test
	public void listAllTest() throws Exception {
		List<BoardVO> list=dao.listALL();
		for(BoardVO vo :list) {
			System.out.println(vo.getTitle());
		}
		
	}
	
	@Test
	public void deleteTest() throws Exception {
		dao.delete(2);
	}
	
	@Test
	public void listPageTest() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		List<BoardVO> list=dao.listCriteria(cri);
		for(BoardVO vo :list) {
			System.out.println(vo.getTitle());
		}
	}
	
	@Test
	public void listPageTest2() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO> list=svc.listCriteria(cri);
		for(BoardVO vo :list) {
			System.out.println(vo.getTitle());
		}
	}
	
	@Test
	public void testURI() {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/board/read").queryParam("bno", 12)
				.queryParam("perPageNum", 20).build();
		System.out.println(uriComponents);
	}
	
	@Test
	public void testDynamic1() throws Exception {
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("수정");
		cri.setSearchType("c");//t제목 c내용
		cri.setPerPageNum(10);
		List<BoardVO> list=dao.listSearch(cri);
		for(BoardVO vo :list) {
			System.out.println(vo.getTitle());
		}
	}
	
	@Test
	public void testDynamic2() throws Exception {
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("수정");
		cri.setSearchType("c");//t제목 c내용
		cri.setPerPageNum(10);
		System.out.println(dao.listSearchCount(cri));
	}
	
}














