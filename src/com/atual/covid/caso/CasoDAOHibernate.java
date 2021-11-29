package com.atual.covid.caso;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.atual.covid.boletim.Boletim;

public class CasoDAOHibernate implements CasoDAO {
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Caso> listar() {
		Criteria crit = session.createCriteria(Caso.class);
		crit.add(Restrictions.ne("city", ""));
		crit.add(Restrictions.ge("data", "2021-01-01"));
		List results = crit.list();
		return results;
	}


	@Override
	public Criteria criteria() {
		Criteria crit = session.createCriteria(Caso.class);
		crit.add(Restrictions.ne("city", ""));
		crit.add(Restrictions.ge("data", "2021-01-01"));
		return crit;
		
	}
    @Override
    public List<Caso> listando(String pesquisa){	
    	Criteria crit = session.createCriteria(Caso.class);
    	crit.setFirstResult(0);
    	crit.setMaxResults(10);
		crit.add(Restrictions.eq("state", pesquisa));
		crit.add(Restrictions.ge("data", "2021-01-01"));
		List results = crit.list();
		return results;	
    }
}