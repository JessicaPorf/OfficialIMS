package com.qa.ims.persistence.domain;

public class Customer {

	private Long id;
	private String First_Name;
	private String Last_Name;

	public Customer(String First_Name, String Last_Name) {
		this.First_Name = First_Name;
		this.Last_Name = Last_Name;
	}

	public Customer(Long id, String First_Name, String Last_Name) {
		this.id = id;
		this.First_Name = First_Name;
		this.Last_Name = Last_Name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String First_Name) {
		this.First_Name = First_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String Last_Name) {
		this.Last_Name = Last_Name;
	}

	public String toString() {
		return "id:" + id + " first name:" + First_Name + " surname:" + Last_Name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((First_Name == null) ? 0 : First_Name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((Last_Name == null) ? 0 : Last_Name.hashCode());
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
		Customer other = (Customer) obj;
		if (First_Name == null) {
			if (other.First_Name != null)
				return false;
		} else if (!First_Name.equals(other.First_Name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Last_Name == null) {
			if (other.Last_Name != null)
				return false;
		} else if (!Last_Name.equals(other.Last_Name))
			return false;
		return true;
	}

}
