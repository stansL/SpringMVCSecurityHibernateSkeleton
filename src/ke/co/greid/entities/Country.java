package ke.co.greid.entities;

// Generated Apr 1, 2015 12:52:51 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name = "country", catalog = "hims")
public class Country implements java.io.Serializable {

	private String countryCode;
	private String countryName;
	private Set<Patient> patients = new HashSet<Patient>(0);

	public Country() {
	}

	public Country(String countryCode) {
		this.countryCode = countryCode;
	}

	public Country(String countryCode, String countryName, Set<Patient> patients) {
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.patients = patients;
	}

	@Id
	@Column(name = "country_code", unique = true, nullable = false, length = 2)
	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Column(name = "country_name", length = 45)
	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

}
