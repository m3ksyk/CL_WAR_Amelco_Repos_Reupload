package pl.coderslab.sampleboot.service;

import pl.coderslab.sampleboot.entity.Role;

public interface RoleService {
    Role getOrCreate(String rolename);
}
