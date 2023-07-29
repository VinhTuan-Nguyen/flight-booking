package flightbooking.microservices.accountmanagerservice.service;

import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice.model.Profile;

@Service
public interface ProfileService {

    public Profile register(Profile profile);
}
