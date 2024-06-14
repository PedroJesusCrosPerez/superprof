function throwCreateAgreementModal() {

    Swal.fire({
        title: '¡Crea tu anuncio!',
        html: `
            <form id="formCreateAgreement" style="
            
                display: grid;
                grid-template-columns: 1fr 1fr;
                grid-template-rows: 1.2em;
                row-gap: 1.2em;
            ">
                <label for="subject">Asignatura:</label>
                <select id="slctSubjects" name="slctSubjects">
                    <option value="0" selected disabled>Selecciona una asignatura</option>
                </select>
                
                <label for="text">Título:</label>
                <input type="text" id="title" name="title">
                
                <label for="text">Lugar:</label>
                <div style="
                    display: grid;
                    grid-template-columns: 1fr 1fr;
                    grid-template-rows: 1.2em;
                    row-gap: 1.2em;
                ">
                    <input type="checkbox" id="place_online" name="place_online">
                    <label for="place_online">Online</label>
                    <input type="checkbox" id="place_inperson" name="place_inperson">                
                    <label for="place_inperson">Presencial</label>                
                </div>
                
                <label for="text">Idiomas:</label>
                <div>
                    <div id="selectedLanguages" style="
                        display: grid;
                        grid-template-columns: 1fr;
                        grid-template-rows: 1.2em;
                        row-gap: .8em;
                    "></div>
                    <select id="slctLanguages" name="slctLanguages">
                        <option value="0">Selecciona un idioma</option>
                    </select>
                </div>
                
                <label for="text">Descripción:</label>
                <input type="text" id="description" name="description">
                
                <label for="text">Sobre mi:</label>
                <input type="text" id="aboutMe" name="aboutMe">
                
                <label for="text">TODO Precios:</label>
                <input type="text" id="rate" name="rate">
            </form>
        `,
        didOpen: () => {

            initAgreementForm()
        },
        focusConfirm: false,
        preConfirm: () => {

            const form = Swal.getPopup().querySelector('#formCreateAgreement');

            // Languages
            const idsLanguages = [];
            $('#selectedLanguages .language').each(function() {
                idsLanguages.push($(this).data('idlanguage'));
            });

            // Place
            let places = [];
            if ($('#place_online').is(':checked')) {
                places.push('ONLINE');
            }
            if ($('#place_inperson').is(':checked')) {
                places.push('IN_PERSON');
            }

            const data = {
                // idSubject: form['slctSubjects'].value,
                title: form['title'].value,
                place: places,
                idsLanguages: idsLanguages,
                description: form['description'].value,
                aboutMe: form['aboutMe'].value,
                rate: {
                    rate: form['rate'].value
                }
            };

            // Validar los campos del formulario
            for (let key in data) {
                if (data[key] === '') {
                    Swal.showValidationMessage(`Por favor ingrese ${key}`);
                    return;
                }
            }

            console.log("DATOS A ENVIAR")
            console.log("DATOS A ENVIAR")
            console.log("DATOS A ENVIAR")
            console.log("DATOS A ENVIAR")
            console.log("DATOS A ENVIAR")
            console.log("DATOS A ENVIAR")
            console.log(data)
            console.log("DATOS A ENVIAR")
            console.log("DATOS A ENVIAR")

            ajaxRequest("/agreements", "POST", data, function (response) {
                console.log(response);
            }, function (jqXHR, textStatus, errorThrown) {
                console.error('Error:', textStatus, errorThrown);
            });

            return true;
        }
    }).then((result) => {
        // if (result.isConfirmed) {
        //     console.log(result.value)
        // }
        console.log(result)
    })
}


function initAgreementForm() {

    initSubjects();
    initLanguages();
}

function initSubjects() {

    uploadSubjects();
}

function initLanguages() {

    uploadLanguages();
}

function uploadSubjects() {

    ajaxRequest("/subjects", "GET", null, function (response) {
        const subjects = response;
        const selectedSubjects = $('#slctSubjects');
        subjects.forEach(function (subject) {
            selectedSubjects.append(
                $('<option>',{
                    value: subject.idSubject,
                    text: subject.name
                })
            )
        });

    }, function (jqXHR, textStatus, errorThrown) {
        console.error('Error:', textStatus, errorThrown);
    });
}

function uploadLanguages() {

    ajaxRequest("/languages", "GET", null, function (response) {
        const languages = response;
        const selectedLanguages = $('#slctLanguages');
        languages.forEach(function (language) {
            selectedLanguages.append(
                $('<option>',{
                    value: language.idLanguage,
                    text: language.name
                })
            )
        });


    }, function (jqXHR, textStatus, errorThrown) {
        console.error('Error:', textStatus, errorThrown);
    });

    $('#slctLanguages').on("change", function () {
        var selectedOption = $(this).find('option:selected');
        var language = selectedOption.text();
        var value = selectedOption.val();

        if (value == 0) {
            return;
        }

        // Crear un nuevo elemento en el div #selectedLanguages
        $('#selectedLanguages').append('<span class="language" data-idLanguage="' + value + '">' + language + '<button class="remove-language">Eliminar</button></span>');
        // $('#selectedLanguages').append('<div class="language" data-idLanguage="' + value + '"><p>' + language + '</p><button class="remove-language">Eliminar</button></div>');

        // Eliminar el idioma seleccionado del select
        selectedOption.remove();
    });

    $('#selectedLanguages').on('click', '.remove-language', function () {
        var languageElement = $(this).parent();
        var language = languageElement.text().replace(' Eliminar', '');
        var value = languageElement.data('value');

        // Mover el idioma de vuelta al select
        $('#slctLanguages').append('<option value="' + value + '">' + language + '</option>');

        // Eliminar el elemento del div #selectedLanguages
        languageElement.remove();
    });
}

