package flightbooking.microservices.accountmanagerservice._data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice._application.PasswordService;
import flightbooking.microservices.accountmanagerservice._data.dao.ProfileRepository;
import flightbooking.microservices.accountmanagerservice._data.dao.User;
import flightbooking.microservices.accountmanagerservice._data.dao.UserRepository;
import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProfileRepository profileRepository;

    @Override
    public boolean isExisting(String userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public User register(String userId) {
        RandomString rand = new RandomString(16);
        User user = new User(userId, PasswordService.encryptPassword(rand.nextString()));
        update(user);
        return user;
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean authenticate(User user) {
        try {

            User userInDb = new User("hello", "");
            User compareUser = new User(
                    userInDb.getUserId(),
                    userInDb.getPassword());

            if (user.equals(compareUser)) {
                return true;
            } else
                return false;

        } catch (Exception e) {
            return false;
        }
    }

}
