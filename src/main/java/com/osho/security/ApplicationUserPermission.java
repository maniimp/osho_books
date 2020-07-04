package com.osho.security;

public enum ApplicationUserPermission {
	ADMIN_READ("student:read"),
	CUSTOMER_READ("customer:read");
	
	private final String permission;
	
	ApplicationUserPermission(String permission){
		this.permission = permission;
	}
	
	public String getPermission() {
		return permission;
	}
	
}
