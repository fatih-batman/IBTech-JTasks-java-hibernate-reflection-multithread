package entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Account {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name="accountId") 
	private long accountId;
	
	@Column(name="accountName") 
	private String accountName;
	
	@Column(name="balance") 
	private long balance;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="customer_ıd")
	private Customer customer;

	public Account(String accountName, long balance) {
		this.accountName = accountName;
		this.balance = balance;
	}
	public Account() {
	
		
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
	

}
