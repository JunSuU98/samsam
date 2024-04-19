<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>이미지 정보 삭제</title>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/dept_validity.js" type="text/javascript"></script>

<!-- JavaScript 코드 추가 -->
<script type="text/javascript">
    // 이미지 삭제를 확인하는 함수
    function confirmDelete() {
        // confirm 창을 띄워 사용자에게 삭제 여부를 물어봅니다.
        var confirmed = confirm("이미지를 삭제하시겠습니까?");
        // 사용자가 확인을 선택했을 경우
        if (confirmed) {
            // 폼을 제출합니다.
            document.getElementById("sign_img").submit();
        } else {
            // 사용자가 취소를 선택했을 경우 아무 작업도 하지 않습니다.
        }
    }
</script>
</head>
<body>
	<header id="main-header" class="py-2 btn-dark text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>이미지 정보 삭제</h1>
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
							<h5>이미지 삭제</h5>
						</div>
						<div class="card-body">
							<form action="./ImgDelete.im" method="post" id="sign_img">
								<fieldset>
									<div class="form-group row">
										<label for="img_number" class="ml-sm-3 col-form-label">
											이미지 번호 </label>
										<div class="ml-sm-3">

											<input type="text" name="img_number" id="img_number"
												class="form-control form-control-sm bg-white"
												value="${param.img_number}" readonly>
										</div>
									</div>
									<div class="form-group">
										<!-- 삭제 버튼에 직접 onclick 이벤트를 추가하여 confirmDelete 함수를 호출 -->
										<button type="button" class="btn btn-secondary" onclick="confirmDelete()">삭제</button>
										<button type="reset" class="btn btn-secondary">취소</button>
									</div>
								</fieldset>
							</form>
							<div class="row">
								<div class="col-md-4">
									<a href="./ImgSelect.im" class="btn btn-primary btn-block">
										이미지 목록 </a>
								</div>
								<div class="col-md-4">
									<a href="./ImgInsertView.im" class="btn btn-success btn-block">
										이미지 입력 </a>
								</div>
								<div class="col-md-4">
									<a href="./ImgUpdateView.im?img_number=${param.img_number}"
										class="btn btn-warning btn-block"> 이미지 수정 </a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
