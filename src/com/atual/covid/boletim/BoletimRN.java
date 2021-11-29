package com.atual.covid.boletim;

import java.util.List;

import org.hibernate.Criteria;

import com.atual.covid.util.DAOFactory;

public class BoletimRN {
	
	private BoletimDAO boletimDAO;
	
	public BoletimRN() {
		this.boletimDAO = DAOFactory.criarBoletimDAO();
	}
    
	public List<Boletim> listar() {
        return this.boletimDAO.listar();
    }
	
	public List<Boletim> buscarPorUf(String estados){
		return this.boletimDAO.buscarPorUf(estados);
	}
	public Criteria criteria() {
	return this.boletimDAO.criteria();	
		
	}
}
