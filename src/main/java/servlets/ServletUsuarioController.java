package servlets;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DAOUsuarioRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;
import jakarta.servlet.http.HttpServlet;

@WebServlet(urlPatterns =  {"/ServletUsuarioController"})
public class ServletUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAOUsuarioRepository daoUsuarioRepository = new DAOUsuarioRepository();

	public ServletUsuarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String acao = request.getParameter("acao");

			if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletar")) {
				String idUser = request.getParameter("id");
				
				daoUsuarioRepository.deletarUser(idUser);
				
				request.setAttribute("msg", "Excluido com Sucesso!!!");
				request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
				
				List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList();
				request.setAttribute("modelLogins", modelLogins);

			}else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletarajax")) {
				String idUser = request.getParameter("id");
				
				daoUsuarioRepository.deletarUser(idUser);
				
				response.getWriter().write("excluido com sucesso");
			}
			
			else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarUserAjax")) {
				
				String nomeBusca = request.getParameter("nomeBusca");
				
				List<ModelLogin> dadosJsonUser = daoUsuarioRepository.consultaUsuarioList(nomeBusca);
				
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(dadosJsonUser);
				
				response.getWriter().write(json);
			}
			
			else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarEditar")) {
				String id = request.getParameter("id");
				
				ModelLogin modelLogin = daoUsuarioRepository.consultaUsuarioID(id);
				
				List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList();
				request.setAttribute("modelLogins", modelLogins);
				
				request.setAttribute("msg", "Usuário em edição");
				request.setAttribute("modoLogin", modelLogin);
				request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
			}
			
			else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("listarUser")) {
				List<ModelLogin> modelLogin = daoUsuarioRepository.consultaUsuarioList();
				
				request.setAttribute("msg", "Todos os Usuários");
				request.setAttribute("modelLogins", modelLogin);
				request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
			}
			
			else {
				List<ModelLogin> modelLogin = daoUsuarioRepository.consultaUsuarioList();
				request.setAttribute("modelLogins", modelLogin);
				
				request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String msg = "operação realizada com sucesso";

			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String email = request.getParameter("email");

			ModelLogin modelLogin = new ModelLogin();

			modelLogin.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
			modelLogin.setNome(nome);
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
			modelLogin.setEmail(email);

			if (daoUsuarioRepository.validarLogin(modelLogin.getLogin()) && modelLogin.getId() == null) {
				msg = "Já existe esse uruário com o mesmo login...";
			} else {
				if (modelLogin.isNovo()) {
					msg = "Gravado com Sucesso!!!";
				} else {
					msg = "Atualizado com sucesso!";
				}

				modelLogin = daoUsuarioRepository.gravarUsuario(modelLogin);
			}
			
			List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList();
			request.setAttribute("modelLogins", modelLogins);

			request.setAttribute("msg", msg);
			request.setAttribute("modoLogin", modelLogin);
			request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
		}
	}

}
