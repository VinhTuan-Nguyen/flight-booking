package flightbooking.microservices.accountmanagerservice._data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice._application.PasswordService;
import flightbooking.microservices.accountmanagerservice._application.dto.internalLoginForm;
import flightbooking.microservices.accountmanagerservice._data.dao.User;
import flightbooking.microservices.accountmanagerservice._data.service.repository.UserRepository;
import net.bytebuddy.utility.RandomString;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean isExisting(String userId) {
        return userRepository.existsById(userId);
    }

    public User register(String userId) {
        RandomString rand = new RandomString(16);
        String password = rand.nextString();
        String salt = rand.nextString();
        User user = new User(userId, PasswordService.encryptPassword(password, salt), salt);
        update(user);
        user.setPassword(password);
        return user;
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public boolean authenticate(internalLoginForm loginUser) {
        try {
            User compareUser = userRepository.findById(loginUser.getUserId()).get();
            String encrypt = PasswordService.encryptPassword(
                    loginUser.getPassword(),
                    compareUser.getSalt());

            return encrypt.equals(compareUser.getPassword());
        } catch (Exception e) {
            return false;
        }
    }

    public User findByUserId(String userId) {
        return userRepository.findById(userId).get();
    }
}
