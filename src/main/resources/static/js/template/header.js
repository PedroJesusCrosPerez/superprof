$( function() {

    $('#submitSignUp').click(function() {

        $.ajax({
            url: '/auth/signup',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                username: $('#signup-form input[name="username"]').val(),
                email: $('#signup-form input[name="email"]').val(),
                password: $('#signup-form input[name="password"]').val()
            }),
            success: function(response) {
                console.log(response);
            },
            error: function(error) {
                console.log(error);
            }
        });
    });

    $('#submitSignIn').click(function() {

        $.ajax({
            url: '/auth/signin',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                username: $('#signin-form input[name="username"]').val(),
                password: $('#signin-form input[name="password"]').val()
            }),
            success: function(response) {
                console.log(response);

                // window.location.href = "/auth/signin/accepted";
                // window.location.href = "/auth/signin/accepted?token=" + response.token;
                localStorage.setItem('jwtToken', response.token);
                redirect();
            },
            error: function(error) {
                console.log(error);
            }
        });
    });
});


function redirect() {
    let jwtToken = localStorage.getItem('jwtToken'); // Recupera el token JWT del almacenamiento local

    $.ajax({
        url: '/admin/dashboard',
        type: 'GET',
        headers: {
            'Authorization': 'Bearer ' + jwtToken
        },
        success: function(data) {
            // Maneja la respuesta de la solicitud
            console.log(data);
        },
        error: function(err) {
            // Maneja cualquier error que pueda ocurrir
            console.error('Error al realizar la solicitud:', err);
        }
    });
}