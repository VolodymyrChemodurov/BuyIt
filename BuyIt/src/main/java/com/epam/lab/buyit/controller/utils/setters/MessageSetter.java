package com.epam.lab.buyit.controller.utils.setters;

import com.epam.lab.buyit.model.Message;

public enum MessageSetter {

	MESSAGE("message") {
		public void setField(Message message, String value) {
			message.setMessage(value);
		}
	},
	FROM_USER_ID("from_user_id") {
		public void setField(Message message, String value) {
			message.setFromUserId(Integer.parseInt(value));
		}
	},
	TO_USER_ID("to_user_id") {
		public void setField(Message message, String value) {
			message.setToUserId(Integer.parseInt(value));
		}
	};

	private MessageSetter(String field) {
		this.field = field;
	}

	private String field;

	public String getField() {
		return field;
	}

	public abstract void setField(Message message, String value);

	public static MessageSetter getSetter(String value) {
		MessageSetter result = null;
		for (MessageSetter setter : values()) {
			if (setter.getField().equals(value)) {
				result = setter;
			}
		}
		return result;
	}

}
