package com.osho.security;

import java.util.Set;

import com.google.common.collect.Sets;

import static com.osho.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
	
	ADMIN(Sets.newHashSet(ADMIN_READ)),
	CUSTOMER(Sets.newHashSet(CUSTOMER_READ));
	
	private final Set<ApplicationUserPermission> permissions;
	
	ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}
	
	public Set<ApplicationUserPermission> getPermissions(){
		return permissions;	
	}

}
