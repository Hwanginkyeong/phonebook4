<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<h1>[Phonebook4]</h1>
     	
     	<h2>전화번호 수정</h2>
     	
     	<p>
     		전화번호를 수정하려면<br>
     		아래항목을 수정하고 "수정"  버튼을 클릭하세요.
     	</p>
     	
     		<div style="width:auto;">
	     		<div style="width:320px;">
					<form action="./update" method="get">
					<input type="hidden" name="personId" value="${personVo.personId}"/><br>
				     	<table border="1">
			     			<tr >
			     				<th align="left">이름(name)</th>										
			     				<th ><input type="text" style="text-align:center;" name="name" value="${personVo.name}"/></th>
			     			</tr>
				    		<tr>
				     			<th align="left">핸드폰(hp)</th>
				     			<th><input type="text" style="text-align:center;" name="hp" value="${personVo.hp}"/></th>
				     		</tr>
							<tr>
				     			<th align="left">회사(company)</th>
				     			<th><input type="text" style="text-align:center;" name="company" value="${personVo.company}"/></th>
				     		</tr>
				     		<tr>
				     			<th align="left">코드(id)</th>
				     			<th>${personVo.personId}</th>
				     		</tr>
				     	</table>
			     		<button type="submit" style="float:right; margin:5px 19px 0px 0px;">수정</button>
			     	</form>
		     	</div>
     			<button type="submit" style="float:left; margin:5px 0px 0px 0px;"onclick="location.href='./list' ">뒤로</button>
     		</div>
</body>
</html>