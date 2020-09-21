package com.karthi.school.controller;

public class Result {
	private Boolean status;
	private StringBuilder msg = new StringBuilder();

	public boolean getStatus() {
		return status;
	}

	public String getMsg() {
		return msg.toString();
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void addMsg(String msg) {
		this.msg.append(msg);
		this.msg.append("\n");
	}

	public void merge(Result result){
		this.setStatus(this.getStatus()&&result.getStatus());
		this.addMsg(result.getMsg());
	}

}
