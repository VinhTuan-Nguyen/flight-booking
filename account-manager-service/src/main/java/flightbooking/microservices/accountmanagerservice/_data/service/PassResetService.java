package flightbooking.microservices.accountmanagerservice._data.service;

import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice._data.dao.PassReset;

@Service
public interface PassResetService {

    public void createLog(PassReset log);
}
