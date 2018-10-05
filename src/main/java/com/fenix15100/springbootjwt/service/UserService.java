package com.fenix15100.springbootjwt.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.fenix15100.springbootjwt.repository.UserRepository;
import com.fenix15100.springbootjwt.model.User;
import org.bson.types.ObjectId;


@Service
public class UserService {

    private UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User getUser(ObjectId userId) {
        return userRepository.findOne(userId);
    }

    public String saveUser(User user) {
        User savedUser = userRepository.save(user);
        return tokenService.createToken(savedUser.getId());
    }
}
