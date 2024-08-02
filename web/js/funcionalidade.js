function exibir(){
    let d = new Date();
    var input = document.querySelector("#idNome");
    var nome = input.value;
    document.body.innerHTML =
     `
     <h1>Parabéns ${nome}, seu primeiro programa web com JavaScript.</h1>
     <h1> Manaus, ${d.toLocaleDateString()} às ${d.getHours()} h </h1>
    `;
}


