/**
 * 
 */

function validar() {
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	let estado = frmContato.estado.value

	if (nome == "") {
		alert("preencha o campo Nome")
		fmrContato.nome.focus()
		return false
	} else if (fone == "") {
		alert("preencha o campo Fone")
		fmrContato.fone.focus()
		return false
	} else if (estado == "") {
		alert("preencha o campo Estado")
		fmrContato.estado.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
}