package flightbooking.microservices.accountmanagerservice._data.service;

import org.springframework.stereotype.Service;

@Service
public interface UserRoleService {

    public boolean checkRole(Long userId);
}
