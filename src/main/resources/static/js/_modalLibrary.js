function launchConfirmModal(onConfirm, onCancel) {

    Swal.fire({
        title: '¿Estás seguro?',
        text: "¡No podrás revertir los cambios!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, ¡eliminar!'
    }).then((result) => {
        if (result.isConfirmed) {
            onConfirm();
            Swal.fire(
                '¡Eliminado!',
                'Se ha eliminado con éxito.',
                'success'
            )
        } else {
            onCancel();
        }
    })
}