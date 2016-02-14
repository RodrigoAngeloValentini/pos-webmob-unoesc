function Carro(modelo, marca, ano, motor){
	//o this é uma autoreferencia
	//ao objeto
	this.modelo = modelo;
	this.marca = marca;
	this.ano = ano;
	this.motor = motor;
}
function toString(){
	return this.modelo + "-" + this.marca + "-" + this.ano + "-" + this.motor;
}

function consumo(km){
	return (km / (15/this.motor));
}
//criando novos carros

var carro1 = new Carro("Palio", "Fiat", "2013", "1.0");
carro1.toString = toString;
carro1.consumo = consumo;

var carro2 = new Carro("Siena", "Fiat", "2012", "1.4");
carro2.toString = toString;

/*alert(carro1.modelo);
alert(carro1.marca);
alert(carro1.ano);
alert(carro1.motor);
alert(carro1);*/
alert(carro1.toString());

/*alert(carro2.modelo);
alert(carro2.marca);
alert(carro2.ano);
alert(carro2.motor);
alert(carro2);*/
alert(carro2.toString());

alert(carro1.consumo(300));

// looping for para criar 100 carros
// adicionar cada carro criado a um vetor
// imprimir todos os dados dos carros criados
// com document.write();
var vetor_carro = [];

for(i=0; i<100;i++){
	carro = new Carro("Modelo"+i,"Marca"+i,"2015","1.8");
	carro.toString = toString;
	vetor_carro[i] = carro;
}
//vetor.toString = toString;
for(i=0; i<100;i++){
	document.write(vetor_carro[i].toString()+"<br/>");
}

/* for com o in
for (c in carros){
	document.write(carros[c].toString());
}
*/

/* for com foreach
carros.forEach(function(carro){
	alert(carro.toString());
});
*/