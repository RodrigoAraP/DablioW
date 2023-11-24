
const formulario = document.querySelector("div");


function limpar() {
    Imensagem.value = "";
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();
    mensagem();
    limpar();
});


function toggleForm() {
    // Obtém o nome da página atual
    const currentPage = window.location.pathname.split('/').pop();

    // Determina a página para a qual deseja navegar
    const nextPage = currentPage === 'pagInicial.html' ? 'login.html' : 'pagInicial.html';

    // Redireciona para a próxima página
    window.location.href = nextPage;
}





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
document.addEventListener('DOMContentLoaded', function () {
    const chatItems = document.querySelectorAll('.chat-item');
    const contactName = document.querySelector('.contact-name');
    const messageContainer = document.querySelector('.message-container');

    chatItems.forEach(item => {
        item.addEventListener('click', function () {
            // Limpar o conteúdo da área de mensagens
            messageContainer.innerHTML = '';

            // Atualizar o nome do contato na barra de título
            contactName.textContent = '* ' + item.textContent.trim() + ' *';
        });
    });
});
