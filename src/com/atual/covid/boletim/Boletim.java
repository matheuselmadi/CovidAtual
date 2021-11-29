package com.atual.covid.boletim;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "boletim")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boletim.findAll", query = "SELECT b FROM Boletim b")
    , @NamedQuery(name = "Boletim.findById", query = "SELECT b FROM Boletim b WHERE b.id = :id")
    , @NamedQuery(name = "Boletim.findByData", query = "SELECT b FROM Boletim b WHERE b.data = :data")
    , @NamedQuery(name = "Boletim.findByEstados", query = "SELECT b FROM Boletim b WHERE b.estados = :estados")
    , @NamedQuery(name = "Boletim.findByUrl", query = "SELECT b FROM Boletim b WHERE b.url = :url")})
public class Boletim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "data")
    private String data;
    @Size(max = 255)
    @Column(name = "estados")
    private String estados;
    @Size(max = 255)
    @Column(name = "url")
    private String url;

    public Boletim() {
    }

    public Boletim(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEstados() {
        return estados;
    }

    public void setEstados(String estados) {
        this.estados = estados;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof Boletim)) {
            return false;
        }
        Boletim other = (Boletim) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Boletim[ id=" + id + " ]";
    }
    
}