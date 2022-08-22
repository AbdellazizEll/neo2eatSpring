package com.jwtproject.userSecurity.Service;

import com.jwtproject.userSecurity.Entity.Role;

public interface RoleService {
    Role saveRole(Role role);
    Role findByName(String name);
}
