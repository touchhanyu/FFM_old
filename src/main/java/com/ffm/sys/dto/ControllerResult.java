package com.ffm.sys.dto;

public class ControllerResult {
	private boolean status;
	private String msg;

	public ControllerResult(boolean status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}