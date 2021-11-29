package com.atual.covid.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.security.core.context.SecurityContextHolder;

import com.atual.covid.boletim.Boletim;
import com.atual.covid.boletim.Boletins;
import com.atual.covid.boletim.FiltroBoletim;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@ManagedBean(name = "consultaBoletimBean")
@RequestScoped
public class ConsultaBoletimBean implements Serializable {

	private static final long serialVersionUID = 1L;	
	private static final Logger logger = LogManager.getLogger(ConsultaBoletimBean.class);
	
	private Boletins boletins;
	
	private FiltroBoletim filtro;
	
	private LazyDataModel<Boletim> model;
	public ConsultaBoletimBean() {
		boletins = new Boletins();
		filtro = new FiltroBoletim();
		model = new LazyDataModel<Boletim>() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public List<Boletim> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				filtro.setPrimeiroRegistro(first);
				filtro.setQuantidadeRegistros(pageSize);
				filtro.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
				filtro.setPropriedadeOrdenacao(sortField);
				setRowCount(boletins.quantidadeFiltrados(filtro));				
				logger.info("Requisição realizada por UF na pagina principal, pelo usuario: " +SecurityContextHolder.getContext().getAuthentication().getName());
				return boletins.filtrados(filtro);
			}
			
		};
	}
	

	public Boletins getBoletins() {
		return boletins;
	}


	public void setBoletins(Boletins boletins) {
		this.boletins = boletins;
	}


	public FiltroBoletim getFiltro() {
		return filtro;
	}


	public void setFiltro(FiltroBoletim filtro) {
		this.filtro = filtro;
	}


	public void setModel(LazyDataModel<Boletim> model) {
		this.model = model;
	}


	public LazyDataModel<Boletim> getModel() {
		return model;
	}
	

}
