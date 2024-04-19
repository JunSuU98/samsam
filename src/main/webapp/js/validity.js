$(function() {
    $.validator.setDefaults({
        onkeyup: false,
        onclick: false,
        onfocusout: false,
        showErrors: function(errorMap, errorList) {
            if (this.numberOfInvalids()) {
                alert(errorList[0].message);
                 alert(errorList[1].message);
                  alert(errorList[2].message);
                  
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

   
});