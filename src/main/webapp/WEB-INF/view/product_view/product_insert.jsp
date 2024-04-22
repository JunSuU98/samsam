<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 정보 입력</title>
    
    
       <style>
        /* 모달 스타일 */
        #imgInsertModal {
            display: none; /* 처음에는 모달을 숨김 */
            position: fixed; /* 모달 위치를 고정 */
            z-index: 1; /* 다른 요소 위에 나타나도록 함 */
            left: 0;
            top: 0;
            width: 100%; /* 전체 너비로 설정 */
            height: 100%; /* 전체 높이로 설정 */
            overflow: auto; /* 필요한 경우 스크롤 가능하도록 설정 */
            background-color: rgba(0,0,0,0.7); /* 투명도가 있는 검은색 배경 */
        }
        #modalContent {
            background-color: #fefefe;
            margin: 15% auto; /* 상단에서 15% 떨어진 곳에 중앙 정렬 */
            padding: 20px;
            border: 1px solid #888;
            width: 80%; /* 80%의 너비 */
        }
    </style> 
    
    
    <script type="text/javascript">
        function joinProduct() {
            var frm = document.join;
            if (!frm.product_title.value) {
                alert("상품이름을 입력하세요.");
                return false;
            }
            if (!frm.product_price.value) {
                alert("상품가격을 입력하세요.");
                return false;
            }
            if (!frm.product_content.value) {
                alert("상품내용을 입력하세요.");
                return false;
            }
            if (confirm("상품 등록을 하시겠습니까?")) {
                return true;
            }
            return false; 
        }
        

    </script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
</head>
<body>
<header id="main-header" class="py-2 bg-dark text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1>상품 정보 입력</h1>
            </div>
        </div>
    </div>
</header>
<section class="py-4 mb-4 bg-light"></section>
<section id="department">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h5>상품 등록</h5>
                    </div>
                    <div class="card-body">
                        <form name="join" onsubmit="return joinProduct()" action="./ProductInsert.pr" method="post" id="sign_dept" >
                            <fieldset>
                                <div class="form-group">
                                    <input type="hidden" name="product_upload" id="product_upload" class="form-control form-control-sm">
                                </div>
                                <div class="form-group">
                                    <input type="hidden" name="product_update" id="product_update" class="form-control form-control-sm">
                                </div>
                                <div class="form-group">
                                    <label for="product_title">상품 이름</label>
                                    <input type="text" name="product_title" id="product_title" class="form-control form-control-sm">
                                </div>
                                <div class="form-group">
                                    <label for="product_price">상품 가격</label>
                                    <input type="text" name="product_price" id="product_price" class="form-control form-control-sm">
                                </div>
                                <div class="form-group">
                                    <label for="product_content">상품 내용</label>
                                    <input type="text" name="product_content" id="product_content" class="form-control form-control-sm">
                                </div>
                               <div class="form-group">
                                    <input type="hidden" name="product_status" id="product_status" class="form-control form-control-sm"  value="판매중">
                                </div>
                                
                                <div class="form-group">
                                    <input type="hidden" name="img_index" id="img_index" class="form-control form-control-sm" value="${product_index}">
                                </div>
                      
                                <div class="form-group">
                                	<button type="button" onclick="openModal()">상품 이미지 업로드</button>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-secondary"> 등록 </button>
                                    <button type="reset" class="btn btn-secondary" onclick="location.href='./ProductSelect.pr'">취소</button>
                                </div>
                            </fieldset>
                        </form>
                        <div>
                            <a href="./ProductSelect.pr" class="btn btn-primary btn-block">상품 목록</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section>
	<%@ include file="/WEB-INF/view/image/img_insert.jsp" %>
</section>

<script type="text/javascript">

	var modal = document.getElementById("imgInsertModal");

	function openModal() {
		modal.style.display = "block";
		
		
   		// 서버로부터 기존에 사용되었던 PRODUCT 테이블의 IMG_INDEX 를 모두 가져와서 겹치는게 있다면 새롭게 랜덤한 숫자를 생성한다
      	$.ajax({
      		url: "/ProductSelectImgIndex.pr",
      		type: "get",
      		
      		success: function(response){
      			
      			let img_index_arr = response;
      			
      	        let randomNumber = Math.floor(Math.random() * 10);
      	        
      	        while(img_index_arr.includes(randomNumber)){
      	        	randomNumber = Math.floor(Math.random() * 10);
      	        }
      	        
      	        document.getElementById('product_index').value = randomNumber;

      			
      		},
      		
     		error: function(status, error){
     			console.log("ajax error" + status + "- " + error)
     			console.log("error - " + error)
     		}
      	});
   		

	}
	
	// 이전 페이지에서 세션 스토리지의 값을 가져온다
  	var img_index = sessionStorage.getItem('product_index');
  	// 값이 있을 경우 입력란에 채운다
  	if(img_index !== null) {
  	    document.getElementById('img_index').value = img_index;
  	}
	
    window.addEventListener("click", function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    });
    
 
    

    	
  

    
    
</script>

</body>
</html>
