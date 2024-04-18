<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>고객 상세 문의</title>
<link rel="stylesheet" type="text/css" href="./css/cs.css">
</head>
<body>
	<header id="main-header" class="py-2 btn-dark text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>samsamzo 고객 상세 문의</h1>
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
							<h2>문의 상세 보기</h2>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-md-4">
									<p>
										<strong>문의 제목:</strong> ${csDTO.cs_title}
									</p>
								</div>
								<div class="col-md-4">
									<p>
										<strong>문의 일자:</strong> ${csDTO.cs_date}
									</p>
								</div>
							</div>
							<hr>
							<div class="card mt-4">
								<div class="card-header">
									<h3>문의 내용</h3>
								</div>
								<div class="card-body">
									<c:choose>
										<c:when test="${fn:length(csDTO.cs_content) > 50}">
                                            ${fn:substring(csDTO.cs_content, 0, 50)}...
                                        </c:when>
										<c:otherwise>
                                            ${csDTO.cs_content}
                                        </c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
						<div class="card-footer">
							<a href="./CSSelect.cs" class="btn btn-success">문의 목록</a> <a
								href="./CSUpdateView.cs?cs_number=${csDTO.cs_number}"
								class="btn btn-success">문의 수정</a> <a
								href="./CSDeleteView.cs?cs_number=${csDTO.cs_number}"
								class="btn btn-success">문의 삭제</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
