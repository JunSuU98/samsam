<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    <title>삭제 하시겠습니까?</title>
    <!-- CSS 파일 경로 -->
    
</head>
<body>

    <div class="container">
        <h1>공지 삭제</h1>
        <form action="./InfoDeleteView.in" method="post"> <!-- 매핑 경로 -->
            <!-- 이전에 저장된 데이터를 입력 필드에 채워 넣음 -->
           
            <label for="info_Title">제목</label><br>
            <input type="text" id="info_Title" name="info_Title" value="${infoDTO.info_Title}"><br>
            <label for="info_Content">내용</label><br>
            <textarea id="info_Content" name="info_Content">${infoDTO.info_Content}</textarea><br>
            <label for="info_Date">날짜</label><br>
            <input type="date" id="info_Date" name="info_Date" value="${infoDTO.info_Date}"><br> <!-- 날짜 입력란 -->
            <input type="hidden" name="info_Number" value="${infoDTO.info_Number}"> <!-- 수정할 데이터의 고유 식별자(hidden 필드로 전달) -->
            <button onclick="removeCheck()">삭제</button>
        </form>

         <script>
            // 삭제 확인 함수
            function removeCheck() {
                // 알림창을 띄우고 확인 버튼을 누르면 매핑된 페이지로 이동합니다.
                var isDeleteConfirmed = confirm("삭제하시면 복구가 불가능 합니다. 삭제 하시겠습니까?");
                
                // 취소를 누른 경우
                if (!isDeleteConfirmed) {
                    event.preventDefault(); // 이벤트 중단
                }
            }
        </script>



      
    </div>
</body>
</html>