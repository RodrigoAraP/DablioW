const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome");
const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");
const Itelefone = document.querySelector(".telefone");

function cadastrar() {

    fetch("http://localhost:8080/usuarios", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inome.value,
            email: Iemail.value,
            senha: Isenha.value,
            telefone: Itelefone.value
        })
    })
        .then(function (res) { console.log(res) })
        .catch(function (res) { console.log(res) })
};

function limpar() {
    Inome.value = "";
    Iemail.value = "";
    Isenha.value = "";
    Itelefone.value = "";
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    cadastrar();
    limpar();
})

function toggleForm1() {
    // Obtém o nome da página atual
    const currentPage = window.location.pathname.split('/').pop();

    // Determina a página para a qual deseja navegar
    const nextPage = currentPage === 'index.html' ? 'login.html' : 'index.html';

    // Redireciona para a próxima página
    window.location.href = nextPage;
}

function toggleForm() {

    const currentPage = window.location.pathname.split('/').pop();

    let nextPage;
    if (currentPage === 'pagInicial.html') {
        nextPage = 'login.html';
    } else {
        if (condicao) {
            nextPage = 'pagInicial.html';
        }
    }

    window.location.href = nextPage;
}

function login() {
    var nome = document.getElementById("nome").value;
    var senha = document.getElementById("senha").value;

    // Enviar solicitação para o servidor Spring Boot
    fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ 
            nome: nome, 
            senha: senha 
        }),
    })
    .then(response => response.text())
    .then(data => {
        alert(data);
    })
    .catch((error) => {
        console.error('Erro:', error);
    });
}
