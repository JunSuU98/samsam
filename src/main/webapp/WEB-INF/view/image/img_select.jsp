<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>이미지 관리</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
    <header id="main-header" class="py-2 btn-dark text-white">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1>이미지 관리</h1>
                </div>
            </div>
        </div>
    </header>

    <section class="py-4 mb-4 bg-light"></section>
    <section id="department">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="card-header">
                        <h5>이미지 목록</h5>
                    </div>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead class="thead-light">
                                <tr class="text-center">
                                    <th>이미지 번호</th>
                                    <th>이미지 업로드 날짜</th>
                                    <th>이미지 수정 날짜</th>
                                    <th>미리보기</th>
                                    <th></th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="arrayList" items="${arrayList}">
                                    <tr class="text-center">
                                        <td>${arrayList.img_number}</td>
                                        <td>${arrayList.img_upload}</td>
                                        <td>${arrayList.img_update}</td>
                                        <td>
                                            <!-- 이미지를 미리보기하는 태그 -->
                                            <img src="${arrayList.img_url}">
                                        </td>
                                        <td>
                                            <a href="./ImgSelectDetail.im?img_number=${arrayList.img_number}" class="btn btn-outline-info"> 이미지 상세보기 </a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                <c:if test="${empty arrayList}">
                                    <tr>
                                        <td colspan="5">등록된 이미지가 없습니다.</td>
                                    </tr>
                                </c:if>
                            </tbody>
                        </table>
                        <div>
                            <a href="./ImgInsertView.im" class="btn btn-success btn-block">이미지 업로드</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>
</body>
</html>
