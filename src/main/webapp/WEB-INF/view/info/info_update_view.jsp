<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>수정하시겠습니까?</title>
    <!-- CSS 파일 경로 -->
</head>
<body>
    <div class="container">
        <h1>수정되었습니다.</h1>
        <!-- 수정한 데이터를 보여줍니다 -->
        <p>제목: ${infoDTO.info_Title}</p>
        <p>내용: ${infoDTO.info_Content}</p>
        <p>날짜: ${infoDTO.info_Date}</p>
        
        <!-- 수정 버튼 -->
 
        <button onclick="goToList()">목록으로 돌아가기</button>
    </div>
    <script>
    function goToList() {
        window.location.href = "./InfoSelect.in";
    }
   </script>

</body>
</html>

