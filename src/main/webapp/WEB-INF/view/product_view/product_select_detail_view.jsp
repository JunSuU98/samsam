<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상세 상품정보</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<header id="main-header" class="py-2 bg-dark text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1>상세 상품 정보</h1>
            </div>
        </div>
    </div>
</header>
<section class="py-4 mb-4 bg-light"></section>
<section id="productkdb">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h5>상품 상세 보기</h5>
                    </div>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead class="thead-light">
                                <tr class="text-center">
                                    <th>상품 번호</th>
                                    <th>상품 업로드</th>
                                    <th>상품 업데이트</th>
                                    <th>상품 제목</th>
                                    <th>상품 가격</th>
                                    <th>상품 내용</th>
                                    <th>상품 상태</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="text-center">
                                    <td>${productDTO.product_number}</td>
                                    <td>${productDTO.product_upload}</td>
                                    <td>${productDTO.product_update}</td>
                                    <td>${productDTO.product_title}</td>
                                    <td>${productDTO.product_price}</td>
                                    <td>${productDTO.product_content}</td>
                                    <td>${productDTO.product_status}</td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="row">
                            <div class="col-md-4">
                                <a href="./ProductSelect.pr" class="btn btn-primary btn-block">
                                    상품 목록
                                </a>
                            </div>
                            <div class="col-md-4">
                                <a href="./ProductUpdate.pr?product_number=${productDTO.product_number}" class="btn btn-warning btn-block">
                                    상품 수정
                                </a>
                            </div>
                            <div class="col-md-4">
                                <a href="./ProductDeleteView.pr?product_number=${productDTO.product_number}" class="btn btn-danger btn-block">
                                    상품 삭제
                                </a>
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
