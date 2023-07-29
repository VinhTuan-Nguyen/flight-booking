package flightbooking.microservices.accountmanagerservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice.model.User;
import flightbooking.microservices.accountmanagerservice.repository.UserRepository;
import flightbooking.microservices.accountmanagerservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isExisting(Long userId) {
        return userRepository.existsById(userId) ? true : false;
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }
}
