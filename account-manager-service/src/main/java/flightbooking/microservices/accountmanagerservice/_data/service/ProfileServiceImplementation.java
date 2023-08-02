package flightbooking.microservices.accountmanagerservice._data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice._data.dao.Profile;
import flightbooking.microservices.accountmanagerservice._data.dao.ProfileRepository;

@Service
public class ProfileServiceImplementation implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public boolean isExisting(String email) {
        return profileRepository.existsByEmail(email);
    }

    public Profile register(Profile profile) {
        return profileRepository.save(profile);
    }
}
