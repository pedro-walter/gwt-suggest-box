package com.gwt.suggest.client;

public class Login {
	
	int id;
	String name;
	String password;
	boolean isLogged=true;
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
//	public boolean isLogged(String name, String pass){
//		if(name.equals(this.name) && pass.equals(this.password)){
//			return true;
//		}else{
//			return false;
//		}		
//		
//	}
}
