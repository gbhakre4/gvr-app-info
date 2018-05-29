package com.gilbarco.model;

import java.io.Serializable;

public class JsonResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String timestamp;
	int calls;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getCalls() {
		return calls;
	}

	public void setCalls(int calls) {
		this.calls = calls;
	}
}

