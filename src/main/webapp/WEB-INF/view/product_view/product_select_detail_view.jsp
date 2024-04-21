<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상세 상품정보</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
    
   		$.get("/WishlistSelect.wi", function(response) {
   			var member_number_arr = [];
   			var product_number_arr = [];
   			
   		    $(response).find('.wishlist_member_number').each(function() {
   		        var value = $(this).text(); 
   		        member_number_arr.push(value); 
   		    });
   		    
   		    $(response).find('.wishlist_product_number').each(function() {
   		        var value = $(this).text(); 
   		        product_number_arr.push(value); 
   		    });

   		    var wishlist_button = document.getElementById('wishlist_button');
   		    
   		    var session_member_number = document.getElementById('session_member_number').innerText;
   		    var td_product_number = document.getElementById('td_product_number').innerText;
   		    
   		    console.log(member_number_arr[0])
   		    console.log(session_member_number)
   		    console.log(td_product_number)

   		    if( (member_number_arr[0] == session_member_number) && (product_number_arr.includes(td_product_number)) ){
   		    	wishlist_button.innerText = '찜해제';
   		    	wishlist_button.removeAttribute('onclick');
   		    	wishlist_button.setAttribute('onclick', 'wishlistDelete(' + session_member_number + ', ' + td_product_number + ')');
   		    }

   		    console.log(member_number_arr); 	
   		    console.log(product_number_arr); 	
		});
   		
   		function wishlistDelete(session_member_number, td_product_number) {
			let form = document.createElement('form');
    		
    		let member_number_input = document.createElement('input');
    		member_number_input.setAttribute('type', 'hidden');
    		member_number_input.setAttribute('name', 'member_number');
    		member_number_input.setAttribute('value', session_member_number);
    		
    		let product_number_input = document.createElement('input');
    		product_number_input.setAttribute('type', 'hidden');
    		product_number_input.setAttribute('name', 'product_number');
    		product_number_input.setAttribute('value', td_product_number);

    		
    		form.appendChild(member_number_input);
    		form.appendChild(product_number_input);
    		
    		form.setAttribute('method', 'post');
    		form.setAttribute('action', '/WishlistDelete.wi');
    		
    		document.body.appendChild(form);
    		
			form.submit();
    		
		}
    
    	function wishlistPost(member_number, product_number, product_title){
    		let form = document.createElement('form');
    		
    		let member_number_input = document.createElement('input');
    		member_number_input.setAttribute('type', 'hidden');
    		member_number_input.setAttribute('name', 'member_number');
    		member_number_input.setAttribute('value', member_number);
    		
    		let product_number_input = document.createElement('input');
    		product_number_input.setAttribute('type', 'hidden');
    		product_number_input.setAttribute('name', 'product_number');
    		product_number_input.setAttribute('value', product_number);

			let product_title_input = document.createElement('input');
    		product_title_input.setAttribute('type', 'hidden');
    		product_title_input.setAttribute('name', 'product_title');
    		product_title_input.setAttribute('value', product_title);

    		
    		form.appendChild(member_number_input);
    		form.appendChild(product_number_input);
    		form.appendChild(product_title_input);
    		
    		form.setAttribute('method', 'post');
    		form.setAttribute('action', '/WishlistInsert.wi');
    		
    		document.body.appendChild(form);
    		
    		if(member_number.value == ''){
    			alert("로그인 후 이용바랍니다.");
    			return false;
    		} else {
				form.submit();
    		}
    		
    	}
    
    </script>
</head>
<body>
<header id="main-header" class="py-2 bg-dark text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1>상세 상품 정보</h1>
            </div>
        </div>
    </div>
</header>
<section class="py-4 mb-4 bg-light"></section>
<section id="productkdb">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h5>상품 상세 보기</h5>
                    </div>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead class="thead-light">
                                <tr class="text-center">
                                    <th>상품 번호</th>
                                    <th>상품 업로드</th>
                                    <th>상품 업데이트</th>
                                    <th>상품 제목</th>
                                    <th>상품 가격</th>
                                    <th>상품 내용</th>
                                    <th>상품 상태</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="text-center">
                                    <td id="td_product_number">${productDTO.product_number}</td>
                                    <td>${productDTO.product_upload}</td>
                                    <td>${productDTO.product_update}</td>
                                    <td>${productDTO.product_title}</td>
                                    <td>${productDTO.product_price}</td>
                                    <td>${productDTO.product_content}</td>
                                    <td>${productDTO.product_status}</td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="row">
                            <div class="col-md-4">
                                <a href="./ProductSelect.pr" class="btn btn-primary btn-block">
                                    상품 목록
                                </a>
                            </div>

							<div class="col-md-4">
								<p id="session_member_number" style="display: none;">${sessionScope.member_number}</p>
                                <button id="wishlist_button" onclick="wishlistPost(${sessionScope.member_number}, ${productDTO.product_number}, '${productDTO.product_title}')" class="btn btn-primary btn-block">
									찜하기
                                </button>

                            </div>


                            <div class="col-md-4">
                                <a href="./ProductUpdate.pr?product_number=${productDTO.product_number}" class="btn btn-warning btn-block">
                                    상품 수정
                                </a>
                            </div>
                            <div class="col-md-4">
                                <a href="./ProductDeleteView.pr?product_number=${productDTO.product_number}" class="btn btn-danger btn-block">
                                    상품 삭제
                                </a>
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
