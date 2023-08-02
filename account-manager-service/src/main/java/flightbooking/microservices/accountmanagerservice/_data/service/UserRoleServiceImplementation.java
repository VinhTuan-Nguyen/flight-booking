package flightbooking.microservices.accountmanagerservice._data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice._data.dao.UserRoleRepository;

@Service
public class UserRoleServiceImplementation implements UserRoleService{
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public boolean checkRole(Long userId) {
        return false;
    }

}
