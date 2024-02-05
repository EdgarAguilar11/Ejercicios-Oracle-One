let numeroSecreto = 0;
let intentos = 0;
let listaNumerosSorteados = [];
let numeroMaximo = 10;
let numeroMinimo = 10;

function asignarTextoElemento(elemento, texto){
    let elementoHTML = document.querySelector(elemento);
    elementoHTML.innerHTML = texto;
    return;
}

function verificarIntento(){
    console.log(numeroSecreto);
    console.log(intentos);

    let numeroDelUsuario = parseInt(document.getElementById("valorUsuario").value);
    if(numeroDelUsuario === numeroSecreto){
        asignarTextoElemento("p",`Acertaste el número en ${intentos} ${(intentos === 1) ? "vez" : "veces"}`);
        document.getElementById("reiniciar").removeAttribute("disabled");
    }else{
        if(numeroDelUsuario > numeroSecreto){
            asignarTextoElemento("p","El número secreto es menor");
        }else{
            asignarTextoElemento("p","El número secreto es mayor");
        }
        intentos++;
        limpiarCaja();
    }
    return;
}

function generarNumeroSecreto(){
    let numeroGenerado = Math.floor(Math.random()*(numeroMaximo - numeroMinimo + 1)+numeroMinimo);
    let contador = 0;
    let auxNumeroMinimo = numeroMinimo;
    while(auxNumeroMinimo <= numeroMaximo){
        auxNumeroMinimo++;
        contador++;
    }
    console.log(contador);
    if(listaNumerosSorteados.length == contador){
        console.log("Generaste todos los numeros posibles")
    }else{
        //si el número generado esta en la lista
        if(listaNumerosSorteados.includes(numeroGenerado)){
            return generarNumeroSecreto();
        }else{
            listaNumerosSorteados.push(numeroGenerado);
            console.log(listaNumerosSorteados);
            return numeroGenerado;
        }
    }
}
function limpiarCaja(){
    document.querySelector("#valorUsuario").value = "";
}

function condicionesIniciales(){
    asignarTextoElemento("h1","Juego del número secreto");
    asignarTextoElemento("p",`Indica un número del ${numeroMinimo} al ${numeroMaximo}`);
    numeroSecreto = generarNumeroSecreto(10,1);
    intentos = 1;
}

function reiniciarJuego(){
    //limpiar caja
    limpiarCaja();
    //indicar mensaje de inicio4
    condicionesIniciales();
    //generar numero aleatorio
    //inicializar el numero de intentos
    //deshabilitar el boton de nuevo juego
    document.querySelector("#reiniciar").setAttribute("disabled", "true");
}

condicionesIniciales();