<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>고객 문의 등록</title>
<link rel="stylesheet" type="text/css" href="./css/cs.css">
<script>
	// 페이지가 로드될 때 실행되는 함수
	window.onload = function() {
		// 오늘 날짜를 가져와서 설정
		var today = new Date();
		var year = today.getFullYear();
		var month = ('0' + (today.getMonth() + 1)).slice(-2);
		var day = ('0' + today.getDate()).slice(-2);
		var formattedDate = year + '-' + month + '-' + day;

		// 숨겨진 입력란에 현재 날짜 설정
		document.getElementById('cs_date').value = formattedDate;
	};
</script>
</head>
<body>
	<header id="main-header" class="py-2 text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>samsamzo 고객 문의 등록</h1>
				</div>
			</div>
		</div>
	</header>
	<section class="py-4 mb-4 bg-light"></section>
	<section id="department">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h2>문의 등록</h2>
						</div>
						<div class="card-body">
							<form action="./CSInsert.cs" method="post"
								id="customer_inquiry_form">
								<fieldset>
									<div class="form-group row">
										<label for="cs_title" class="col-sm-3 col-form-label">문의
											제목</label>
										<div class="col-sm-9">
											<input type="text" name="cs_title" id="cs_title"
												class="form-control">
										</div>
									</div>
									<!-- 날짜 입력란을 숨겨진 필드로 설정 -->
									<input type="hidden" name="cs_date" id="cs_date">
									
									<input type="hidden" name="member_number" id="member_number" value="${sessionScope.member_number}">
									
									<div class="form-group row">
										<label for="cs_content" class="col-sm-3 col-form-label">문의
											내용</label>
										<div class="col-sm-9">
											<textarea name="cs_content" id="cs_content" rows="5"
												class="form-control"></textarea>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-9 offset-sm-3">
											<button type="submit" class="btn btn-success">문의 등록</button>
											<button type="reset" class="btn btn-secondary">취소</button>
										</div>
									</div>
								</fieldset>
							</form>
						</div>
						<div class="card-footer">
							<a href="./CSSelect.cs" class="btn btn-success btn-block">문의
								목록</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
