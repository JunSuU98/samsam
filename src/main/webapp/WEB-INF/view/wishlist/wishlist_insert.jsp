<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>찜 목록 등록</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css" href="./css/all.min.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" href="./css/bootstrap-datepicker.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/popper.min.js" type="text/javascript"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/validity.js" type="text/javascript"></script>
<script src="./js/bootstrap-datepicker.js"></script>
<script src="./js/bootstrap-datepicker.ko.js"></script>
</head>
<body>
    <h1>찜 목록 추가</h1>
    
    <form action="./WishlistInsert.wi" method="post" id="wishlistForm" enctype="application/x-www-form-urlencoded">
        <div>
            <label for="product_title">상품 이름:</label>
            <input type="text" id="product_title" name="product_title" required>
        </div>
        <div>
            <label for="product_number">상품 번호:</label>
            <input type="text" id="product_number" name="product_number" required>
        </div>
        <div>
            <label for="member_number">회원 번호:</label>
            <input type="text" id="member_number" name="member_number" required>
        </div>
        <div>
            <button type="submit">추가하기</button>      
        </div>
    </form>
</body>
</html>