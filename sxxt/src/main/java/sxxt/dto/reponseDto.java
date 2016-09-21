package sxxt.dto;

import java.io.Serializable;

public class reponseDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String success;
	private int length;
	private Object object;
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
