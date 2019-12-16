package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

public interface BoardDAO {
	
	public void create(BoardVO vo) throws Exception; //�� �ۼ�
	public BoardVO read(Integer bno) throws Exception;  //�� �б�
	public void update(BoardVO vo) throws Exception;//�� ������Ʈ
	public void delete(Integer bno) throws Exception;//�� ����
	public List<BoardVO> listALL() throws Exception; //��ü�� ����
	public List<BoardVO> listCriteria(Criteria cri) throws Exception; //Ư�� ������ ��� ����
	public int countPaging(Criteria cri) throws Exception;//��ü ���� ��ȯ
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception; //�˻� �� ��Ϻ���
	public int listSearchCount (SearchCriteria cri) throws Exception; //�˻��� ��ü�� ���� �˱�
}
