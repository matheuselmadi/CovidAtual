package com.atual.covid.mapa;

import com.atual.covid.util.DAOFactory;

public class MapaRN {

	private MapaDAO mapaDAO;
	
	public MapaRN() {
		this.mapaDAO = DAOFactory.criarMapaDAO();
	}
	
	public Mapa buscarPorUf(String state) {
		return this.mapaDAO.buscarPorUf(state);
	}
}
