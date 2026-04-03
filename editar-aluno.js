const params = new URLSearchParams(window.location.search);
const id = params.get("id");

document.addEventListener("DOMContentLoaded", () => {
    fetch(`https://projeto-do-hackton-login.onrender.com/alunos/${id}`)
        .then(res => res.json())
        .then(aluno => preencherFormulario(aluno))
        .catch(err => console.log(err));
});

function preencherFormulario(aluno) {
    document.getElementById("matricula").value = aluno.id;
    document.getElementById("nome").value = aluno.nome;
    document.getElementById("email").value = aluno.email;
    document.getElementById("curso").value = aluno.curso;
}

const form = document.getElementById("form-editar-aluno");

form.addEventListener("submit", function (e) {
    e.preventDefault();

    const alunoAtualizado = {
        nome: document.getElementById("nome").value,
        email: document.getElementById("email").value,
        curso: document.getElementById("curso").value
    };

    fetch(`https://projeto-do-hackton-login.onrender.com/alunos/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(alunoAtualizado)
    })
    .then(() => {
        alert("Aluno atualizado com sucesso!");
        window.location.href = "alunos.html";
    })
    .catch(err => console.log(err));
});