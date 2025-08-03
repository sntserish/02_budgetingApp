package es.projects.budgetingApp.controller;

import es.projects.budgetingApp.dto.UserDTO;
import es.projects.budgetingApp.dto.mapper.UserMapper;
import es.projects.budgetingApp.model.User;
import es.projects.budgetingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "es02/budgetingApp/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/")
    public List<UserDTO> getUsers(){
        return userService.getUsers().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping(path = "/")
    public String createUser(@RequestBody User user){
        return userService.createUser(user).toString();
    }
}