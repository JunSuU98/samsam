<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<header id="main-header" class="py-2 bg-dark text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1>상품</h1>
            </div>
        </div>
    </div>
</header>

<section class="py-4 mb-4 bg-light">

	<c:choose>
		<c:when test="${not empty sessionScope.member_name}">
			<!-- 로그인 된 상태의 처리 -->
			<c:choose>
				<c:when test="${sessionScope.member_id eq 'admin'}">
					<!-- 관리자로 로그인한 상태의 처리 -->
					<h2>관리자 로그인 성공!!</h2>
					
					<button type="button" class="btn btn-primary" onclick="location.href='/MemberSelect.me'">
						전체회원조회
					</button>

					<button type="button" class="btn btn-primary" onclick="location.href='/Logout.me'">
						로그아웃
					</button>

				</c:when>
				<c:otherwise>
					<!-- 일반 사용자로 로그인한 상태의 처리 -->
					<h2>일반 회원 로그인 성공!!</h2>
					
					<button type="button" class="btn btn-primary" onclick="location.href='/MemberSelectDetail.me?member_number=${sessionScope.member_number}'">
						마이페이지
					</button>
					
					<button type="button" class="btn btn-primary" onclick="location.href='/Logout.me'">
						로그아웃
					</button>

				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<!-- 로그인 되지 않은 상태의 처리 -->
			<h2>로그인 되어있지 않습니다</h2>
			
			<button type="button" class="btn btn-primary" onclick="location.href='/MemberInsertView.me'">
				회원가입
			</button>
			
			<button type="button" class="btn btn-primary" onclick="location.href='/LoginView.me'">
				로그인
			</button>

		</c:otherwise>
	</c:choose>
	

</section>

<section id="department">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h5>상품 목록</h5>
                    </div>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead class="thead-light">
                                <tr class="text-center">
                                    <th>상품 이름</th>
                                    <th>상품 가격</th>
                                    <th>상품 업로드 날짜</th>
                                    <th>상품 거래상태 </th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="arrayList" items="${arrayList}">
                                    <tr class="text-center">
                                        <td>${arrayList.product_title}</td>
                                        <td>${arrayList.product_price}</td>
                                        <td>${arrayList.product_upload}</td>
                                        <td>${arrayList.product_status}</td>
                                        <td>
                                            <a href="./ProductSelectDetail.pr?product_number=${arrayList.product_number}" class="btn btn-outline-info">
                                                상품 상세 보기
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:if test="${empty arrayList}">
                                    <tr>
                                        <td colspan="4">등록된 상품이 없습니다.</td>
                                    </tr>
                                </c:if>
                            </tbody>
                        </table>
                        <div>
                            <a href="./ProductInsertView.pr" class="btn btn-success btn-block">상품 등록</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section>
	<button type="button" class="btn btn-primary" onclick="location.href='/InfoSelect.in'">
		공지사항
	</button>
	
	<button type="button" class="btn btn-primary" onclick="location.href='/CSSelect.cs'">
		문의사항
	</button>



</section>
</body>
</html>