<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>고객 문의 삭제</title>
<link rel="stylesheet" type="text/css" href="./css/cs.css">
</head>
<body>
	<header id="main-header" class="py-2 text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>samsamzo 고객 문의 삭제</h1>
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
							<h2>문의 삭제</h2>
						</div>
						<div class="form-container">
							<form action="./CSDelete.cs" method="post"
								id="customer_inquiry_form">
								<fieldset>
									<div class="form-group row">
										<label for="cs_number" class="ml-sm-3 col-form-label">문의
											번호</label>
										<div class="col-sm-9">
											<input type="text" name="cs_number" id="cs_number"
												class="form-control">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-9 offset-sm-3 button-group">
											<button type="submit" class="btn btn-success">문의 삭제</button>
											<button type="reset" class="btn btn-secondary">취소</button>
										</div>
									</div>
								</fieldset>
							</form>
						</div>
						<div class="row">
							<div class="col-md-4">
								<a href="./CSSelect.cs" class="btn btn-success btn-block">
									문의 목록 </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>