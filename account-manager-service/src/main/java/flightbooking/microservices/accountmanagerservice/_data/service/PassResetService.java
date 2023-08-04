package flightbooking.microservices.accountmanagerservice._data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice._data.dao.PassReset;
import flightbooking.microservices.accountmanagerservice._data.service.repository.PassResetRepository;

@Service
public class PassResetService {

    @Autowired
    PassResetRepository passResetRepository;

    public void createLog(PassReset log) {
        passResetRepository.save(log);
    }
}
