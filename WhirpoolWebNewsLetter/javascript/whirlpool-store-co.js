$(".form-newsletter").submit(function() {
        var dataJson={
            "emailAddress":$('input[name=newsletterClientEmail]')[0].value
        }
        $.ajax({
            url : "http://34.211.70.75/whirlpool-store-co/rest/news-letters",
            data :  JSON.stringify(dataJson),
            headers: {
                        "Content-Type":"application/json",
            },
            type : 'POST',
            async: false,
            dataType : 'json',
            success : function(json) { },
            error : function(xhr, status) {
            }
        });
});
