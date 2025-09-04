<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <jsp:include page="/WEB-INF/views/include/bs5.jsp" />
  <title>memberMain.jsp</title>
</head>
<body>

<p><br/></p>
<div class="container">
  <h2>이곳은 memberMain.jsp 입니다.</h2>
  <div>(아이디 : ${sMid} / 등급 : ${strLevel} : 세션 : ${sId})</div>
  <hr/>
  <div>
  <img alt="" src="${ctp}/images/1.jpg" width="400px" />
  </div>
   <hr/>
  <div>
  	<a href="${ctp}/member/logout" class="btn btn-success">로그아웃</a>
  	<a href="${ctp}/" class="btn btn-dark">홈으로</a>
  </div>
</div>
<p><br/></p>

</body>
</html>