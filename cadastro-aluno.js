// const form = document.getElementById("form-aluno");

// form.addEventListener("submit", function(event) {
//     event.preventDefault();

//     const aluno = {
//         nome: document.getElementById("nome").value + " " + document.getElementById("sobrenome").value,
//         email: document.getElementById("email").value,
//         senha: "12345678", // TEMPORÁRIO (já que backend exige)
//         curso: document.getElementById("curso").value
//     };

//     fetch("http://localhost:8080/usuarios", {
//         method: "POST",
//         headers: {
//             "Content-Type": "application/json"
//         },
//         body: JSON.stringify(aluno)
//     })
//     .then(res => {
//         if (res.status === 201) {
//             alert("Aluno cadastrado com sucesso!");
//             window.location.href = "alunos.html";
//         } else {
//             alert("Erro ao cadastrar");
//         }
//     })
//     .catch(err => console.log(err));
// });

// O código acima funciona com a primeira versão do cadastro-aluno.html

const form = document.getElementById("form-aluno");

form.addEventListener("submit", function(event) {
    event.preventDefault();

    const aluno = {
        nome: document.getElementById("nome").value,
        email: document.getElementById("email").value,
        curso: document.getElementById("curso").value
    };

    fetch("https://projeto-do-hackton-login.onrender.com/alunos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(aluno)
    })
    .then(res => {
        if (res.status === 201) {
            alert("Aluno cadastrado!");
            window.location.href = "alunos.html";
        } else {
            alert("Erro ao cadastrar");
        }
    })
    .catch(err => console.log(err));
});