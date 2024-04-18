$(document).ready(function() {
    $('#infoForm').validate({
        rules: {
            info_Title: {
                required: true
            },
            info_Content: {
                required: true
            },
            info_Date: {
                required: true
            }
        },
        messages: {
            info_Title: "",
            info_Content: "",
            info_Date: ""
        },
        showErrors: function(errorMap, errorList) {
            if (this.numberOfInvalids()) {
                $("#errorSummary").html("* 필수 항목을 입력하세요");
            } else {
                $("#errorSummary").html("");
            }
            this.defaultShowErrors();
        },
        errorPlacement: function(error, element) {
            // 오류 메시지를 element 다음에 표시
            error.insertAfter(element);
        }
    });
});
