package DesafioAPIRest.ApiRest.modules.service;

import DesafioAPIRest.ApiRest.modules.entity.User;
import DesafioAPIRest.ApiRest.modules.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
   private UserRepository userRepository;

    public Optional<User> findById(Long id){
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public User create(User user){
        if( user.getId()!=null &&userRepository.existsByAccountNumber(user.getAccount().getNumber())){
            throw  new IllegalArgumentException("This user id already exists");
        }
        return userRepository.save(user);
    }
;}

