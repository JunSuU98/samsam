<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>고객 문의</title>
<link rel="stylesheet" type="text/css" href="./css/cs.css">
</head>
<body>
	<header id="main-header" class="py-2 text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>samsamzo 고객 문의</h1>
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
							<h2>문의 목록</h2>
						</div>
						<div class="card-body">
							<table class="table table-hover">
								<thead class="thead-light">
									<tr class="text-center">
										<th>문의 번호</th>
										<th>문의 제목</th>
										<th>문의 일자</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="arrayList" items="${arrayList}">
										<tr class="text-center">
											<td>${arrayList.cs_number}</td>
											<td>${arrayList.cs_title}</td>
											<td>${arrayList.cs_date}</td>
											<td><a
												href="./CSSelectDetail.cs?cs_number=${arrayList.cs_number}"
												class="btn btn-outline-info"> 문의 상세 보기 </a></td>
										</tr>
									</c:forEach>
									<c:if test="${empty arrayList}">
										<tr>
											<td colspan="4">등록된 문의가 없습니다.</td>
										</tr>
									</c:if>
								</tbody>
							</table>
							<div>
								<a href="./CSInsertView.cs" class="btn btn-success btn-block">
									문의 입력 </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>