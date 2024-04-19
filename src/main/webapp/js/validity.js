$(function() {
    $.validator.setDefaults({
        onkeyup: false,
        onclick: false,
        onfocusout: false,
        showErrors: function(errorMap, errorList) {
            if (this.numberOfInvalids()) {
                alert(errorList[0].message);
            }
        }
    });

    $.validator.addMethod("regex", function(value, element, regexpr) {
        return regexpr.test(value);
    });

    $("#wishlistForm").validate({
        ignore: [],
        rules: {
            product_title: {
                required: true,
                regex: /^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*$/
            },
            product_number: {
                required: true,
                digits: true,
                maxlength: 3
            },
            member_number: {
                required: true,
                digits: true,
                maxlength: 3
            }
        },
        messages: {
            product_title: {
                required: "상품명을 입력하세요",
                regex: "상품명의 공백이나 특수문자를 제거하세요."
            },
            product_number: {
                required: "상품번호를 입력하세요.",
                digits: "숫자로만 입력하세요.",
                maxlength: "상품 번호는 최대 {0} 숫자입니다."
            },
            member_number: {
                required: "회원번호를 입력하세요.",
                digits: "숫자로만 입력하세요.",
                maxlength: "회원 번호는 최대 {0} 숫자입니다."
            }
        }
    });

    $("#wishlistForm").submit(function(event) {
        event.preventDefault(); // 폼 제출 방지

        if ($("#wishlistForm").valid()) { // 유효성 검사
            // 여기에 AJAX 제출 코드 추가
            $.ajax({
                url: $(this).attr("action"),
                type: "POST",
                data: $(this).serialize(),
                success: function(response) {
                    if (confirm("추가가 완료되었습니다. 찜 목록으로 이동하시겠습니까?")) {
                        window.location.href = "./wishlistindex.jsp";
                    }
                },
                error: function() {
                    alert("오류가 발생하였습니다. 다시 시도해주세요.");
                }
            });
        }
    });
});