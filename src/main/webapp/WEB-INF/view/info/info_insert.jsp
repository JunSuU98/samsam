	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>등록하세요</title>
	    <script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
	    <script src="./js/jquery.validate.min.js" type="text/javascript"></script>
	    <script src="./js/validation.js"  type="text/javascript"></script>
	    <link rel="stylesheet" type="text/css" href="./css/insert.css">
	    
	 <!-- CSS 파일 경로 -->
	</head>
	<body>
	    <div class="container">
	        <h1>공지 등록</h1>
	        <form id="infoForm" action="./InfoInsertView.in" method="post">
	            <label for="info_Title">*제목:</label><br>
	            <input type="text" id="info_Title" name="info_Title"><span class="error"></span><br>
	            <label for="info_Content">*내용:</label><br>
	            <textarea id="info_Content" name="info_Content"></textarea><span class="error"></span><br>
	            <label for="info_Date">*날짜:</label><br>
	            <input type="date" id="info_Date" name="info_Date"><span class="error"></span><br>
	            <input type="submit" value="등록">
	        </form>
	    </div>
	</body>
	</html>