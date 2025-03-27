package ifrs.edu.com.exercise_3.database.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String address;
	private String city;
	private String cep;
	private String uf;

	public Address(String address, String city, String cep, String uf) {
		this.address = address;
		this.city = city;
		this.cep = cep;
		this.uf = uf;
	}

	public Address() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Address adress = (Address) o;
		return id == adress.id && Objects.equals(city, adress.city) && Objects.equals(cep, adress.cep)
				&& Objects.equals(uf, adress.uf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, city, cep, uf);
	}

	@Override
	public String toString() {
		return "Adress{" +
				"id=" + id +
				", adress='" + address + '\'' +
				", city='" + city + '\'' +
				", cep='" + cep + '\'' +
				", uf='" + uf + '\'' +
				'}';
	}
}
