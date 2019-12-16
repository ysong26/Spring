package org.zerock.domain;

public class Criteria {
	private int page; //���� ������ ��ȣ
	private int perPageNum; //�� �������� �������� �� ����
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10; 
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page<=0) 
			this.page=1;
		else
			this.page = page;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		//0���� �̰ų� 100�ʰ��� ��� �⺻�� 10���� ����� �׿ܴ� �״��
		if(perPageNum<=0 || perPageNum>100)
			this.perPageNum=10;
		else
			this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (page-1)*10;
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
}
