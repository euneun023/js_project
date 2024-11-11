package service;

import entity.Profile;
import org.springframework.stereotype.Service;
import repository.SignUpRepository;

@Service
public class SignUpService {

    private SignUpRepository signUpRepository; //final 쓰면안되는 이유

    public Profile create (String username, String email, String password){
        Profile profile = new Profile();
        profile.setUsername(username);
        profile.setEmail(email);

//        String EncodePasword = passwordEncoder.encode(profile);
        profile.setPassword(password);

        this.signUpRepository.save(profile);
/*
BCryptPasswordEncoder
passwordEncoder.encode
 */
    }


}
