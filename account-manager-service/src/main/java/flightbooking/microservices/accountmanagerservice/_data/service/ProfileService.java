package flightbooking.microservices.accountmanagerservice._data.service;

import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice._data.dao.Profile;

@Service
public interface ProfileService {

    public boolean isExisting(String email);

    public Profile register(Profile profile);
}
