package com.atual.covid.caso;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.atual.covid.boletim.Boletim;
import com.atual.covid.boletim.BoletimRN;

public class Casos implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<Caso> filtrados(FiltroCaso filtro) {
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
	
	public int quantidadeFiltrados(FiltroCaso filtro) {
		Criteria criteria = criarCriteriaParaFiltro(filtro);
		criteria.setProjection(Projections.rowCount());
		int ret =  ((Number) criteria.uniqueResult()).intValue();
		return ret;
	}
	
	private Criteria criarCriteriaParaFiltro(FiltroCaso filtro) {
		
		CasoRN casoRN = new CasoRN();
		Criteria criteria = casoRN.criteria();
		
		if (StringUtils.isNotEmpty(filtro.getCity())) {
			criteria.add(Restrictions.ilike("city", filtro.getCity(), MatchMode.ANYWHERE));
		}
		
		return criteria;
	}

}
