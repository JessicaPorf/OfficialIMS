package com.qa.ims.persistence.domain;

public class Orders {
	

		private Long id;
		private String customer_id ;

	

		public Orders( String customer_id ) {
			this.customer_id  = customer_id ;
		}

		public Orders(Long id,  String customer_id ) {
			this.id = id;
	
			this.customer_id  = customer_id ;
	
		}
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

	
		


		public String getcustomer_id () {
			return customer_id ;
		}

		public void setcustomer_id (String customer_id ) {
			this.customer_id  = customer_id ;
		}
	



		public String toString() {
			return "id:" + id + " customer_id :" + customer_id ;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((customer_id  == null) ? 0 : customer_id .hashCode());
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
			Orders other = (Orders) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (customer_id  == null) {
				if (other.customer_id  != null)
					return false;
			} else if (!customer_id .equals(other.customer_id ))
				return false;
			return true;
		}

		
	

	

}
