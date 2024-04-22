<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 정보 수정</title>
    
    <style>
        /* 모달 스타일 */
        #imgUpdateModal {
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
            var frm = document.getElementById('sign_dept');
            if (!frm.product_title.value) {
                alert("상품이름을 입력하세요.");
                return false;
            }
            if (!frm.product_price.value) {
                alert("상품가격을 입력하세요.");
                return false;
            }
            if (!frm.product_status[0].checked && !frm.product_status[1].checked && !frm.product_status[2].checked) {
                alert("상품 상태를 선택해주세요.");
                frm.product_status[0].focus();
                return false;
            }
            if (!frm.product_content.value) {
                alert("상품내용을 입력하세요.");
                return false;
            }
            if (confirm("상품을 수정 하시겠습니까?")) {
                return true;
            }
            return false;
        }
    </script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<header id="main-header" class="py-2 bg-dark text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1>상품 정보 수정</h1>
            </div>
        </div>
    </div>
</header>
<section class="py-4 mb-4 bg-light"></section>
<section id="productment">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h5>상품 수정</h5>
                    </div>
                    <div class="card-body">
                        <form  onsubmit="return joinProduct()" action="./ProductUpdateView.pr" method="post" id="sign_dept">
                            <fieldset>
                                <div class="form-group row">
                                    <label for="product_title" class="ml-sm-3 col-form-label">상품 이름</label>
                                    <div class="ml-sm-3">
                                        <input type="text" name="product_title" id="product_title" class="form-control form-control-sm bg-white"
                                               value="${productDTO.product_title}">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="product_price" class="ml-sm-3 col-form-label">상품 가격</label>
                                    <div class="ml-sm-3">
                                        <input type="text" name="product_price" id="product_price" class="form-control form-control-sm"
                                               value="${productDTO.product_price}">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
   									 <label for="product_status" class="ml-sm-3 col-form-label">상품 상태</label>
  									 <div class="ml-sm-3">
        								<div class="form-check form-check-inline">
            								<input class="form-check-input" type="radio" name="product_status" id="status_reservation" value="예약">
                
            								<label class="form-check-label" for="status_reservation">예약</label>
       									</div>
      									<div class="form-check form-check-inline">
           									<input class="form-check-input" type="radio" name="product_status" id="status_sale" value="판매중">
                  
            								<label class="form-check-label" for="status_sale">판매중</label>
        								</div>
        								<div class="form-check form-check-inline">
           									<input class="form-check-input" type="radio" name="product_status" id="status_complete" value="완료">
           
            								<label class="form-check-label" for="status_complete">완료</label>
        								</div>
   									 </div>
								</div>

                                <div class="form-group row">
                                    <label for="product_content" class="ml-sm-3 col-form-label">상품 내용</label>
                                    <div class="ml-sm-3">
                                        <input type="text" name="product_content" id="product_content" class="form-control form-control-sm"
                                               value="${productDTO.product_content}">
                                    </div>
                                </div>        
                                               
                                <div class="form-group row">
                                    <div class="ml-sm-3">
                                        <input type="hidden" name="product_number" id="product_number" class="form-control form-control-sm"
                                               value="${param.product_number}" readonly>
                                    </div>
                                </div>
                                
                                
                                <div>
                                	<p>기존 이미지</p>
                                	<img alt="대체 텍스트" src="/ImgView.im?img_url=${img_url}" onclick="openModal()">
                                </div>
                                
         
                                <div class="form-group">
                                    <button type="submit" class="btn btn-secondary">등록</button>
                                 <button type="reset" class="btn btn-secondary" onclick="location.href='./ProductSelect.pr'">취소</button>
                                </div>
                            </fieldset>
                        </form>
                        <div class="row">
                            <div class="col-md-4">
                                <a href="./ProductSelect.pr" class="btn btn-primary btn-block">상품 목록</a>
                            </div>
 
                            <div class="col-md-4">
                                <a href="./ProductDeleteView.pr?product_number=${param.product_number}" class="btn btn-danger btn-block">상품 삭제</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</section>

	

<section>
	<%@ include file="/WEB-INF/view/image/img_update.jsp" %>
</section>

<script type="text/javascript">
	var modal = document.getElementById("imgUpdateModal");
	var prevImgInput = document.getElementById("prevImg");
	
	var img_update_input = document.getElementById("img_update_input");
	var img_number_input = document.getElementById("img_number_input");
	
	function openModal() {
		modal.style.display = "block";
		prevImgInput.src = "/ImgView.im?img_url=${img_url}";
		
		img_update_input.value = new Date().toISOString().split('T')[0];
		img_number_input.value = ${img_number};
	}
	
    window.addEventListener("click", function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    });
</script>

</body>
</html>
