// Actividades propuestas
alert("¡Bienvenida y bienvenido a nuestro sitio web");

let nombre = "Luna";
let edad = 25;
let numeroDeVentas = 50;
let saldoDisponible = 1000;
let mensajeDeError = "¡Error! Completa todos los campos";

alert(mensajeDeError);

let pideNombre = prompt("Ingresa tu nombre");
let pideEdad = prompt("Ingresa tu edad");

if(pideEdad > 18){
    alert("¡Puedes obtener tu licencia de conducir!");
}

let diaSemana = prompt("Ingresa que día de la semana es:");
if(diaSemana == "Sábado" || diaSemana == "Domingo"){
    alert("¡Buen fin de semana!");
}else{
    alert("¡Buena semana!");
}

let numeroUsusario = prompt("Ingresa un número:");
if(numeroUsusario > 0){
    alert(`El número ${numeroUsusario} es positivo`);
}else if(numeroUsusario < 0){
    alert(`El número ${numeroUsusario} es negativo`);
}else{
    alert(`El número es ${numeroUsusario}`);
}

let puntuacion = prompt("Ingresa puntuación:");
if(puntuacion > 100){
    alert("¡Felicidades, has ganado!");
}else{
    alert("Intenta nuevamente para ganar");
}

let saldo = 100;
alert(`El saldo de tu cuenta es: ${saldo}`);

let nombreBienvenida = prompt("Ingresa tu nombre: ");
alert(`Bienvenido querido ${nombreBienvenida}`);

let contadorUno = 1;
while(contadorUno <=10){
    console.log(contadorUno);
    contadorUno++;
}

let contadorDos = 10;
while(contadorDos >= 0){
    console.log(contadorDos);
    contadorDos++;
}

let numeroProgresivoUsuario = prompt("Ingresa un número para el conteo progresivo");
let contadorTres = 0;
do{
    console.log(`Numero progresivo ${contadorTres}`);
    if(numeroProgresivoUsuario < 0) {
        contadorTres--;
    } else if(numeroProgresivoUsuario > 0) {
        contadorTres++;
    }
}while(contadorTres != numeroProgresivoUsuario);


console.log("Bienvenido");

let nombreGuardado = prompt("Ingresa tu nombre:");
console.log(`¡Hola, ${nombreGuardado}`);

alert(`¡Hola, ${nombreGuardado}`);

let lenguaje = prompt("¿Cúal es el lenguaje de programación que más te gusta?");
console.log(lenguaje);

let valor1 = 1, valor2 = 2;
resultadoSuma = valor1 + valor2;
resultadoResta = valor1 - valor2;
console.log(`La suma de ${valor1} y ${valor2} es igual a ${resultadoSuma}`);
console.log(`La diferencia de ${valor1} y ${valor2} es igual a ${resultadoResta}`);

let edadUsuario = parseInt(prompt("Ingresa tu edad:"));
if(edadUsuario > 18){
    alert("Eres mayor de edad");
}else{
    alert("Eres menor de edad");
}

let numeroGuardado = parseInt(prompt("Ingresa un número:"));
if(nombreGuardado > 0){
    alert("El número es positivo");
}else if(nombreGuardado < 0){
    alert("El número es negativo");
}else {
    alert("El número es cero");
}

let contador = 1;
while(contador <= 10){
    console.log(contador);
}

let nota = 10;
if(nota > 7){
    console.log("Aprobado");
}else{
    console.log("Reprobado");
}

console.log(Math.floor(Math.random()));

console.log(Math.floor(Math.random()*10)+1);

console.log(Math.floor(Math.random()*1000)+1);

