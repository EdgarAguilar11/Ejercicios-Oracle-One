let rangoInicio = 1, rangoFin= 10;
let numeroSecreto = Math.floor(Math.random()*rangoFin)+rangoInicio;
let numeroUsuario = 0;
let intentos = 1;
let maximosIntentos = 3;

while(numeroUsuario != numeroSecreto){
    numeroUsuario = parseInt(prompt(`Me indicas un número entre ${rangoInicio} y ${rangoFin} por favor:`));
    console.log(typeof numeroUsuario);
    if (numeroUsuario == numeroSecreto) {
        alert(`Acertaste, el número es: ${numeroSecreto}, lo hiciste en ${intentos} ${intento == 1 ? "intento" : "intentos"}`);
    } else{
        if(numeroUsuario > numeroSecreto){
            alert("El número secreto es menor");
        }else{
            alert("El número secreto es mayor");
        }
        intentos++;
        if(intentos > maximosIntentos){
            alert("Llegaste al número maximo de intentos");
            break;
        }
    }
}


