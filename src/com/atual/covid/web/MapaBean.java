package com.atual.covid.web;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.atual.covid.mapa.Mapa;
import com.atual.covid.mapa.MapaRN;



@ManagedBean(name = "mapaBean")
@SessionScoped
public class MapaBean {
private Mapa mapa;

public int buscarMorte(String state){
    MapaRN maparn = new MapaRN();
    mapa = new Mapa();
    mapa = maparn.buscarPorUf(state);
   	FacesContext context = FacesContext.getCurrentInstance();
    FacesMessage facesMessage = new FacesMessage(Integer.toString(mapa.getDeaths()));
	context.addMessage(null, facesMessage);
    return (int) mapa.getDeaths();

}
    
     public Mapa getMapa() {
	return mapa;
}

public void setMapa(Mapa mapa) {
	this.mapa = mapa;
}

	public String exibeInformacoes(String state){
    Mapa m = new MapaRN().buscarPorUf(state);
	FacesContext context = FacesContext.getCurrentInstance();
    FacesMessage facesMessage = new FacesMessage(m.toString());
	context.addMessage(null, facesMessage);
    return null;
}

}
