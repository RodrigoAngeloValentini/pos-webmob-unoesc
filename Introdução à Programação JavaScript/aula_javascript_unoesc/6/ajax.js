var xhr = new XMLHttpRequest();

function processaDados(){
	if(xhr.status == 200 && xhr.readyState ==4){
		//está pronto o processamento
		//voltou resposta
		var meuObjeto = JSON.parse(xhr.responseText);
		//console.log(meuObjeto);
		if(meuObjeto.erro){
			alert('CEP Inexistente');
		}else{
			document.getElementById("rua").value = meuObjeto.logradouro;
			document.getElementById("bairro").value = meuObjeto.bairro;
			document.getElementById("cidade").value = meuObjeto.localidade;
			document.getElementById("uf").value = meuObjeto.uf;
			document.getElementById("ibge").value = meuObjeto.ibge;
		}	
	}
}
function verificacep(valor){
	var cep = valor.replace(/\D/g, '');

	var validacep = /^[0-9]{8}$/;

	if (cep != "") {
		if(validacep.test(cep)){
			pesquisacep(cep);
		}else{
			alert('CEP Inválido');
			document.getElementById("cep").value = '';
		}
	}else{
		alert('CEP nulo');
	}
}
function pesquisacep(cep){
	//setando a função de processamento
	xhr.onreadystatechange = processaDados;
	//abrindo a conexao
	xhr.open("get","https://viacep.com.br/ws/"+cep+"/json/");
	xhr.send();//faz a requisição sem parametros
}

function processaDados2(){
	if(xhr.status == 200 && xhr.readyState ==4){
		//está pronto o processamento
		//voltou resposta
		document.getElementById("result").value = xhr.responseText;
		//console.log(meuObjeto);
		
	}
}

function buscacep(){

	var uf = document.getElementById("estado").value;
	var localidade = document.getElementById("localidade").value;
	var logradouro = document.getElementById("logradouro").value;

	xhr.onreadystatechange = processaDados2;
	//abrindo a conexao
	xhr.open("get","https://viacep.com.br/ws/"+uf+"/"+localidade+"/"+logradouro+"/json/");
	xhr.send();//faz a requisição sem parametros
}