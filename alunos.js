const tbody = document.querySelector("tbody");
const totalAlunos = document.getElementById("total-alunos");

document.addEventListener("DOMContentLoaded", () => {
    listarUsuarios();
});

function listarUsuarios() {
    fetch("https://projeto-do-hackton-login.onrender.com/alunos")
        .then(res => res.json())
        .then(dados => {
            preencherTabela(dados);
            totalAlunos.innerText = dados.length;
        })
        .catch(err => console.log(err));
}

function preencherTabela(usuarios) {
    tbody.innerHTML = "";

    usuarios.forEach(usuario => {
        const tr = document.createElement("tr");

        tr.innerHTML = `
            <td>${usuario.id}</td>
            <td>${usuario.nome}</td>
            <td>${usuario.email}</td>
            <td>${usuario.curso}</td>
           <td>
                <button class="btn-editar" onclick="editar(${usuario.id})">Editar</button>
                <button class="btn-excluir" onclick="deletar(${usuario.id})">Excluir</button>
            </td>
        `;

        tbody.appendChild(tr);
    });
}

function deletar(id) {
    if (!confirm("Tem certeza que deseja excluir?")) return;

    fetch(`https://projeto-do-hackton-login.onrender.com/alunos/${id}`, {
        method: "DELETE"
    })
    .then(() => {
        alert("Usuário deletado!");
        listarUsuarios();
    })
    .catch(err => console.log(err));
}

function editar(id) {
    window.location.href = `editar-aluno.html?id=${id}`;
}