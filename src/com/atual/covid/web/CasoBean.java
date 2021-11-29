package com.atual.covid.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.atual.covid.boletim.Boletim;
import com.atual.covid.boletim.BoletimRN;
import com.atual.covid.caso.Caso;
import com.atual.covid.caso.CasoRN;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@ManagedBean(name = "casoBean")
@RequestScoped
public class CasoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{caso}")
	private Caso caso = new Caso();
	private List<Caso> lista;
	public Caso getCaso() {
		return caso;
	}
	public void setCaso(Caso caso) {
		this.caso = caso;
	}
	public List<Caso> getLista() {
		if (this.lista == null) {
			CasoRN casoRN = new CasoRN();
			this.lista = casoRN.listar();
		
		}
		
		return this.lista;
	
	}
	public void setLista(List<Caso> lista) {
		this.lista = lista;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
