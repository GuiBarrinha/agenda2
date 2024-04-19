package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UsuarioDAO;
import model.Usuarios;

@WebServlet(name = "Login", urlPatterns = { "/login" })

/**
 * Servlet implementation class login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("entrou doget");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuarios usuario = new Usuarios();
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("password"));
		usuario = usuarioDAO.selecionarUsuario(usuario);
		if (usuario.getEmail() == null && usuario.getSenha()==null) {
			String mensagem = "usuario nao encontrado";
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("message", mensagem);
			dispatcher.forward(request, response);
			//response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("main");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("entrou dopost");

		doGet(request, response);
	}

}
