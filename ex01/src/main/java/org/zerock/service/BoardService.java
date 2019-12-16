package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

public interface BoardService {
	public void regist(BoardVO vo) throws Exception; //글등록
	public BoardVO read(Integer bno) throws Exception; //글읽기 
	public void modify(BoardVO vo) throws Exception;//글수정
	public void remove(Integer bno) throws Exception;//삭제
	public List<BoardVO> listAll() throws Exception; //글목록보기
	public List<BoardVO> listCriteria(Criteria cri) throws Exception; //글목록보기
	public int listCountCriteria (Criteria cri) throws Exception; //전체 글 개수 알기
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception; //검색 글목록보기
	public int listSearchCount(SearchCriteria cri) throws Exception; //검색 전체 글 개수 알기
	
}
