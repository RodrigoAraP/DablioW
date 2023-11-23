/*const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome");
const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");
const Itelefone = document.querySelector(".telefone");

const message = document.querySelector("message-input");
const Imensagem = document.querySelector(".mensagem");

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


function mensagem() {

    fetch("http://localhost:8080/mensagens", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            mensagem: Imensagem.value
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

message.addEventListener('submit', function (event) {
    event.preventDefault();

    mensagem();
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

    // Obtém o nome da página atual
    const currentPage = window.location.pathname.split('/').pop();

    // Determina a página para a qual deseja navegar
    const nextPage = currentPage === 'pagInicial.html' ? 'login.html' : 'pagInicial.html';

    // Redireciona para a próxima página
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

function enviarMensagem() {
    // Obter o valor da mensagem digitada
    var mensagem = document.getElementById('mensagem').value;

    // Criar um novo elemento de mensagem e adicionar ao container
    var messageContainer = document.querySelector('.message-container');
    var novaMensagem = document.createElement('div');
    novaMensagem.className = 'message sent';
    novaMensagem.textContent = mensagem;
    messageContainer.appendChild(novaMensagem);

    // Limpar o campo de entrada após o envio
    document.getElementById('mensagemInput').value = '';
}*/





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
        .catch(function (res) { console.log(res) });
}



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
});

function toggleForm1() {
    const currentPage = window.location.pathname.split('/').pop();
    const nextPage = currentPage === 'index.html' ? 'login.html' : 'index.html';
    window.location.href = nextPage;
}

function toggleForm() {
    const currentPage = window.location.pathname.split('/').pop();
    const nextPage = currentPage === 'pagInicial.html' ? 'login.html' : 'pagInicial.html';
    window.location.href = nextPage;
}

function enviarMensagem() {
    // Obter o valor da mensagem digitada
    var mensagem = document.querySelector('.mensagem').value;

    // Criar um novo elemento de mensagem e adicionar ao container
    var messageContainer = document.querySelector('.message-container');
    var novaMensagem = document.createElement('div');
    novaMensagem.className = 'message sent';
    novaMensagem.textContent = mensagem;
    messageContainer.appendChild(novaMensagem);

    // Limpar o campo de entrada após o envio
    document.querySelector('.mensagem').value = '';

    // Chamar a função mensagem() para enviar a mensagem para o servidor
    mensagem();
}