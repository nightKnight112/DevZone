package com.project.devZone.DevZone.controller;

import com.project.devZone.DevZone.entities.Comments;
import com.project.devZone.DevZone.entities.Follows;
import com.project.devZone.DevZone.entities.User;
import com.project.devZone.DevZone.payload.LoginBody;
import com.project.devZone.DevZone.repos.UserRepository;
import com.project.devZone.DevZone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/all-user-list")
    private List<User> fetchUserList(){
        return userService.fetchAllUser();
    }

    @GetMapping("/all-user-comments/{id}")
    private List<Comments> fetchAllUserComments(@PathVariable("id") Integer id){
        return userService.fetchAllCommentsByUser(id);
    }

    @GetMapping("/all-user-followers/{id}")
    private List<Follows> fetchAllUserFollowers(@PathVariable("id")Integer id){
        return userService.fetchAllFollowersOfUser(id);
    }

    @GetMapping("/get-user-details/{id}")
    private List<User> fetchUserDetails(@PathVariable("id") Integer Id){
        return userService.getUserDetails(Id);
    }

    @PostMapping("/user-login")
    public String loginUser(@Validated @RequestBody LoginBody loginBody){
        return userService.userLogin(loginBody);
    }

    @GetMapping("/user-details-by-username/{username}")
    public List<User> fetchUserDetailsByUserName(@PathVariable("username") String username){
        return userService.getUserDetailsByUserName(username);
    }

    @PostMapping("/save-new-user")
    public String saveNewUser(@Validated @RequestBody User user){
        return userService.saveNewUser(user);
    }

    @PutMapping("/edit-saved-user/{id}/admin")
    public String editSavedUser(@RequestBody User user, @PathVariable("id") Integer id){
        return userService.updateUserById(user, id);
    }

    @DeleteMapping("/remove-user/{id}/admin")
    public String deleteSavedUser(@PathVariable("id") Integer id){
        return userService.deleteUserByUserId(id);
    }




}
