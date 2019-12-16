package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

public interface BoardService {
	public void regist(BoardVO vo) throws Exception; //�۵��
	public BoardVO read(Integer bno) throws Exception; //���б� 
	public void modify(BoardVO vo) throws Exception;//�ۼ���
	public void remove(Integer bno) throws Exception;//����
	public List<BoardVO> listAll() throws Exception; //�۸�Ϻ���
	public List<BoardVO> listCriteria(Criteria cri) throws Exception; //�۸�Ϻ���
	public int listCountCriteria (Criteria cri) throws Exception; //��ü �� ���� �˱�
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception; //�˻� �۸�Ϻ���
	public int listSearchCount(SearchCriteria cri) throws Exception; //�˻� ��ü �� ���� �˱�
	
}
