package com.atual.covid.mapa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joaov
 */
@Entity
@Table(name = "mapa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mapa.findAll", query = "SELECT m FROM Mapa m")
    , @NamedQuery(name = "Mapa.findById", query = "SELECT m FROM Mapa m WHERE m.id = :id")
    , @NamedQuery(name = "Mapa.findByState", query = "SELECT m FROM Mapa m WHERE m.state = :state")
    , @NamedQuery(name = "Mapa.findByDeaths", query = "SELECT m FROM Mapa m WHERE m.deaths = :deaths")})
public class Mapa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deaths")
    private int deaths;

    public Mapa() {
    }

    public Mapa(Integer id) {
        this.id = id;
    }

    public Mapa(Integer id, int deaths) {
        this.id = id;
        this.deaths = deaths;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mapa)) {
            return false;
        }
        Mapa other = (Mapa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atual.covid.mapa.Mapa[ id=" + id + " ]";
    }
    
}

