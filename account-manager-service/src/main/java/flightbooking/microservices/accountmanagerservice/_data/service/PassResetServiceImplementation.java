package flightbooking.microservices.accountmanagerservice._data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice._data.dao.PassReset;
import flightbooking.microservices.accountmanagerservice._data.dao.PassResetRepository;


@Service
public class PassResetServiceImplementation implements PassResetService {
    @Autowired
    PassResetRepository passResetRepository;

    @Override
    public void createLog(PassReset log) {
        passResetRepository.save(log);
    }

}
