/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$('#table').DataTable({
    language: {
        processing: "Traitement en cours...",
        search: "  Buscar Registro:  ",
        lengthMenu: " <span class='badge badge-success'>Mostrar _MENU_ Elementos</span> ",
        info: " <br/> <span class='badge badge-success'>Se muestran _START_ a _END_ de _TOTAL_ elementos  </span>",
        infoEmpty: " <span class='badge badge-danger'>No hay elementos</span> ",
        infoFiltered: "<span class='badge badge-danger'>(filtrado de _MAX_ elementos en total)<br/></span>",
        infoPostFix: "",
        loadingRecords: "Chargement en cours...",
        zeroRecords: " <div class='alert alert-danger' >No existe el registro de los elementos que busca</div> ",
        emptyTable: " <div class='alert alert-danger' >No se encuentran registros disponibles</div> ",
        paginate: {
            first: "Primero",
            previous: "Anterior",
            next: "Siguiente",
            last: "Ultimo"
        },
        aria: {
            sortAscending: ": activer pour trier la colonne par ordre croissant",
            sortDescheadending: ": activer pour trier la colonne par ordre décroissant"
        }
    }
});
     