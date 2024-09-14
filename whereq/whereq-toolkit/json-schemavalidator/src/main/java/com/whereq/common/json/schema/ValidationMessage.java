
package com.whereq.common.json.schema;
import java.text.MessageFormat;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ValidationMessage {
	private String type;
	private String code;
	private String path;
	private String[] arguments;
	private String message;

	ValidationMessage() {
	}

	public String getCode() {
		return code;
	}

	void setCode(String code) {
		this.code = code;
	}

	public String getPath() {
		return path;
	}

	void setPath(String path) {
		this.path = path;
	}

	public void setArguments(String[] arguments) {
		this.arguments = arguments;
	}

	String[] getArguments() {
		return arguments;
	}

	public String getMessage() {
		return message;
	}

	void setMessage(String message) {
		this.message = message;
	}

	public static class Builder {
		private String type;
		private String code;
		private String path;
		private String[] arguments;
		private MessageFormat format;

		public Builder type(String type) {
			this.type = type;
			return this;
		}

		public Builder code(String code) {
			this.code = code;
			return this;
		}

		public Builder path(String path) {
			this.path = path;
			return this;
		}

		public Builder arguments(String... arguments) {
			this.arguments = arguments;
			return this;
		}

		public Builder format(MessageFormat format) {
			this.format = format;
			return this;
		}

		public ValidationMessage build() {
			ValidationMessage msg = new ValidationMessage();
			msg.setType(type);
			msg.setCode(code);
			msg.setPath(path);
			msg.setArguments(arguments);

			if (format != null) {
				String[] objs = new String[(arguments == null ? 0 : arguments.length) + 1];
				objs[0] = path;
				if (arguments != null) {
					for (int i = 1; i < objs.length; i++) {
						objs[i] = arguments[i - 1];
					}
				}
				msg.setMessage(format.format(objs));
			}

			return msg;
		}
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		ValidationMessage rhs = (ValidationMessage) obj;
		return new EqualsBuilder().append(path, rhs.path).append(type, rhs.type)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(path).append(type).toHashCode();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
