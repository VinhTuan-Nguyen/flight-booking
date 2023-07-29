package flightbooking.microservices.accountmanagerservice.service;

import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice.model.PassReset;

@Service
public interface PassResetService {

    public void createLog(PassReset log);
}
