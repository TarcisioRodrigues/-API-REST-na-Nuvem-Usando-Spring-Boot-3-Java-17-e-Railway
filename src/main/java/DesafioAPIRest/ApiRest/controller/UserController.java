package DesafioAPIRest.ApiRest.controller;

import DesafioAPIRest.ApiRest.modules.entity.User;
import DesafioAPIRest.ApiRest.modules.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id){
        var user=userRepository.findById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/")
    public ResponseEntity<Optional<User>> create(@RequestBody User user){
        var userCreated=userRepository.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("${id}").buildAndExpand((userCreated.getId()))
                .toUri();
        return ResponseEntity.ok(Optional.of(userCreated));
    }


}
