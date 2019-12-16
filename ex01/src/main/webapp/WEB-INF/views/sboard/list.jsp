<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>


<!-- Main content -->

<div class="box-body">
 <select name="searchType"> <!-- 새로고침해도 값 유지되게 -->
 	<option value="n" 
 		<c:out value="${cri.searchType==null? 'selected' : '' }"/>>---</option>
 	<option value="t"
 		<c:out value="${cri.searchType=='t'? 'selected' : '' }"/>>제목</option>
 	<option value="c"
 		<c:out value="${cri.searchType=='c'? 'selected' : '' }"/>>내용</option>
 	<option value="w"
 		<c:out value="${cri.searchType=='w'? 'selected' : '' }"/>>작성자</option>
 	<option value="tc"
 		<c:out value="${cri.searchType=='tc'? 'selected' : '' }"/>>제목+내용</option>
 	<option value="cw"
 		<c:out value="${cri.searchType=='cw'? 'selected' : '' }"/>>내용+작성자</option>
 	<option value="tcw"
 		<c:out value="${cri.searchType=='tcw'? 'selected' : '' }"/>>제목+내용+작성자</option>
 </select>

	<input type="text" name="keyword" id="keywordInput" value=${cri.keyword}>
	<button id="searchBtn">검색</button>
	<button id="newBtn">글쓰기</button>
</div>

<script>
	$(document).ready(
		function(){
			$('#searchBtn').on("click",function(event){
				self.location="list"+'${pageMaker.makeQuery(1)}'+
				"&searchType="+$("select option:selected").val()+
				"&keyword=" +encodeURIComponent($('#keywordInput').val());
			});
			$('#newBtn').on('click',function(evt){
				self.location="register";
			});
		});

</script>



<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">전체 게시글</h3>
				</div>
				<div class="box-body">
				
<table class="table table-bordered">
	<tr>
		<th style="width: 10px">글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th style="width: 40px">조회수</th>
	</tr>


<c:forEach items="${list}" var="boardVO">

	<tr>
		<td>${boardVO.bno}</td>
		<td><a href='/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page) 
		}&bno=${boardVO.bno}'> ${boardVO.title}</a></td>
		<td>${boardVO.writer}</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
				value="${boardVO.regdate}" /></td>
		<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
	</tr>

</c:forEach>

</table>

<div class="text-center">
<ul class ="pagination">

<c:if test="${pageMaker.prev}">
	<li><a href="list${pageMaker.makeSearch(1)}">&laquo;&laquo;</a></li>
	<li><a href="list${pageMaker.makeSearch(pageMaker.startpage-1)}">&laquo;</a></li>
</c:if>

<c:forEach begin="${pageMaker.startpage}" end="${pageMaker.endpage}" var="idx">
<li
 <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
 <a href="list${pageMaker.makeSearch(idx)}"> ${idx} &nbsp;&nbsp;</a>
 </li>
</c:forEach>

<c:if test="${pageMaker.next}">
	<li><a href="list${pageMaker.makeSearch(pageMaker.endpage+1)}">&raquo;</a></li>
	<li><a href="list${pageMaker.makeSearch(pageMaker.tempEndPage)}">&raquo;&raquo;</a></li>
</c:if>

<li>
<br><br>

<form method="GET">
<input type="text" name="page">
<input type="submit" value="이동">
</form>

</li>
</ul>
</div>
	</div>
		<!-- /.box-body -->
			<div class="box-footer"></div>
			<!-- /.box-footer-->
	</div>
	</div>
	<!--/.col (left) -->
	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
    
var result ='${result}'
if(result=='success'){
	alert("글이 등록되었습니다.");
}

var result ='${msg}'
	if(result=='success'){
		alert("글이 삭제되었습니다.");
}
    </script>

<%@include file="../include/footer.jsp"%>
