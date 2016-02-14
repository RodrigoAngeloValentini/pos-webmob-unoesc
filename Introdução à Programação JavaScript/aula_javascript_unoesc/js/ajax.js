var xhr = new XMLHttpRequest();

//alert(xhr);

function processaDados(){
	//testando a resposta
	if(xhr.status == 200 && xhr.readyState ==4){
		//está pronto o processamento
		//voltou resposta
		alert(xhr.responseText);
		document.getElementById("divResultado").innerHTML = xhr.responseText;
		document.getElementById("txtResultado").value = xhr.responseText;
		//Quebrar a resposta pelo \n e adicionar as cidades no select
		var string_quebrada = xhr.responseText.split('\n');

		var response;
		for(i=0;i<string_quebrada.length;i++){
			response +='<option>'+string_quebrada[i]+'</option>';
		}
		//alert(response);
		document.getElementById("cidades").innerHTML= response;
	}
}

function chamadaAjax(){
	//setando a função de processamento
	xhr.onreadystatechange = processaDados;
	//abrindo a conexao
	xhr.open("get","estados.txt");
	xhr.send();//faz a requisição sem parametros
}