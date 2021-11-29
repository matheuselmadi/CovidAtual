package com.atual.covid.boletim;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Boletins  implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<Boletim> filtrados(FiltroBoletim filtro) {
		Criteria criteria = criarCriteriaParaFiltro(filtro);
		
		criteria.setFirstResult(filtro.getPrimeiroRegistro());
		criteria.setMaxResults(filtro.getQuantidadeRegistros());
		
		if (filtro.isAscendente() && filtro.getPropriedadeOrdenacao() != null) {
			criteria.addOrder(Order.asc(filtro.getPropriedadeOrdenacao()));
		} else if (filtro.getPropriedadeOrdenacao() != null) {
			criteria.addOrder(Order.desc(filtro.getPropriedadeOrdenacao()));
		}
		
		return criteria.list();
	}
	
	public int quantidadeFiltrados(FiltroBoletim filtro) {
		Criteria criteria = criarCriteriaParaFiltro(filtro);
		criteria.setProjection(Projections.rowCount());
		int ret =  ((Number) criteria.uniqueResult()).intValue();
		return ret;
	}
	
	private Criteria criarCriteriaParaFiltro(FiltroBoletim filtro) {
		
		BoletimRN boletimRN = new BoletimRN();
		Criteria criteria = boletimRN.criteria();
		
		if (StringUtils.isNotEmpty(filtro.getEstado())) {
			criteria.add(Restrictions.ilike("estados", filtro.getEstado(), MatchMode.ANYWHERE));
		}
		
		return criteria;
	}


}
