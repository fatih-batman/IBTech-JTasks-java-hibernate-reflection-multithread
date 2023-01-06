package entities;
import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="customerId")
	private int customerId;
	
	@Column(name="customerName")
	private String customerName;

	@Column(name="customerSurname")
	private String customerSurname;

	public Customer(int customerId, String customerName, String customerSurname) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
	}
	
	public Customer( String customerName, String customerSurname) {
		super();
		this.customerName = customerName;
		this.customerSurname = customerSurname;
	}
	

	public Customer() {
		super();
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerSurname="
				+ customerSurname + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}


//	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
//	private List<Address> address;
//
//	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
//	private List<Phone> phone;
//
//	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
//	private List<Account> account;
//	
	
	

}
