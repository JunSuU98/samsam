<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상세 이미지 정보</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
    <header id="main-header" class="py-2 btn-dark text-white">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1>상세 이미지 정보</h1>
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
                            <h5>이미지 상세 보기</h5>
                        </div>
                        <div class="card-body">
                            <table class="table table-hover">
                                <thead class="thead-light">
                                    <tr class="text-center">
                                        <th>이미지 번호</th>
                                        <th>이미지 업로드 날짜</th>
                                        <th>이미지 수정 날짜</th>
                                        <th>미리보기</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <tr class="text-center">
                                        <td>${imgDTO.img_number}</td>
                                        <td>${imgDTO.img_upload}</td>
                                        <td>${imgDTO.img_update}</td>
                                        <!-- 이미지 미리보기를 표시할 img 태그 -->
                                        <td><img src="${imgDTO.img_url}" style="max-width: 100px; max-height: 100px;"></td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="row">
                                <div class="col-md-4">
                                    <a href="./ImgSelect.im" class="btn btn-primary btn-block">이미지 목록 </a>
                                </div>
                                <div class="col-md-4">
                                    <a href="./ImgUpdate.im?img_number=${imgDTO.img_number}" class="btn btn-warning btn-block"> 이미지 수정 </a>
                                </div>
                                <div class="col-md-4">
                                    <a href="./ImgDelete.im?img_number=${imgDTO.img_number}" class="btn btn-warning btn-block"> 이미지 삭제 </a>
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
