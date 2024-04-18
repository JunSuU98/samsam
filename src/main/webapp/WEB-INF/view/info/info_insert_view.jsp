<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지가 입력되었습니다</title>
    <link rel="stylesheet" type="text/css" href="./css/insert.css">
</head>
<body>
    <div class="container">
        <h1>공지 입력 완료</h1>
        <div class="info-box">
            <h2>제목 : ${infoDTO.info_Title}</h2>
            <p>내용: ${infoDTO.info_Content}</p>
            <p>날짜: ${infoDTO.info_Date}</p>
            <div class="info-links">
                <a href="./InfoSelect.in">목록 돌아가기</a>
            </div>
        </div>
    </div>
</body>
</html>
