<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 정보 입력</title>
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
                                    <label for="product_img">상품 이미지</label>
                                    <input type="file" name="product_img" id="product_img" class="form-control-file">
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
</body>
</html>
