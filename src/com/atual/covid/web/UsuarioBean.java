package com.atual.covid.web;

import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.atual.covid.client.IbgeClient;
import com.atual.covid.usuario.CriptografiaService;
import com.atual.covid.usuario.Usuario;
import com.atual.covid.usuario.UsuarioRN;
import com.atual.covid.util.RNException;
import com.atual.covid.web.util.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private String confirmarSenha;
	private List<Usuario> lista;
	public String destinoSalvar;
	List<String> estados = IbgeClient.buscarEstados();
	private static final Logger logger = LogManager.getLogger(UsuarioBean.class);

	public List<String> getEstados() {
		return estados;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.destinoSalvar = "usuariosucesso";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "/publico/usuario";
	}

	public String editar() {
		this.confirmarSenha = this.usuario.getSenha();
		return "/publico/usuario";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		String senha = this.usuario.getSenha();		
		if (!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage("As senhas digitadas são diferentes.");
			context.addMessage(null, facesMessage);
			logger.error("Erro ao criar conta: As senhas digitadas são diferentes.");
			return null;
		}
		String senhaCriptografada = CriptografiaService.criptografar(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		usuarioRN.enviarEmailPosCadastramento(this.usuario);
		return this.destinoSalvar;
	}
	public String recuperaSenha() {
		FacesContext context = FacesContext.getCurrentInstance();
		String login = this.usuario.getLogin();
		if(!login.equals(usuario.getLogin())) {
			FacesMessage facesMessage = new FacesMessage("Login digitado não está cadastrado em nosso sistema, por favor tente outro");
			context.addMessage(null, facesMessage);
			logger.error("Login digitado não está cadastrado em nosso sistema");
			return null;
		}
		FacesMessage facesMessage = new FacesMessage("Login encontrado, foi enviado um e-mail com dados de recuperação para o e-mail cadastrado em nosso sistema.");
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.recuperaSenha(login);
		logger.info("Login encontrado, foi enviado um e-mail com dados de recuperação para o e-mail cadastrado em nosso sistema.");
		return login;
	}

	public String excluir() {
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.usuario.isAtivo())
			this.usuario.setAtivo(true);
		else
			this.usuario.setAtivo(true);

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return null;
	}

	public List<Usuario> getLista() {
		if (this.lista == null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}
		return this.lista;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public String atribuiPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;
		java.util.Set<String> permissoes = this.usuario.getPermissao();
		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}
		return null;
	}

}
