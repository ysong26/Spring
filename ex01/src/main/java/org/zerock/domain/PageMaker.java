package org.zerock.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount; //전체 글 개수(전체 페이지수를 알기위해서)
	private int startpage; //현재 시작 페이지 번호
	private int endpage;	//현재 끝 페이지 번호
	private int tempEndPage; //마지막 페이지 번호
	private boolean prev; //이전이 있는지
	private boolean next; //이후가 있는지
	private int displayPageNum=10; //화면 하단에 보여줄 페이징 개수 ex>11 12 13 ... 20 이면 10개
	
	private Criteria cri; //현재페이지 번호, 한 페이지에 보여줄 글 개수

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