package com.lazcano.alokairu.core.model;

public class EmailConfig{
	private String sender;
	private String server;
	private String passwd;

	public String getSender(){
		return this.sender;
	}

	public void setSender(String sender){
		this.sender=sender;
	}

	public String getServer(){
		return this.server;
	}

	public void setServer(String server){
		this.server=server;
	}

	public String getPasswd(){
		return this.passwd;
	}

	public void setPasswd(String passwd){
		this.passwd=passwd;
	}
}
