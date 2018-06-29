package com.ffm.common.dict;

public enum LoginStatus {
	OFFLINE("offline", "0", "离线"), LOGIN("login", "1", "登录"), LOCKED("locked", "2", "锁定");
	private String dict;
	private String value;
	private String remark;

	private LoginStatus(String dict, String value, String remark) {
		this.dict = dict;
		this.value = value;
		this.remark = remark;
	}

	public String getDict() {
		return dict;
	}

	public void setDict(String dict) {
		this.dict = dict;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}