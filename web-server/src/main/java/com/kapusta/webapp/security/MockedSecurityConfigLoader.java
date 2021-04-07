package com.kapusta.webapp.security;

import com.kapusta.webapp.security.entity.Privilege;
import com.kapusta.webapp.security.entity.Role;
import com.kapusta.webapp.security.entity.User;
import com.kapusta.webapp.security.entity.UserPrivateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
class MockedSecurityConfigLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepositoryService userRepository;

    @Autowired
    private UserRoleRepository roleRepository;

    @Autowired
    private UserPrivilegeRepository privilegeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;
        Privilege cardSimulationPrivilege
                = createPrivilegeIfNotFound("LOAN_REQUEST");
        Privilege adminTabPrivilege
                = createPrivilegeIfNotFound("ADMIN_TAB");

        List<Privilege> adminPrivileges = Arrays.asList(
                cardSimulationPrivilege, adminTabPrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(cardSimulationPrivilege));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");

        UserPrivateData userPrivateData1 = new UserPrivateData();
        userPrivateData1.setEmail("admin@webapp");
        userPrivateData1.setFirstName("ADMINEK");
        userPrivateData1.setLastName("GOLDENSTEIN");
        User user1 = new User("admin", "admin", userPrivateData1);
        user1.setRoles(Arrays.asList(adminRole));

        Role userRole = roleRepository.findByName("ROLE_USER");

        UserPrivateData userPrivateData2 = new UserPrivateData();
        userPrivateData2.setEmail("test@webapp");
        userPrivateData2.setFirstName("TEST");
        userPrivateData2.setLastName("TESTOWY");
        User user2 = new User("test", "test", userPrivateData2);
        user2.setRoles(Arrays.asList(userRole));

        userRepository.save(user1);
        userRepository.save(user2);

        alreadySetup = true;
    }

    private Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    private Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
