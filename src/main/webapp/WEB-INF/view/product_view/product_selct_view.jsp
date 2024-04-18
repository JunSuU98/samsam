<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<header id="main-header" class="py-2 bg-dark text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1>상품</h1>
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
                    <div class="card-header bg-primary text-white">
                        <h5>상품 목록</h5>
                    </div>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead class="thead-light">
                                <tr class="text-center">
                                    <th>상품 번호</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="arrayList" items="${arrayList}">
                                    <tr class="text-center">
                                        <td>${arrayList.product_number}</td>
                                        <td>
                                            <a href="./ProductSelectDetail.pr?product_number=${arrayList.product_number}" class="btn btn-outline-info">
                                                상품 상세 보기
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:if test="${empty arrayList}">
                                    <tr>
                                        <td colspan="4">등록된 상품이 없습니다.</td>
                                    </tr>
                                </c:if>
                            </tbody>
                        </table>
                        <div>
                            <a href="./ProductInsertView.pr" class="btn btn-success btn-block">상품 등록</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>