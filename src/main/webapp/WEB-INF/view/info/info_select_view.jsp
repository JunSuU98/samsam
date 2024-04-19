<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지 사항</title>
    <link rel="stylesheet" type="text/css" href="./css/info.css">
    <link rel="stylesheet" type="text/css" href="./css/infoselect.css">
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
    <div class="page-title">
        <div class="container">
            <h3>공지사항</h3>
        </div>
    </div>

    <div id="board-list">
        <div class="container">
            <table class="board-table">
                <thead>
                    <tr>
                        <th scope="col" class="th-num">번호</th>
                        <th scope="col" class="th-title">제목</th>
                        <th scope="col" class="th-date">등록일</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="arrayList" items="${arraylist}">
                        <tr>
                            <td>${arrayList.info_Number}</td>
                            <td><a href="InfoSelectDetail.in?info_Number=${arrayList.info_Number}">${arrayList.info_Title}</a></td>
                            <td>                           
                            ${arrayList.info_Date.substring(0, 10)}
                            </td>
                            <td>${board.readcount}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty arraylist}">
                        <tr>
                            <td colspan="3">등록된 공지사항이 없습니다 +ㅡ+</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
      <div class="insertcontainer">
       <a href="InfoInsert.in" class="add-notice-link">공지 작성</a>
      </div>
    </div>
</section>
</body>
</html>

