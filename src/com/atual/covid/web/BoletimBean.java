package com.atual.covid.web;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.atual.covid.boletim.Boletim;
import com.atual.covid.boletim.BoletimDAO;
import com.atual.covid.boletim.BoletimRN;
import com.atual.covid.usuario.Usuario;
import com.atual.covid.usuario.UsuarioRN;

@ManagedBean(name = "boletimBean")
@RequestScoped
public class BoletimBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{boletim}")
	private Boletim boletim = new Boletim();
	private List<Boletim> lista;
	private List<Boletim> buscar;
	
	public List<Boletim> getBuscar() {
		return buscar;
	}
	public void setBuscar(List<Boletim> buscar) {
		this.buscar = buscar;
	}
	
	public Boletim getBoletim() {
		return boletim;
	}
	public void setBoletim(Boletim boletim) {
		this.boletim = boletim;
	}
	public List<Boletim> getLista() {
		if (this.lista == null) {
			BoletimRN boletimRN = new BoletimRN();
			this.lista = boletimRN.listar();
		}
		return this.lista;
	}
	public void setLista(List<Boletim> lista) {
		this.lista = lista;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Boletim> buscarEstado(String est){
        List<Boletim> e = new BoletimRN().listar();
        List<Boletim> listaPorEstado;
        listaPorEstado = new ArrayList<Boletim>();
        for(Boletim g:e)
        {
            if(est.equals(g.getEstados()))
                listaPorEstado.add(g);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(e.toString());
        context.addMessage(null, facesMessage);
        return listaPorEstado;
}
}
