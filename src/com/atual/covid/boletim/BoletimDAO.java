package com.atual.covid.boletim;

import java.util.List;

import org.hibernate.Criteria;

public interface BoletimDAO {
  public List <Boletim> listar();
  
  public List<Boletim> buscarPorUf(String estados);
  
  public Criteria criteria();
  
}
