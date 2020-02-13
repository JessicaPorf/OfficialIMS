package com.qa.ims.persistence.domain;

public class Item {


			private Long id;
			private String item_Name ;
			private String item_Value;

			public Item(String item_Name, String item_Value) {
				this.item_Name = item_Name;
				this.item_Value = item_Value;
			}

			public Item(Long id, String item_Name, String item_Value) {
				this.id = id;
				this.item_Name = item_Name;
				this.item_Value = item_Value;
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getitem_Name() {
				return item_Name;
			}

			public void setitem_Name(String item_Name) {
				this.item_Name = item_Name;
			}

			public String getitem_Value() {
				return item_Value;
			}

			public void setitem_Value(String item_Value) {
				this.item_Value = item_Value;
			}

			public String toString() {
				return "id:" + id + " item_Name:" + item_Name + " item_Value:" + item_Value;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((item_Name == null) ? 0 : item_Name.hashCode());
				result = prime * result + ((id == null) ? 0 : id.hashCode());
				result = prime * result + ((item_Value == null) ? 0 : item_Value.hashCode());
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
				Item other = (Item) obj;
				if (item_Name == null) {
					if (other.item_Name != null)
						return false;
				} else if (!item_Name.equals(other.item_Name))
					return false;
				if (id == null) {
					if (other.id != null)
						return false;
				} else if (!id.equals(other.id))
					return false;
				if (item_Value == null) {
					if (other.item_Value != null)
						return false;
				} else if (!item_Value.equals(other.item_Value))
					return false;
				return true;
			

			

			
		
				
			}

			public static int size() {
				// TODO Auto-generated method stub
				return 0;
			}

	}


