package com.atual.covid.caso;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Criteria;

import com.atual.covid.util.DAOFactory;

public class CasoRN {
	
	private CasoDAO casoDAO;
	
public CasoRN() {
	this.casoDAO = DAOFactory.criarCasoDAO();
}
public List<Caso> listar() {
    return this.casoDAO.listar();
}
public Criteria criteria() {
return this.casoDAO.criteria();		
}
public List<Caso> listando(String pesquisa){
	return this.casoDAO.listando(pesquisa);
}
}
