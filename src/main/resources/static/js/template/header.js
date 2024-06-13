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
                username: $('#signin-form input[name="email"]').val(),
                password: $('#signin-form input[name="password"]').val()
            }),
            success: function(response) {
                console.log(response);
            },
            error: function(error) {
                console.log(error);
            }
        });
    });
});