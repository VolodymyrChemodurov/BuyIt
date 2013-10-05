package com.epam.lab.buyit.controller.setters;

import com.epam.lab.buyit.model.User;

public enum UserSetter {
	
	FIRST_NAME("firstName") {
		public void setField(User user, String value) {
			user.setFirstName(value);
		}
	},
	LAST_NAME("lastName") {
		public void setField(User user, String value) {
			user.setLastName(value);
		}
	},
	LOGIN("login") {
		public void setField(User user, String value) {
			user.setLogin(value);
		}
	},
	PASSWORD("password") {
		public void setField(User user, String value) {
			user.setPassword(value);
		}
	},
	EMAIL("email") {
		public void setField(User user, String value) {
			user.getContact().setEmail(value);
		}
	},
	PHONE("phone") {
		public void setField(User user, String value) {
			user.getContact().setPhone(value);
		}
	},
	REGION("region") {
		public void setField(User user, String value) {
			user.getContact().getAddress().setRegion(value);
		}
	},
	CITY("city") {
		public void setField(User user, String value) {
			user.getContact().getAddress().setCity(value);
		}
	},
	STREET("street") {
		public void setField(User user, String value) {
			user.getContact().getAddress().setStreet(value);
		}
	},
	HOUSE("house") {
		public void setField(User user, String value) {
			user.getContact().getAddress().setHouse(value);
		}
	},
	ZIP_CODE("zipCode") {
		public void setField(User user, String value) {
			user.getContact().getAddress().setZipCode(value);
		}
	};
	
	private UserSetter(String field) {
		this.field = field;
	}
	
	private String field;
	
	public String getField() {
		return field;
	}
	
	public abstract void setField(User user, String value);
	
}
