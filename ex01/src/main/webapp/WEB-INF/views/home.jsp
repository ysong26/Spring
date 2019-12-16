<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@include file="include/header.jsp" %>

<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-tile">한글 테스트</h3>
					
					<a href="board/register">글등록</a><br>
					
					<a href="board/listPage">게시글 목록</a><br>
					
					<a href="sboard/list">검색 게시글 목록</a>
				</div>
			</div>
		</div>
	</div>
</section>

<%@include file="include/footer.jsp" %>
