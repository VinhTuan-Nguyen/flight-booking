package flightbooking.microservices.accountmanagerservice._data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice._data.dao.Profile;
import flightbooking.microservices.accountmanagerservice._data.service.repository.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public boolean existsByEmail(String email) {
        return profileRepository.existsByEmail(email);
    }

    public Profile register(Profile profile) {
        return profileRepository.save(profile);
    }

    public boolean isExisting(String string) {
        return false;
    }
}
