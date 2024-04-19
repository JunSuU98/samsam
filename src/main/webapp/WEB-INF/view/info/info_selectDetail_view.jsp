<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:out value="${infoDTO.info_Title}" /></title>
    <link rel="stylesheet" type="text/css" href="./css/infoselectDetail.css">
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



<section class="INFO">
    <div class="container">
        <h1 class="page-title"></h1>
        <div class="info-box">
            <h2 class="info-title">${infoDTO.info_Title}</h2>
            <div class="info-content">
                <p class="info-text"> ${infoDTO.info_Content}</p>
                <p class="info-date">등록 날짜 : ${infoDTO.info_Date.substring(0, 10)}</p>
            </div>
            <div class="info-actions">
                <a href="InfoUpdate.in?info_Number=${infoDTO.info_Number}" class="action-btn">공지 수정</a>
                <a href="InfoDelete.in?info_Number=${infoDTO.info_Number}" class="action-btn">공지 삭제</a>
            </div>
        </div>
    </div>
</section>
</body>
</html>
