package org.zerock.domain;

public class Criteria {
	private int page; //현재 페이지 번호
	private int perPageNum; //한 페이지에 보여지는 글 개수
	
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
		//0이하 이거나 100초과일 경우 기본값 10으로 만들기 그외는 그대로
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
