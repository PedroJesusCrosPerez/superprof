$(function () {

    $('#createAgreement').on('click', function () {

        console.log('CLICK')
        // $(this).preventDefault()

        Swal.fire({
            title: 'Formulario de creación',
            html: `
                <form id="myForm">
                  <label for="name">Nombre:</label><br>
                  <input type="text" id="name" name="name"><br>
                  <label for="date">Fecha:</label><br>
                  <input type="date" id="date" name="date">
                </form>
              `,
            focusConfirm: false,
            preConfirm: () => {
                const name = Swal.getPopup().querySelector('#name').value
                const date = Swal.getPopup().querySelector('#date').value
                if (!name || !date) {
                    Swal.showValidationMessage(`Por favor ingrese nombre y fecha`)
                }
                return {name: name, date: date}
            }
        }).then((result) => {
            if (result.isConfirmed) {
                console.log(result.value)
            }
        })
    })

})