package com.atual.covid.caso;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Criteria;

public interface CasoDAO {
	  public List<Caso> listar();
	  
	  public Criteria criteria();
	  
	  public List<Caso> listando(String pesquisa);
}
