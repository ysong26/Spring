package org.zerock.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount; //��ü �� ����(��ü ���������� �˱����ؼ�)
	private int startpage; //���� ���� ������ ��ȣ
	private int endpage;	//���� �� ������ ��ȣ
	private int tempEndPage; //������ ������ ��ȣ
	private boolean prev; //������ �ִ���
	private boolean next; //���İ� �ִ���
	private int displayPageNum=10; //ȭ�� �ϴܿ� ������ ����¡ ���� ex>11 12 13 ... 20 �̸� 10��
	
	private Criteria cri; //���������� ��ȣ, �� �������� ������ �� ����

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}

	public int getTempEndPage() {
		return tempEndPage;
	}

	public void setTempEndPage(int tempEndPage) {
		this.tempEndPage = tempEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	private void calcData() {
	endpage=(int)(Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
	startpage=(endpage-displayPageNum)+1;
	
	tempEndPage = (int) (Math.ceil(totalCount/(double)cri.getPerPageNum()));
	if(endpage > tempEndPage) {
		endpage=tempEndPage;
		}
	
//	if(startpage == 1)
//		prev=false;
//	else
//		prev=true;
	prev = startpage== 1 ? false:true;
	
//	if(endpage * cri.getPerPageNum() >= totalCount)
//		next=false;
//	else
//		next=true;
	
	next = endpage * cri.getPerPageNum() >= totalCount ? false:true;

	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum()).build();
		
		return uriComponents.toString();
	}
	
	public String makeSearch(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.queryParam("searchType", ((SearchCriteria)cri).getSearchType())
				.queryParam("keyword",encoding(((SearchCriteria)cri).getKeyword())).build();
				
		return uriComponents.toString();
	}
	private String encoding(String keyword) {
		if(keyword==null || keyword.trim().length()==0) {
			return "";
		}
		
		
		
		try {
		return URLEncoder.encode(keyword,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
}