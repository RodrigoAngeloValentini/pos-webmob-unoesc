function validaCampo(){
	var q = document.getElementById("q").value();

	if(q ==null || q == ""){
		alert("Campo 'q' de preenchimento obrigatório!");
		return false;
	}
	return true;
}