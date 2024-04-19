<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 정보 수정</title>
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
            if (confirm("상품 등록을 하시겠습니까?")) {
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
                                    <label for="product_number" class="ml-sm-3 col-form-label">상품 번호</label>
                                    <div class="ml-sm-3">
                                        <input type="text" name="product_number" id="product_number" class="form-control form-control-sm"
                                               value="${param.product_number}" readonly>
                                    </div>
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
                                <a href="./ProductInsertView.pr" class="btn btn-success btn-block">상품 등록</a>
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
</body>
</html>
