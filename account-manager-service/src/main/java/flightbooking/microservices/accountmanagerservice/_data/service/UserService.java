package flightbooking.microservices.accountmanagerservice._data.service;

import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice._data.dao.User;

@Service
public interface UserService {

    public boolean isExisting(String userId);

    public User register(String userId);

    public void update(User user);

    public boolean authenticate(User user);
}
