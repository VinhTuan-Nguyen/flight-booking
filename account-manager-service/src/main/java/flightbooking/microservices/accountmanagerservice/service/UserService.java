package flightbooking.microservices.accountmanagerservice.service;

import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice.model.User;

@Service
public interface UserService {

    public boolean isExisting(Long profileId);

    public void update(User user);
}
