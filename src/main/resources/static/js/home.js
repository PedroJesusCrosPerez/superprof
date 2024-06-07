$(function () {
    console.log("home.js: Javascript works!!!")


    let modal = $('#connect-modal div.common-modal')[0]
    let modalHideContent = $('#connect-modal div.connect')[0]
    let crossModalIcon = $('#crossModal')

    let aSignUp = $('#aSignUp')

    let aSignIn = $('#aSignIn')


    aSignUp.on("click", function (event) {

        console.log("home.js: aSignUp clicked!!!")
        event.preventDefault()

        modalHideContent.removeClass("loading")
        modalHideContent.removeClass("hide-content")
        modal.addClass("visible")

        crossModalIcon.on("click", function () {
            modalSignUp.removeClass("visible")
        })
    })

    aSignIn.on("click", function (event) {

        console.log("home.js: aSignIn clicked!!!")
        event.preventDefault()

        modalHideContent.removeClass("loading")
        modalHideContent.removeClass("hide-content")
        modal.addClass("visible")

        crossModalIcon.on("click", function () {
            modal.removeClass("visible")
        })
    })
})

$() ({
    console.log("home222222.js: Javascript works!!!")
})

//$({
//    console.log("home.js: Javascript with JQuery works!!!")
//})