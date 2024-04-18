<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>상품 정보 삭제</title>
</head>
<body>
<header id="main-header" class="py-2 btn-dark text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1>상품 정보 삭제</h1>
            </div>
        </div>
    </div>
</header>
<section class="py-4 mb-4 bg-light"></section>
<section id="department">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h5>상품 삭제</h5>
                    </div>
                    <div class="card-body">
                        <form action="./ProductDelete.pr" method="post" id="sign_dept">
                            <fieldset>
                                <div class="form-group row">
                                    <label for="product_number" class="ml-sm-3 col-form-label">상품 번호</label>
                                    <div class="ml-sm-3">
                                        <input type="text" name="product_number" id="product_number" class="form-control form-control-sm bg-white"
                                               value="${param.product_number}" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-secondary">삭제</button>
                                    <button type="reset" class="btn btn-secondary">취소</button>
                                </div>
                            </fieldset>
                        </form>
                        <div class="row">
                            <div class="col-md-4">
                                <a href="./ProductSelect.pr" class="btn btn-primary btn-block">상품 목록</a>
                            </div>
                            <div class="col-md-4">
                                <a href="./ProductInsertView.pr" class="btn btn-success btn-block">상품 입력</a>
                            </div>
                            <div class="col-md-4">
                                <a href="./ProductUpdateView.pr?product_number=${param.product_number}" class="btn btn-warning btn-block">상품 수정</a>
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
