package com.example.Carrent1st.services;



import com.example.Carrent1st.model.User;
import com.example.Carrent1st.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }
}
