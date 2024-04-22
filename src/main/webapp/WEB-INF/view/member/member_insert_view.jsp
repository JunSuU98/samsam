<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min.js" type="text/javascript"></script>
<script src="./js/validity.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		
		$("#db_id_check").click(function() {
			var id = $('#member_id').val();
			$.ajax({
				url : './IdCheck.me',
				type : 'get',
				
				data : {
					member_id : id
				},
				success : function(result){
					console.log("아이디 값 - " + result);
					
					if($.trim(result) == 1){
						alert("이미 등록된 아이디입니다.");
						$('member_id').focus();
					} else {
						alert("사용할 수 있는 아이디입니다.");
						$('#id_check').val("1");
						$('#member_password').focus();
					}
				}
			});
		});
		
	});
	
</script>

</head>
<body>
<header id="main-header" class="py-2 bg-dark text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <a href="/ProductSelect.pr">
					<h1>중고 웹 솔루션</h1>
                </a>
            </div>
        </div>
    </div>
</header>

	<header>
		<h1>회원 가입</h1>
	</header>
	
	<main>
	
		<form action="/MemberInsert.me" method="post" id="sign_up_form">
		
		  <div class="mb-3 row">
			<label for="member_id" class="col-sm-2 col-form-label">아이디</label>
			<div class="col-sm-10">
			  <input type="text" class="form-control" id="member_id" name="member_id">
			</div>

			<button type="button" class="btn btn-primary" id="db_id_check">중복확인</button>
			<input type="hidden" class="form-control" id="id_check" name="id_check" value="0">

		  </div>	
		
		  <div class="mb-3 row">
			<label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-sm-10">
			  <input type="password" class="form-control" id="member_password" name="member_password">
			</div>
		  </div>	
		
		  <div class="mb-3 row">
			<label for="member_name" class="col-sm-2 col-form-label">이름</label>
			<div class="col-sm-10">
			  <input type="text" class="form-control" id="member_name" name="member_name">
			</div>
		  </div>
		  
		  <div class="mb-3 row">
			<label for="member_email" class="col-sm-2 col-form-label">이메일</label>
			<div class="col-sm-10">
			  <input type="email" class="form-control" id="member_email" name="member_email">
			</div>
		  </div>
		  
		  <div class="mb-3 row">
			<label for="member_phone" class="col-sm-2 col-form-label">전화 번호</label>
			<div class="col-sm-10">
			  <input type="text" class="form-control" id="member_phone" name="member_phone">
			</div>
		  </div>
		  
		  <div class="mb-3 row">
			<label for="member_address" class="col-sm-2 col-form-label">주소</label>
			<div class="col-sm-10">
			  <input type="text" class="form-control" id="member_address" name="member_address">
			</div>
		  </div>
		  
		  <div class="mb-3 row">
			<label for="member_birth" class="col-sm-2 col-form-label">생년월일</label>
			<div class="col-sm-10">
			  <input type="date" class="form-control" id="member_birth" name="member_birth">
			</div>
		  </div>
		  
		  <input type="hidden" class="form-control" id="member_create" name="member_create">
		  <script type="text/javascript">
		  	document.getElementById('member_create').value = new Date().toISOString().split('T')[0];
		  </script>

		  <div class="col-auto">
			<button type="button" onclick="submitValid()" class="btn btn-primary mb-3">회원가입</button>
			<button type="reset" class="btn btn-danger mb-3" onclick="window.history.back()">취소</button>
		  </div> 
		  
		</form>

	</main>
	
	<script type="text/javascript">
	
		var id_check_input = document.getElementById('id_check');
	
		function submitValid() {
			if(id_check_input.value == 0){
				alert("ID 중복검사를 해주세요");
				return false;
			} else {
				document.getElementById("sign_up_form").submit();
			}
		}
	
		$("input[id='member_id']").on("change keyup paste", function(){
			$("#id_check").val(0);
		});

	</script>

</body>
</html>