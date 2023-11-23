public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome"); // Obtenha o nome de usuário
        String senha = request.getParameter("senha"); // Obtem a senha

        // Lógica para validar o usuário e a senha
        boolean credenciaisValidas = validarCredenciais(nome, senha);

        if (credenciaisValidas) {
            // Redireciona para a página principal
            response.sendRedirect("/DablioW/FrontEnd/pageInicial.html"); // Substitua "pagina_principal.jsp" pelo
                                                                         // caminho da sua página principal
        }
    }

    private boolean validarCredenciais(String nome, String senha) {
        // Lógica para validar as credenciais do usuário, por exemplo, consulta ao banco
        // de dados, comparação com dados armazenados, etc.
        // Retorne true se as credenciais forem válidas e false caso contrário
        return (usuario.equals("usuario_correto") && senha.equals("senha_correta"));
    }
}
