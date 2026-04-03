console.log("JS carregado");
const form = document.querySelector("form");

const Iemail = document.querySelector("input[name='email']");
const Isenha = document.querySelector("input[name='senha']");

function logar() {
    fetch("https://projeto-do-hackton-login.onrender.com/professores/login", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            email: Iemail.value,
            senha: Isenha.value
        })
    })
    .then(res => {
        if (res.status === 200) {
            alert("Login realizado com sucesso!");
            window.location.href = "alunos.html";
        } else {
            alert("Email ou senha inválidos");
        }
    })
    .catch(err => console.log(err));
}

form.addEventListener("submit", function(event) {
    event.preventDefault();
    logar();
});