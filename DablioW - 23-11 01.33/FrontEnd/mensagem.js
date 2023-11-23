//const Imensagem = document.querySelector(".mensagem");
const formulario = document.querySelector("div");

/*
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
        .catch(function (res) { console.log(res) });
}*/


function limpar() {
    Imensagem.value = "";
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();
    mensagem();
    limpar();
});




let Imensagem = ""; // Adicione essa linha para inicializar a variável

function enviarMensagem() {
    // Obter o valor da mensagem digitada
    var mensagem = document.getElementById('mensagemInput').value;

    // Armazenar a mensagem na variável Imensagem
    Imensagem = mensagem;

    // Criar um novo elemento de mensagem e adicionar ao container
    var messageContainer = document.querySelector('.message-container');
    var novaMensagem = document.createElement('div');
    novaMensagem.className = 'message sent';
    novaMensagem.textContent = mensagem;
    messageContainer.appendChild(novaMensagem);

    // Limpar o campo de entrada após o envio
    document.getElementById('mensagemInput').value = '';

    // Enviar a mensagem para o servidor Spring Boot
    fetch('http://localhost:8080/mensagens', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            txt_msg: mensagem, // Nome do atributo na sua classe Mensagem
            dt_envio: new Date(), // Data atual
            // Se você tiver o id do usuário, inclua-o aqui
            // id_user: <ID_DO_USUARIO>,
        }),
    })
        .then(response => response.json())
        .then(data => {
            console.log(data); // Aqui você pode lidar com a resposta do servidor, se necessário
        })
        .catch((error) => {
            console.error('Erro:', error);
        });
}
