$( "#lnkAceptar" ).click(function() {
        var dataJson={
            "lastName":$("#txtApellido")[0].value,
            "firstName":$("#txtNombre")[0].value,
            "emailAddress":$("#txtEmail")[0].value
        }
        $.ajax({
            url : "http://34.211.70.75/kitchenaid/rest/news-letters",
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
