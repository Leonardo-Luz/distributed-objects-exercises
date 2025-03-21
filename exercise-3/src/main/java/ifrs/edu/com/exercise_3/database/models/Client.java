
package ifrs.edu.com.exercise_3.database.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String city;
	private String cep;
	private String uf;

	public Client(String name, String email, String phone, String address, String city, String cep, String uf) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.cep = cep;
		this.uf = uf;
	}

	public Client(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Client client = (Client) o;

		if (id != client.id) return false;
		if (name != null ? !name.equals(client.name) : client.name != null) return false;
		if (email != null ? !email.equals(client.email) : client.email != null) return false;
		if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;
		if (address != null ? !address.equals(client.address) : client.address != null) return false;
		if (city != null ? !city.equals(client.city) : client.city != null) return false;
		if (cep != null ? !cep.equals(client.cep) : client.cep != null) return false;
		return uf != null ? uf.equals(client.uf) : client.uf == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (city != null ? city.hashCode() : 0);
		result = 31 * result + (cep != null ? cep.hashCode() : 0);
		result = 31 * result + (uf != null ? uf.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Client{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", address='" + address + '\'' +
				", city='" + city + '\'' +
				", cep='" + cep + '\'' +
				", uf='" + uf + '\'' +
				'}';
	}
}
