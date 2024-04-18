<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보 페이지</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>

	<header>
		<h1>회원 상세 정보</h1>
	</header>
	
	<main>

		<div>
			<h1>내 정보</h1>
			<ul class="list-group">
			  <li class="list-group-item">회원 이름: ${memberDTO.member_name}</li>
			  <li class="list-group-item">상태: ${memberDTO.member_status}</li>
			  <li class="list-group-item">아이디: ${memberDTO.member_id}</li>
			  <li class="list-group-item">이메일: ${memberDTO.member_email}</li>
			  <li class="list-group-item">핸드폰: ${memberDTO.member_phone}</li>
			  <li class="list-group-item">생년월일: ${memberDTO.member_birth}</li>
			  <li class="list-group-item">주소: ${memberDTO.member_address}</li>
			  <li class="list-group-item">매너온도: ${memberDTO.member_rate}</li>
			  <li class="list-group-item">가입일자: ${memberDTO.member_create}</li>
			</ul>
		</div>

		<div class="btn-group" role="group" aria-label="Basic example">
		  <button type="button" class="btn btn-secondary" onclick="location.href='./index.jsp'">
			메인화면
		  </button>
		  <button type="button" class="btn btn-secondary" onclick="location.href='/MemberUpdateView.me?member_number=${memberDTO.member_number}'">
		  	내 정보 수정
		  </button>
		  <button type="button" class="btn btn-secondary" onclick="location.href='/MemberDeleteView.me?member_number=${memberDTO.member_number}'">
		  	회원 탈퇴
		  </button>
		</div>	

	</main>

</body>
</html>