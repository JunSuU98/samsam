<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>고객 문의 등록</title>
<link rel="stylesheet" type="text/css" href="./css/cs.css">
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
									<div class="form-group row">
										<label for="cs_date" class="col-sm-3 col-form-label">문의
											일자</label>
										<div class="col-sm-9">
											<input type="date" name="cs_date" id="cs_date"
												class="form-control">
										</div>
									</div>
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