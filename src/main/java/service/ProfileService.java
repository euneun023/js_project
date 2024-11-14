package service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repository.UserRepository;

import java.util.List;

public class ProfileService { //프로필조회


    private UserRepository userRepository;

    public List<User> getAllProfile(){
        return userRepository.findAll();
    }
    public User getProfileById(Long id){
        return userRepository.findById(id).orElse(null);
    }


}
