package flightbooking.microservices.accountmanagerservice._data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice._data.service.repository.UserRoleRepository;

@Service
public class UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    public boolean checkRole(Long userId) {
        return false;
    }
}
