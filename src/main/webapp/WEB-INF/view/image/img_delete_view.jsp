<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 삭제</title>
<script type="text/javascript">
    // 페이지가 로드되면 deleteImage 함수를 자동으로 실행합니다.
    window.onload = function() {
        deleteImage();
    };

    // deleteImage 함수를 정의합니다.
    function deleteImage() {
        // confirm 창을 띄워 사용자에게 확인을 물어봅니다.
        var confirmed = confirm("이미지를 삭제하시겠습니까?");
        // 사용자가 확인을 눌렀다면
        if (confirmed) {
            // alert 창을 띄우고 이미지를 삭제하는 작업을 수행합니다.
            alert("입력하신 ${imgDTO.img_number}번의 이미지를 삭제하였습니다.");
            location.href = "./ImgSelect.im";
        } else {
            // 사용자가 취소를 눌렀다면 다시 되돌아옴
        	window.history.go(-1);
        }
    }
</script>
</head>
<body>
</body>
</html>
