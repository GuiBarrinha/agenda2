package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
//parou aqui ==>  
/**
 * The Class Controller.
 */
//@WebServlet(urlPatterns = {"/Controller", "/main", "/insert"})
@WebServlet(name = "Controller", urlPatterns = { "/main", "/insert", "/select", "/update", "/delete", "/report" })

public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The contato. */
	JavaBeans contato = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		System.out.println("entrou no doGet");

		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// lista de contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Criando um objeto que ira receber dados do Java Beans
		ArrayList<JavaBeans> lista = dao.listarContatos();

		// Encaminhar a lista ao documento agenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	/**
	 * Novo contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Novo de contatos
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entrou novoContato");
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("endereco"));
		System.out.println(request.getParameter("dataNiver"));

		// setar variavel java beans
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));
		contato.setEstado(request.getParameter("estado"));
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFormatada;
		try {
			dataFormatada = formato.parse(request.getParameter("dataNiver"));
			contato.setDataNiver(dataFormatada);
		} catch (ParseException e) {
			System.out.println("erro na data novo contato");
			e.printStackTrace();
		}

		// invocar metodo inserirContato passando o objeto contato
		 dao.inserirContato(contato);

		// redirecionar para o documento agenda.jsp
		response.sendRedirect("main");
	}

	/**
	 * Listar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Editar contato
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Setar a varivel JavaBeans
		contato.setIdcon(Integer.valueOf(request.getParameter("idcon")));

		// Executar o metodo selecionarContato (DAO)
		dao.selecionarContato(contato);

		// Setar os atributos do formulario com o conteudo JavaBeans
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		request.setAttribute("endereco", contato.getEndereco());
		request.setAttribute("estado", contato.getEstado());
		request.setAttribute("dataNiver", contato.getDataNiver());

		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	/**
	 * Editar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis JavaBeans
		contato.setIdcon(Integer.valueOf(request.getParameter("idcon")));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));
		contato.setEstado(request.getParameter("estado"));
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFormatada;
		try {
			dataFormatada = formato.parse(request.getParameter("dataNiver"));
			contato.setDataNiver(dataFormatada);
		} catch (ParseException e) {
			System.out.println("erro na data");
			e.printStackTrace();
		}

		// Executar o metodo alterarContato
		dao.alterarContato(contato);

		// redirecionar para o documento agenda.jsp (atualizando as alteraçooes)
		response.sendRedirect("main");
	}

	/**
	 * Remover contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Remover um contato
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Setar a variavel idcon JavaBeans
		contato.setIdcon(Integer.valueOf(request.getParameter("idcon")));

		// executar o metodo deletarContato(DAO) passando o objeto contato
		dao.deletarContato(contato);

		// redirecionar para o documento agenda.jsp (atualizando as alteraçooes)
		response.sendRedirect("main");
	}

	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Gerar relatorio em PDF
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// tipo de de conteudo
			response.setContentType("apllication/pdf");

			// nome do documento
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");

			// criar documento
			PdfWriter.getInstance(documento, response.getOutputStream());

			// abrir o documento para gerar o conteudo
			documento.open();
			documento.add(new Paragraph("Lista de contatos"));
			documento.add(new Paragraph(" "));

			// criar tabela
			PdfPTable tabela = new PdfPTable(5);

			// cabeçalho
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Email"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Endereco"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Estado"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);

			// popular a tabela com os contatos
			ArrayList<JavaBeans> lista = dao.listarContatos();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getFone());
				tabela.addCell(lista.get(i).getEmail());
				tabela.addCell(lista.get(i).getEndereco());
				tabela.addCell(lista.get(i).getEstado());

			}
			documento.add(tabela);
			documento.close();

		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
}
