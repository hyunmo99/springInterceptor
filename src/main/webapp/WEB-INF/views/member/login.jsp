<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <jsp:include page="/WEB-INF/views/include/bs5.jsp" />
  <title>login.jsp</title>
</head>
<body>

<p><br/></p>
<div class="container">
  <h2>이곳은 login.jsp 입니다.</h2>
    <hr/>
  <div>
    <form method="post">
      레벨 : 
      <select name="level" class="form-select mb-3">
        <option value="0">관리자</option>
        <option value="1">우수회원</option>
        <option value="2">정회원</option>
        <option value="3">준회원</option>
      </select>
      아이디 <input type="text" name="mid" value="admin" class="form-control mb-3"/>
      비밀번호 <input type="password" name="pwd" value="1234" class="form-control mb-3"/>
      <input type="submit" value="로그인" class="btn btn-success"/>
      <input type="button" value="회원가입" onclick="location.href='${ctp}/member/join';" class="btn btn-primary"/>
      <input type="button" value="방명록" onclick="location.href='${ctp}/guest/guestList';" class="btn btn-info"/>
    </form>
  </div>
  <hr/>
  <div><a href="${ctp}/" class="btn btn-success">돌아가기</a></div>
</div>
<p><br/></p>

</body>
</html>