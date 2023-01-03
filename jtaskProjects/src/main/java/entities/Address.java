package entities;
import javax.persistence.*;

@Entity
public class Address {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name="AddressId") 
	private long AddressId;
	
	@Column(name="Country") 
	private String Country;
	
	@Column(name="City") 
	private String City;
	
	@Column(name="Street") 
	private String Street;
	
	@Column(name="AddressCode") 
	private String AddressCode;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="customer_ıd")
	private Customer customer;

	public Address(long addressId, String country, String city, String street, String addressCode) {
		AddressId = addressId;
		Country = country;
		City = city;
		Street = street;
		AddressCode = addressCode;
	}
	public Address( String country, String city, String street, String adressCode) {
		Country = country;
		City = city;
		Street = street;
		AddressCode = adressCode;
	}
	public Address( ) {

	}
	public long getAddressId() {
		return AddressId;
	}
	public void setAddressId(long addressId) {
		AddressId = addressId;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getAdressCode() {
		return AddressCode;
	}
	public void setAdressCode(String adressCode) {
		AddressCode = adressCode;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	

	
	
	
	
	
	

}
