package com.atual.covid.boletim;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

public class BoletimDAOHibernate implements BoletimDAO {

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public List<Boletim> listar() {
		return this.session.createCriteria(Boletim.class).list();
	}

	@Override
	public List<Boletim> buscarPorUf(String estados) {
	String hql = "select b from boletim b where b.estados = :estados";
	Query consulta = this.session.createQuery(hql);
	consulta.setString("estados", estados);
    return consulta.list();
	}
	
	@Override
	public Criteria criteria() {
		return this.session.createCriteria(Boletim.class);
		
	}
}
