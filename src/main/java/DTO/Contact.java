package DTO;

public class Contact {
	
	private String name;
	private String lastname;
	private String phonenumber;
	
	public Contact () {}
	
	public Contact(String name, String lastname, String phonenumber) {
		this.name = name;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
	

}
