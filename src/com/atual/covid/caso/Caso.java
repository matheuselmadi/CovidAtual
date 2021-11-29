package com.atual.covid.caso;


import java.io.Serializable;
import java.util.Objects;

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

/**
 * @author joaov
 *
 */
@Entity
@Table(name = "caso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caso.findAll", query = "SELECT c FROM Caso c")
    , @NamedQuery(name = "Caso.findById", query = "SELECT c FROM Caso c WHERE c.id = :id")
    , @NamedQuery(name = "Caso.findByCity", query = "SELECT c FROM Caso c WHERE c.city = :city")
    , @NamedQuery(name = "Caso.findByCityIbgeCode", query = "SELECT c FROM Caso c WHERE c.cityIbgeCode = :cityIbgeCode")
    , @NamedQuery(name = "Caso.findByConfirmed", query = "SELECT c FROM Caso c WHERE c.confirmed = :confirmed")
    , @NamedQuery(name = "Caso.findByConfirmedPer100kInhabitants", query = "SELECT c FROM Caso c WHERE c.confirmedPer100kInhabitants = :confirmedPer100kInhabitants")
    , @NamedQuery(name = "Caso.findByData", query = "SELECT c FROM Caso c WHERE c.data = :data")
    , @NamedQuery(name = "Caso.findByDeathRate", query = "SELECT c FROM Caso c WHERE c.deathRate = :deathRate")
    , @NamedQuery(name = "Caso.findByDeaths", query = "SELECT c FROM Caso c WHERE c.deaths = :deaths")
    , @NamedQuery(name = "Caso.findByEstimatedPopulation", query = "SELECT c FROM Caso c WHERE c.estimatedPopulation = :estimatedPopulation")
    , @NamedQuery(name = "Caso.findByEstimatedPopulation2019", query = "SELECT c FROM Caso c WHERE c.estimatedPopulation2019 = :estimatedPopulation2019")
    , @NamedQuery(name = "Caso.findByIsLast", query = "SELECT c FROM Caso c WHERE c.isLast = :isLast")
    , @NamedQuery(name = "Caso.findByOrderForPlace", query = "SELECT c FROM Caso c WHERE c.orderForPlace = :orderForPlace")
    , @NamedQuery(name = "Caso.findByPlaceType", query = "SELECT c FROM Caso c WHERE c.placeType = :placeType")
    , @NamedQuery(name = "Caso.findByState", query = "SELECT c FROM Caso c WHERE c.state = :state")})
