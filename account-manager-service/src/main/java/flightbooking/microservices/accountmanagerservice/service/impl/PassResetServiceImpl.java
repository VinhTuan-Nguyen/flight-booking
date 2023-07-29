package flightbooking.microservices.accountmanagerservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice.model.PassReset;
import flightbooking.microservices.accountmanagerservice.repository.PassResetRepository;
import flightbooking.microservices.accountmanagerservice.service.PassResetService;


@Service
public class PassResetServiceImpl implements PassResetService {
    @Autowired
    PassResetRepository passResetRepository;

    @Override
    public void createLog(PassReset log) {
        passResetRepository.save(log);
    }

}
