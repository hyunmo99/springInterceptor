<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>Home</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <jsp:include page="/WEB-INF/views/include/bs5.jsp" />
</head>
<body>
<br/>
<div class="container">
	<P>  The time on the server is ${serverTime}. </P>
	<hr/>
	  <p>guest
	    <a href="${ctp}/guest/guestList" class="btn btn-success btn-sm">방명록리스트</a>
	    <a href="${ctp}/guest/guestInput" class="btn btn-primary btn-sm">방명록글쓰기</a>
	    <a href="${ctp}/guest/guestUpdate" class="btn btn-warning btn-sm">방명록글수정</a>
	    <a href="${ctp}/guest/guestDelete" class="btn btn-danger btn-sm">방명록글삭제</a>
	  </p>
	  <p> member
	  	<c:if test="${sMid==null || sMid==''}">
	    	<a href="${ctp}/member/login" class="btn btn-success btn-sm">로그인</a>
	    </c:if>
	    <c:if test="${sMid!=null && sMid!=''}">
		    <a href="${ctp}/member/logout" class="btn btn-success btn-sm">로그아웃</a>
	    </c:if>
	  </p>
	  <p> member
	  	<c:if test="${sMid==null || sMid==''}">
	    	<a href="${ctp}/member/join" class="btn btn-success btn-sm">회원가입</a>
		    <a href="${ctp}/member/joinOk" class="btn btn-success btn-sm">회원가입Ok</a>
	    </c:if>
	    <a href="${ctp}/member/idCheck" class="btn btn-success btn-sm">아이디체크</a>
	    <a href="${ctp}/member/nickCheck" class="btn btn-success btn-sm">닉네임체크</a>
	  </p>
	  <p> member
	    <a href="${ctp}/member/memberMain" class="btn btn-success btn-sm">회원메인방</a>
	    <a href="${ctp}/member/memberUpdate" class="btn btn-success btn-sm">회원정보수정</a>
	    <a href="${ctp}/member/memberDelete" class="btn btn-danger btn-sm">회원정보삭제</a>
	    <a href="${ctp}/member/memberList" class="btn btn-success btn-sm">회원List</a>
	    <a href="${ctp}/member/memberSearch" class="btn btn-success btn-sm">회원정보Search</a>
	  </p>
	  <p> board
	    <a href="${ctp}/board/boardList" class="btn btn-success btn-sm">게시판리스트</a>
	    <a href="${ctp}/board/boardInput" class="btn btn-primary btn-sm">게시판글쓰기</a>
	    <a href="${ctp}/board/boardContent" class="btn btn-success btn-sm">게시판글내용보기</a>
	    <a href="${ctp}/board/boardUpdate" class="btn btn-success btn-sm">게시판글수정</a>
	    <a href="${ctp}/board/boardDelete" class="btn btn-danger btn-sm">게시판글삭제</a>
	  </p>
	  <p> pds
	    <a href="${ctp}/pds/pdsList" class="btn btn-success btn-sm">자료실리스트</a>
	    <a href="${ctp}/pds/pdsInput" class="btn btn-primary btn-sm">자료실글쓰기</a>
	    <a href="${ctp}/pds/pdsUpdate" class="btn btn-success btn-sm">자료글수정</a>
	    <a href="${ctp}/pds/pdsDelete" class="btn btn-danger btn-sm">자료글삭제</a>
	  </p> 
	  <p> admin 
	    <a href="${ctp}/admin/adminMain" class="btn btn-success btn-sm">관리자메뉴</a>
	    <a href="${ctp}/admin/statistics" class="btn btn-success btn-sm">방문/게시글 통계(스테티스딕스)</a>
	    <a href="${ctp}/admin/noticeWrite" class="btn btn-primary btn-sm">공지사항글쓰기</a>
	  </p>
	<hr/>
	<h3>* 회원관리 인터셉터설계 *</h3>
	<p>회원등급 - 0:관리자, 1:우수회원, 2:정회원, 3:준회원, 99:비회원, 999:탈퇴회원</p>
	<div>- 인증(Authentication) / 인가(Authorization)</div>
	<pre>
	<b>
		- 방명록(guest)의 글은 모두 볼수 있으며, 방명록 '글쓰기/수정/삭제'는 로그인한 회원만 작업할수 있다.
		- 회원가입/아이디중복체크,닉네임중복체크,로그인창, 방명록 은 모든이들이 접속가능처리
		- 게시판(board)은 로그인한 회원만 접속가능, 모든회원들이 사용할수 있다. 단, 준회원은 게시판 목록보기(boardList)만 가능
		- 자료실(pds)은 정회원 이상만 사용가능, 단, 정회원은 '업로드/수정/삭제'할 수 없다.
		- 회원정보수정/삭제는 로그인된 모든회원 가능하고, 회원정보검색과 리스트보기는 정회원이상만 가능하다. 
		- 관리자메뉴는 관리자만 접속가능하게 처리
		
		모든사용자가 사용할수 있는 경로?
		- login / loginOk / logout / idCheck / nickCheck / join / joinOk
		
		MemberInterceptor를 통해서 제한적인 처리를 하는 경로?
		- memberMain / memberUpdate / memberUpdateOk / memberDelete /memberList / memberSearch
		
		만들어야할 jsp파일?
		login / logout / idCheck / nickCheck / join / joinOk
		memberMain / memberUpdate / memberDelete / memberList / memberSearch
		guestList / guestInput / guestUpdate / guestDelete 
		boardList / boardInput / boardUpdate / boardDelete / boardSearch
		pdsList / pdsInput / pdsUpdate / pdsDelete
		adminMain / noticeWrite / statistics
		
		메세지 처리파일경로? login / logout / joinOk / memberUpdateOk / guestInput / boardInput / pdsInput
	</b>   
	
	※ 회원로그인시처리내용 : 
	  접속아이디의 첫글자가 'a'로 시작할 경우이면서 비밀번호가 '1234'인 경우만 회원으로 간주된다.
	</pre>

</div>
</body>
</html>
