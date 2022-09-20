package com.kangs.lotus.services.serviceImpl.serviceImpl;

import com.kangs.lotus.Repository.UserRepository;
import com.kangs.lotus.model.User;
import com.kangs.lotus.services.serviceImpl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String userSave(User user) {

        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());

        if (optionalUser.isEmpty()) {
            userRepository.save(user);
            return "User Saved Successfully";
        }else{
            return "User already exist";
        }



    }

    @Override
    public User signIn(String email, String password) throws Exception {

        log.info("Working"+email+" "+password);
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            if(optionalUser.get().getPassword().equals(password)){
                return optionalUser.get();
            }else{
                throw new Exception("Wrong");
            }
        }
        throw new Exception("ithu Wrong");
    }

    @Override
    public List<User> getAllCustomer() {
        List<User> users = userRepository.findAll();

        List<User> exUser = null;
        for (User user : users) {
            if(user.getCustomerType() == "customer"){
                exUser.add(user);
            }else{
                System.out.println("skip");
            }
        }
        return null;
    }
}
