document.querySelector("h1").innerHTML = "Hora del desafio";

function btnConsole(){
    alert("El botón fue clicado");
}

function btnPrompt(){
    let ciudadBrazil = prompt("Ingresa una ciudad de Brazil");
    alert(`Estuve en ${ciudadBrazil} y me acorde de ti`);
}

function btnAlert(){
    alert("Yo amo JS")
}

function btnSuma(){
    let numero1 = parseInt(prompt("Ingresa el primer número de la suma"));
    let numero2 = parseInt(prompt("Ingresa el segundo número de la suma"));
    alert(`La suma de ${numero1} y ${numero2} es igual a ${numero1+numero2}`);
}