public class Caso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "city")
    private String city;
    @Column(name = "city_ibge_code")
    private Integer cityIbgeCode;
    @Column(name = "confirmed")
    private Integer confirmed;
    @Size(max = 255)
    @Column(name = "confirmed_per_100k_inhabitants")
    private String confirmedPer100kInhabitants;
    @Size(max = 255)
    @Column(name = "data")
    private String data;
    @Size(max = 255)
    @Column(name = "death_rate")
    private String deathRate;
    @Column(name = "deaths")
    private Integer deaths;
    @Column(name = "estimated_population")
    private Integer estimatedPopulation;
    @Column(name = "estimated_population_2019")
    private Integer estimatedPopulation2019;
    @Size(max = 255)
    @Column(name = "is_last")
    private String isLast;
    @Column(name = "order_for_place")
    private Integer orderForPlace;
    @Size(max = 255)
    @Column(name = "place_type")
    private String placeType;
    @Size(max = 255)
    @Column(name = "state")
    private String state;
	public Integer getId() {
		return this.id = Objects.requireNonNull(id);
	}
	public void setId(Integer id) {
		this.id = Objects.requireNonNull(id);
	}
	public String getCity() {
		return this.city = Objects.requireNonNull(city);
	}
	public void setCity(String city) {
		this.city = Objects.requireNonNull(city);
	}
	public Integer getCityIbgeCode() {
		return this.cityIbgeCode = Objects.requireNonNull(cityIbgeCode);
	}
	public void setCityIbgeCode(Integer cityIbgeCode) {
		this.cityIbgeCode = Objects.requireNonNull(cityIbgeCode);
	}
	public Integer getConfirmed() {
		return confirmed = Objects.requireNonNull(confirmed);
	}
	public void setConfirmed(Integer confirmed) {
		this.confirmed = Objects.requireNonNull(confirmed);
	}
	public String getConfirmedPer100kInhabitants() {
		return confirmedPer100kInhabitants = Objects.requireNonNull(confirmedPer100kInhabitants);
	}
	public void setConfirmedPer100kInhabitants(String confirmedPer100kInhabitants) {
		this.confirmedPer100kInhabitants = Objects.requireNonNull(this.confirmedPer100kInhabitants);
	}
	public String getData() {
		return data = Objects.requireNonNull(data);
	}
	public void setData(String data) {
		this.data = Objects.requireNonNull(data);
	}
	public String getDeathRate() {
		return deathRate = Objects.requireNonNull(deathRate);
	}
	public void setDeathRate(String deathRate) {
		this.deathRate = Objects.requireNonNull(deathRate);
	}
	public Integer getDeaths() {
		return deaths = Objects.requireNonNull(deaths);
	}
	public void setDeaths(Integer deaths) {
		this.deaths = Objects.requireNonNull(deaths);
	}
	public Integer getEstimatedPopulation() {
		return estimatedPopulation = Objects.requireNonNull(estimatedPopulation);
	}
	public void setEstimatedPopulation(Integer estimatedPopulation) {
		this.estimatedPopulation = Objects.requireNonNull(estimatedPopulation);
	}
	public Integer getEstimatedPopulation2019() {
		return estimatedPopulation2019 = Objects.requireNonNull(estimatedPopulation2019);
	}
	public void setEstimatedPopulation2019(Integer estimatedPopulation2019) {
		this.estimatedPopulation2019 = Objects.requireNonNull(getEstimatedPopulation2019());
	}
	public String getIsLast() {
		return isLast = Objects.requireNonNull(isLast);
	}
	public void setIsLast(String isLast) {
		this.isLast = Objects.requireNonNull(isLast);
	}
	public Integer getOrderForPlace() {
		return orderForPlace = Objects.requireNonNull(orderForPlace);
	}
	public void setOrderForPlace(Integer orderForPlace) {
		this.orderForPlace = Objects.requireNonNull(orderForPlace);
	}
	public String getPlaceType() {
		return placeType = Objects.requireNonNull(placeType);
	}
	public void setPlaceType(String placeType) {
		this.placeType = Objects.requireNonNull(placeType);
	}
	public String getState() {
		return state = Objects.requireNonNull(state);
	}
	public void setState(String state) {
		this.state = Objects.requireNonNull(state);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((cityIbgeCode == null) ? 0 : cityIbgeCode.hashCode());
		result = prime * result + ((confirmed == null) ? 0 : confirmed.hashCode());
		result = prime * result + ((confirmedPer100kInhabitants == null) ? 0 : confirmedPer100kInhabitants.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((deathRate == null) ? 0 : deathRate.hashCode());
		result = prime * result + ((deaths == null) ? 0 : deaths.hashCode());
		result = prime * result + ((estimatedPopulation == null) ? 0 : estimatedPopulation.hashCode());
		result = prime * result + ((estimatedPopulation2019 == null) ? 0 : estimatedPopulation2019.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isLast == null) ? 0 : isLast.hashCode());
		result = prime * result + ((orderForPlace == null) ? 0 : orderForPlace.hashCode());
		result = prime * result + ((placeType == null) ? 0 : placeType.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caso other = (Caso) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (cityIbgeCode == null) {
			if (other.cityIbgeCode != null)
				return false;
		} else if (!cityIbgeCode.equals(other.cityIbgeCode))
			return false;
		if (confirmed == null) {
			if (other.confirmed != null)
				return false;
		} else if (!confirmed.equals(other.confirmed))
			return false;
		if (confirmedPer100kInhabitants == null) {
			if (other.confirmedPer100kInhabitants != null)
				return false;
		} else if (!confirmedPer100kInhabitants.equals(other.confirmedPer100kInhabitants))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (deathRate == null) {
			if (other.deathRate != null)
				return false;
		} else if (!deathRate.equals(other.deathRate))
			return false;
		if (deaths == null) {
			if (other.deaths != null)
				return false;
		} else if (!deaths.equals(other.deaths))
			return false;
		if (estimatedPopulation == null) {
			if (other.estimatedPopulation != null)
				return false;
		} else if (!estimatedPopulation.equals(other.estimatedPopulation))
			return false;
		if (estimatedPopulation2019 == null) {
			if (other.estimatedPopulation2019 != null)
				return false;
		} else if (!estimatedPopulation2019.equals(other.estimatedPopulation2019))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isLast == null) {
			if (other.isLast != null)
				return false;
		} else if (!isLast.equals(other.isLast))
			return false;
		if (orderForPlace == null) {
			if (other.orderForPlace != null)
				return false;
		} else if (!orderForPlace.equals(other.orderForPlace))
			return false;
		if (placeType == null) {
			if (other.placeType != null)
				return false;
		} else if (!placeType.equals(other.placeType))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Caso [id=" + id + ", city=" + city + ", cityIbgeCode=" + cityIbgeCode + ", confirmed=" + confirmed
				+ ", confirmedPer100kInhabitants=" + confirmedPer100kInhabitants + ", data=" + data + ", deathRate="
				+ deathRate + ", deaths=" + deaths + ", estimatedPopulation=" + estimatedPopulation
				+ ", estimatedPopulation2019=" + estimatedPopulation2019 + ", isLast=" + isLast + ", orderForPlace="
				+ orderForPlace + ", placeType=" + placeType + ", state=" + state + "]";
	}

  
    
}