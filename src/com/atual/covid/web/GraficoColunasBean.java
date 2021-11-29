package com.atual.covid.web;

import java.time.LocalDate;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.enterprise.context.RequestScoped;

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
@ManagedBean(name = "graficoColunasBean")
@RequestScoped
public class GraficoColunasBean {
	private BarChartModel casosColunas;
	private Casos casos;
	private FiltroCaso filtro;
	private LazyDataModel<Caso> model2;
	public String pesquisa;
	private static final Logger logger = LogManager.getLogger(GraficoColunasBean.class);
	public GraficoColunasBean() {
		this.casosColunas = new BarChartModel();

	}

	public void  busca() {
		List<Caso> casos;
		casos = new CasoRN().listando(pesquisa);
		this.casosColunas = new BarChartModel();
		logger.info("Requisição realizada em busca de graficos, pelo usuario: " +SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println(pesquisa.toString());
		for (Caso e : casos) {
			ChartSeries casoseries = new ChartSeries();
			casoseries.setLabel(e.getData());
			casoseries.set(e.getDeaths(), e.getConfirmed());
			this.casosColunas.addSeries(casoseries);
	
		}
		this.casosColunas.setTitle("Gráfico de casos confirmados de COVID-19, por estado");
		this.casosColunas.setLegendPosition("w");

		Axis xAxis = this.casosColunas.getAxis(AxisType.X);
		xAxis.setLabel("Gráfico por dia, a partir de 01/01/2021");

		Axis yAxis = this.casosColunas.getAxis(AxisType.Y);
		yAxis.setLabel("Casos confirmados");
		yAxis.setMin(1000);
		yAxis.setMax(1800000);
	}
	
	

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public BarChartModel getCasosColunas() {
		return this.casosColunas = Objects.requireNonNull(casosColunas);
	}

	public void setCasosColunas(BarChartModel casosColunas) {
		this.casosColunas = Objects.requireNonNull(casosColunas);
	}

	public Casos getCasos() {
		return casos;
	}

	public void setCasos(Casos casos) {
		this.casos = casos;
	}

	public FiltroCaso getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroCaso filtro) {
		this.filtro = filtro;
	}

	public LazyDataModel<Caso> getModel2() {
		return model2;
	}

	public void setModel2(LazyDataModel<Caso> model2) {
		this.model2 = model2;
	}



}
