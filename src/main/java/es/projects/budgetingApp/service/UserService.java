package es.projects.budgetingApp.service;

import es.projects.budgetingApp.model.User;
import es.projects.budgetingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        if(user != null){
            try{
                user.setActiveStatus(true);
                return userRepository.save(user);
            }catch (Exception e){
                throw new RuntimeException("Error occurred while creating user", e);
            }
        } else{
            throw new IllegalArgumentException("User must not be null");
        }
    }

    public Optional<User> getUserById(Long userId){
        Optional<User> user = Optional.empty();
        if(userRepository.findById(userId).isPresent()){
            user = userRepository.findById((userId));
        }
        return user;
    }

    public List<User> getUsers(){ return userRepository.findAll();}

}
