package com.atual.covid.mapa;

import org.hibernate.Query;
import org.hibernate.Session;



public class MapaDAOHibernate implements MapaDAO {
 
	private Session session;
	
    @Override
  public Mapa buscarPorUf(String state) {
	String hql = "select u from Mapa u where u.state = :state";
	Query consulta = this.session.createQuery(hql);
	consulta.setString("state", state);
    return (Mapa) consulta.uniqueResult();
}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}



}
