package flightbooking.microservices.accountmanagerservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice.model.Profile;
import flightbooking.microservices.accountmanagerservice.repository.ProfileRepository;
import flightbooking.microservices.accountmanagerservice.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public Profile register(Profile profile) {
        return profileRepository.save(profile);
    }
}
