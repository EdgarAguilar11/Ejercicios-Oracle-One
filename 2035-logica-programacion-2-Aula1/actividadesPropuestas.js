function saludo(){
    console.log("¡Hola, mundo!");
    return;
}

function saludoNombre(nombre){
    console.log(`¡Hola, ${nombre}!`);
    return;
}

function dobleNumero(numero){
    let doble = numero * 2;
    console.log(`El doble del número es ${doble}`);
    return;
}

function promedio(n1,n2,n3){
    let promedio = (n1+n2+n3) / 3;
    console.log(`El promedio de ${n1}, ${n2} y ${n3} es ${promedio}`);
}

function numeroMayor(n1, n2){
    if(n1 > n2){
        console.log(`${n1} es mayor que ${n2}`);
    }else{
        console.log(`${n2} es mayor que ${n1}`);
    }
}

function multiplicaPorSiMismo(numero){
    console.log(`${numero} multiplicado por si mismo es ${numero*numero}`);
}

function indiceMasaCorporal(altura, peso){
    return (peso / Math.pow(altura,2));
}

function calculaFactorial(numero){
    if(numero >= 0){
        if(numero === 0){
            return 1;
        }else{
            let contador = 1;
            let resultado = 1;
            do{
                resultado *= contador;
                contador++;
            }while(contador <= numero);
            return resultado;
        }
    }else{
        return;
    }
}

function convertirDolarAReales(dolares){
    return dolares * 4.80;
}

function obtenAreaCirculo(radio){
    return Math.PI * Math.pow(radio,2);
}

function obtenPerimetroCirculo(){
    return Math.PI * (radio * 2);
}

function obtenerAreaRectangulo(altura, anchura){
    return altura*anchura;
}

function obtenerPerimetroRectangulo(altura, anchura){
    return (2*altura)+(2*anchura);
}

function muestraAreaPerimetroCirculo(radio){
    console.log(`El área del circulo con radio ${radio} es: ${obtenAreaCirculo(radio)}. El perimetro es: ${obtenPerimetroCirculo(radio)}`);
}

function muestraAreaPerimetroRectangulo(altura, anchura){
    console.log(`El área del rectangulo es ${obtenerAreaRectangulo(altura, anchura)} y el perimetro es ${obtenerPerimetroRectangulo(altura, anchura)}`);
}

function muestraTablaMultiplicar(numero){
    let contador = 0;
    let resultado = 0;
    do{
        console.log(`${numero} x ${contador} = ${numero * contador}`);
        contador++;
    }while(contador <= 10);
}

// retos de listas

let listaGenerica = [];
let lenguajesDeProgramacion = ["JavaScript", "C", "C++", "Kotlin", "Python"];
let lenguajesDeProgramacionDos = ["Java", "Ruby", "GoLang"];

function imprimerListaLenguajes(){
    console.log(lenguajesDeProgramacion);
    console.log(lenguajesDeProgramacionDos);
}

function imprimerListaLenguajesInverso(){
    let listaReverse = lenguajesDeProgramacion.reverse();
    let listaReverseDos = lenguajesDeProgramacionDos.reverse();
    console.log(listaReverse);
    console.log(listaReverseDos);
}

function calculaPromedio(listaNumeros){
    let total = 0;

    if(listaNumeros.length > 0){
        listaNumeros.forEach(element => {
            total += element;
        });
        return total / listaNumeros.length;
    }
    return;
}

function numeroPequenoGrande(listaNumeros){
    let numeroGrande = 0;
    let numeroPequeno = 0;
    if(listaNumeros.length > 0){
        listaNumeros.forEach(element => {
            if(element > numeroGrande){
                numeroGrande = element;
            }
            if(element < numeroPequeno){
                numeroPequeno = element;
            }
        });
    }
}

function sumaElementos(listaNumeros){
    let total = 0;
    if(listaNumeros.length > 0){
        listaNumeros.forEach(element => {
            total += element;
        });
        return total;
    }
    return;
}

function encontrarPosicionElemento(listaNumeros, elementoEncontrar){
    let posicion = -1;
    return listaNumeros.indexOf(elementoEncontrar);
}

function sumaDeListas(listaUno, listaDos){
    if(listaUno.length > 0 && listaDos.length > 0 && listaUno.length === listaDos.length){
        let tamanoListas = listaUno.length;
        for(let i = 0; i<tamanoListas; i++){
            console.log(listaUno[i] + listaDos[i]);
        }
    }
}

function listaCuadrados(listaNumeros){
    let listaCuadrados = [];
    if(listaNumeros.length > 0){
        listaNumeros.forEach(elemento =>{
            listaCuadrados.push(Math.pow(elemento,2));
        })
    }
    return listaCuadrados;
}