<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	window.onload = function() {
		const pickedvisitor = document.getElementById("search-visitors");
		pickedvisitor.onclick = function(event) {
			// 	console.log(event.target);
			//	특정 div 영역내에서의 이벤트 처리
			$target = event.target;

			// text area 클릭 시 닉네임 비교를 위한 바로 위 값 가져오기, 현재 세션에 nickname 값이 있으므로 EL태그로 비교
			var nickname = $target.previousElementSibling.value;
			console.log(nickname);
			// 			특정 요소의 위치를 가져온 상태에서 아래와같이해도 원하는 값을 찍어올 수 있음
			//			div(search-visitors) > vno,nickname,content 순으로 생성되어있는상태
			// 			var testname = $target.parentElement;
			// 			console.log(testname.nickname.value);

			//  nodeName옵션은 해당(여기서는 클릭한 태그 name을 말한다.
			if ($target.nodeName == "TEXTAREA" && $target.readOnly
					&& (nickname == "${nickname}")) {
				var result = confirm("수정하시겠습니까?");
				console.log(result);
				if (result) {
					$target.readOnly = false;
				}
			}
		}
	}
	function updateVisitor($this) {
		console.log($this)
		var form = $this.parentElement;
		form.action = "update";
		form.method = "post";
		form.submit();
	}
	function deleteVisitor($this) {
		console.log($this)
		var form = $this.parentElement;
		form.action = "delete";
		form.method = "post";
		form.submit();
	}
</script>

</head>
<body>

		${nickname }님 환영합니다.
	<h1>방명록</h1>
	<form action="regist" method="post">
		<input type="hidden" name="nickname" value="${nickname}">
		<textarea rows="10" cols="40" name="content"></textarea>
		<br> <input type="submit" value="등록" />
	</form>

	<div id="search-visitors">
		<c:forEach items="${vlist }" var="vvo">
			<form>
				<input type="hidden" name="vno" value="${vvo.vno}" /> 
				<span> ${vvo.nickname} - ${vvo.regdate}</span> <br>
				<input type="hidden" name="nickname" value="${vvo.nickname}" /> 
				<textarea rows="10" cols="40" name="content" readonly>${vvo.content}</textarea>
				<br> 
<!-- 				onclick에 명시된 함수에 this를 파라미터로 넘기면 자기자신의 정보를 아규먼트로 가지고 이동한다. -->
				<c:if test="${nickname eq vvo.nickname}">
					<a href="#"  onclick="updateVisitor(this)">수정</a> 
					<a href="#"  onclick="deleteVisitor(this)">삭제</a>
				</c:if>
			</form>
		</c:forEach>
	</div>
</body>
</html>