package com.atual.covid.usuario;

import java.util.List;
import java.util.Locale;

import org.hibernate.Query;
import org.hibernate.Session;

import com.atual.covid.util.DAOFactory;
import com.atual.covid.util.RNException;
import com.atual.covid.util.UtilException;
import com.atual.covid.web.util.EmailService;

public class UsuarioRN {
	private UsuarioDAO usuarioDAO;
	private Session session;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}

	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
		if (codigo == null || codigo == 0) {
			    usuario.setAtivo(true);
				usuario.getPermissao().add("ROLE_USUARIO"); 
				this.usuarioDAO.salvar(usuario);
			} else {
				this.usuarioDAO.atualizar(usuario);
		}
	}
     public void enviarEmailPosCadastramento(Usuario usuario) {
		
		EmailService emailService = new EmailService();
		emailService.sendEmail(usuario.getEmail(), "Boas vindas", "Seja bem vindo ao COVID ATUAL, " +usuario.getNome());
		
	}
	
     public void recuperaSenha(String login) {
    	    Usuario usuario = buscarPorLogin(login);
    	    String descrip = CriptografiaService.descriptografar(usuario.getSenha());
    	    //emailService.encaminharEmail();
    	    if(usuario != null) {
    	    	 EmailService emailService = new EmailService();
    	         emailService.sendEmail(usuario.getEmail(), "\n\tOlá, sua solicitação de recuperação de senha foi aceita. ",
    	         "\n\tSeu login é: " + usuario.getLogin() + "\n\te sua senha é: "+descrip.toString() + 
    	         "\n\tCaso queira realizar login agora, clique no link à seguir: "+ "http://localhost:8080/projeto_covid/publico/login.jsf");    
    	    }

    	}

	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}

	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}
}
