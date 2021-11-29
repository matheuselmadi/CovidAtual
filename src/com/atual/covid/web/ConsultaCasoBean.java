package com.atual.covid.web;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.security.core.context.SecurityContextHolder;

import com.atual.covid.caso.Caso;
import com.atual.covid.caso.CasoRN;
import com.atual.covid.caso.Casos;
import com.atual.covid.caso.FiltroCaso;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean(name = "consultaCasoBean")
@RequestScoped
public class ConsultaCasoBean implements Serializable {
	private static final Logger logger = LogManager.getLogger(ConsultaCasoBean.class);
	private static final long serialVersionUID = 1L;	
	
	private Casos casos;
	private FiltroCaso filtro;
	private LazyDataModel<Caso> model1;	
	public ConsultaCasoBean() {
		casos = new Casos();
		filtro = new FiltroCaso();
		model1 = new LazyDataModel<Caso>() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public List<Caso> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				filtro.setPrimeiroRegistro(first);
				filtro.setQuantidadeRegistros(pageSize);
				filtro.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
				filtro.setPropriedadeOrdenacao(sortField);
				setRowCount(casos.quantidadeFiltrados(filtro));				
				logger.info("Requisição realizada em cidades, pelo usuario: " +SecurityContextHolder.getContext().getAuthentication().getName());
				return casos.filtrados(filtro);
			}
			
		};
	}

	public Casos getCasos() {
		return this.casos = Objects.requireNonNull(casos);	}

	public void setCasos(Casos casos) {
		this.casos = Objects.requireNonNull(casos);
	}

	public FiltroCaso getFiltro() {
		return this.filtro = Objects.requireNonNull(filtro);
	}

	public void setFiltro(FiltroCaso filtro) {
		this.filtro = Objects.requireNonNull(filtro);
	}

	public LazyDataModel<Caso> getModel1() {
		return this.model1 = Objects.requireNonNull(model1);
	}

	public void setModel1(LazyDataModel<Caso> model1) {
		this.model1 = Objects.requireNonNull(model1);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
}
