package org.zerock.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (
		locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class BoardServiceTest {

	@Inject
	private BoardService service;
	
	@Test
	public void testRead() throws Exception {
		service.read(4);
	}
	
	@Test
	public void testwriter() throws Exception {
		BoardVO vo= new BoardVO();
		vo.setTitle("s力格1");
		vo.setContent("s趁公");
		vo.setWriter("s剧泅老");
		service.regist(vo);
	}
	
}













