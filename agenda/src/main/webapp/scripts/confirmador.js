/**
 * confirmador de exclusao de contato
 */

 function confirmar(idcon){
	 let resposta = confirm("Confirmar exclusao de contato?")
 	if(resposta === true){
		// alert(idcon)
		window.location.href="delete?idcon="+idcon
	 }
 }