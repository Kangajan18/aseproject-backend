package com.kangs.lotus.services.serviceImpl;

import com.kangs.lotus.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String userSave(User user);

    User signIn(String email, String password) throws Exception;

    List<User> getAllCustomer();
}
