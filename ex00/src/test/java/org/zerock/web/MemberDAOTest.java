package org.zerock.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class MemberDAOTest {

	@Inject
	private MemberDAO dao;
	
	@Test
	public void testTime() {
		System.out.println(dao.getTime());
	}
	
	@Test
	public void tim() {
		MemberVO vo = new MemberVO();
		vo.setUserid("IDID3");
		vo.setUserpw("PWPW");
		vo.setUsername("Kim");
		vo.setEmail("12345@naver.com");
		
		dao.insertMember(vo);
	}
	
	@Test
	public void readmember() {
		MemberVO vo;
		vo=dao.readMember("IDID");
		System.out.println(vo.getEmail());
	}
	
	@Test
	public void readwithpw() {
		dao.readWithPW("IDID", "PWPW");
	}
	
	@Test
	public void lastMember() {
		MemberVO vo;
		vo=dao.lastMember();
		System.out.println(vo.getEmail());
	}
}
