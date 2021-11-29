package com.atual.covid.util;

import com.atual.covid.boletim.BoletimDAO;
import com.atual.covid.boletim.BoletimDAOHibernate;
import com.atual.covid.caso.CasoDAO;
import com.atual.covid.caso.CasoDAOHibernate;
import com.atual.covid.mapa.MapaDAO;
import com.atual.covid.mapa.MapaDAOHibernate;
import com.atual.covid.usuario.UsuarioDAO;
import com.atual.covid.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

	public static BoletimDAO criarBoletimDAO() {
		BoletimDAOHibernate boletimDAO = new BoletimDAOHibernate();
		boletimDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return boletimDAO;
	}
	public static CasoDAO criarCasoDAO() {
		CasoDAOHibernate casoDAO = new CasoDAOHibernate();
		casoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());		
		return casoDAO;	
	}
	public static MapaDAO criarMapaDAO() {
		MapaDAOHibernate mapaDAO = new MapaDAOHibernate();
		mapaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());		
		return mapaDAO;	
	}

}