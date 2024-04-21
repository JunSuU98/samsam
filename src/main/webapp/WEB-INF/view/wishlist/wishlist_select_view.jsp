<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>전체 조회입니다</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>전체 조회</h1>
    
    <table>
        <thead>
            <tr>
                <th>상품 제목</th>
                <th style="display: none;">상품 번호</th>
                <th style="display: none;">회원 번호</th>
                <th>찜 목록 추가일</th>
                <th>비고 <button type="button" onclick = "deleteAll(${sessionScope.member_number})">전체삭제</button></th>
            </tr>
        </thead>
        <tbody>

            
             <c:forEach var="wishlistDTO" items="${arrayList}">
             
             	<c:if test="${sessionScope.member_number eq wishlistDTO.member_number}">
             	   <tr>
						<td>${wishlistDTO.product_title}</td>
						<td style="display: none;" class="wishlist_product_number">${wishlistDTO.product_number}</td>
						<td style="display: none;" class="wishlist_member_number">${wishlistDTO.member_number}</td>
						<td>${wishlistDTO.wishlist_create}</td>
						<td>
						
						<button type="button" onclick = "selectDetail('${wishlistDTO.product_number}')">상세보기</button>
						<button type="button" onclick = "deleteDetail('${wishlistDTO.member_number}' , '${wishlistDTO.product_number}')">삭제하기</button>
						<input type="hidden" name="wishlist_number" value="${wishlistDTO.wishlist_number}">
						</td>
					</tr>
             	</c:if>
			</c:forEach>
            
        </tbody>
    </table>
    <c:if test="${empty arrayList}">
    <tr>
    <script type = "text/javascript">
    alert("찜 목록이 존재하지않습니다.")
    </script>
    </c:if>
<script>

function selectDetail(product_number) {
	window.location.href = "/ProductSelectDetail.pr?product_number=" + product_number;
}


function deleteDetail(member_number, product_number) {
	window.location.href = "./WishlistDelete.wi?member_number=" + member_number + "&product_number=" + product_number;
}

function deleteAll(member_number) {
	if(confirm("정말로 전체 삭제하시겠습니까?")){
		let form = document.createElement('form');
	
		let member_number_input = document.createElement('input');
		member_number_input.setAttribute('type', 'hidden');
		member_number_input.setAttribute('name', 'member_number');
		member_number_input.setAttribute('value', member_number);
		
		form.appendChild(member_number_input);
		
		form.setAttribute('method', 'post');
		form.setAttribute('action', '/WishlistDeleteAll.wi');
		
		document.body.appendChild(form);
		
		form.submit();

	}
		
}
</script>
</body>
</html>