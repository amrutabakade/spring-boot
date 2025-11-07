package com.web.web.rest;

public class StudentErrorResponse {

	private int status;
	
	private String msg;
	
	private long ts;

	public StudentErrorResponse() {
		
	}

	public StudentErrorResponse(int status, String msg, long ts) {
		this.status = status;
		this.msg = msg;
		this.ts = ts;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the ts
	 */
	public long getTs() {
		return ts;
	}

	/**
	 * @param ts the ts to set
	 */
	public void setTs(long ts) {
		this.ts = ts;
	}
	
	
}
