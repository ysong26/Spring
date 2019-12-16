package org.zerock.domain;

public class SearchCriteria extends Criteria {
	private String searchType; //검색의 종류
	private String keyword; //검색어
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return super.toString()+ //상속(Criteria)도 사용
				"SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
	
	
}
