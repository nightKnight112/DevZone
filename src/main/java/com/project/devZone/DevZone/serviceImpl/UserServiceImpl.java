package com.project.devZone.DevZone.serviceImpl;

import com.project.devZone.DevZone.entities.Comments;
import com.project.devZone.DevZone.entities.Follows;
import com.project.devZone.DevZone.entities.User;
import com.project.devZone.DevZone.payload.LoginBody;
import com.project.devZone.DevZone.repos.CommentsRepository;
import com.project.devZone.DevZone.repos.FollowsRepository;
import com.project.devZone.DevZone.repos.UserRepository;
import com.project.devZone.DevZone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private FollowsRepository followsRepo;
    @Autowired
    private CommentsRepository commentsRepo;

    //GET Methods
    @Override
    public List<User> fetchAllUser(){
        return userRepo.findAll();
    }

    @Override
    public List<Follows> fetchAllFollowersOfUser(Integer Id) {
        List<User> tempUser = this.userRepo.findUsersByUserId(Id);
        List<Follows> tempList = new ArrayList<>();
        try{
            tempList = tempUser.get(0).getFollows();
            return tempList;
        }catch (Exception e){
            return tempList;
        }
    }

    @Override
    public List<Comments> fetchAllCommentsByUser(Integer Id) {
        List<User> tempUser = this.userRepo.findUsersByUserId(Id);
        List<Comments> tempComments = new ArrayList<>();
        try{
            tempComments = tempUser.get(0).getComments();
            return tempComments;
        }catch (Exception e){
            return tempComments;
        }
    }

    @Override
    public List<User> getUserDetails(Integer id) {
        return this.userRepo.findUsersByUserId(id);
    }



    @Override
    public String userLogin(LoginBody loginBody) {
        List<User> tempUser = new ArrayList<>();
        try{
            tempUser = this.userRepo.findUsersByUserName(loginBody.getUserName());
            if(Objects.equals(tempUser.get(0).getPassword(), loginBody.getPassword())){
                return "logged In successfully";
            }else {
                return "Incorrect password";
            }
        }catch (Exception e) {
            return "Incorrect Username or Password";
        }
    }

    @Override
    public List<User> getUserDetailsByUserName(String userName) {
        return this.userRepo.findUsersByUserName(userName);
    }


    //POST Methods
    @Override
    public String saveNewUser(User user) {
        userRepo.save(user);
        return "User Added Successfully";
    }


    //PUT Methods
    @Override
    public String updateUserById(User user, Integer id) {
        Optional<User> userExists = this.userRepo.findById(id);
        if(userExists.isEmpty()) {
            throw new IllegalArgumentException("User Does not exist");
        }else{
            User tempUser = userExists.get();
            if(Objects.nonNull(user.getUserName())){
                tempUser.setUserName(user.getUserName());
            }
            if(Objects.nonNull(user.getUserId())){
                tempUser.setUserId(user.getUserId());
            }
            if(Objects.nonNull(user.getEmail())){
                tempUser.setEmail(user.getEmail());
            }
            if(Objects.nonNull(user.getPassword())){
                tempUser.setPassword(user.getPassword());
            }
            if(Objects.nonNull(user.getProfileUrls())){
                tempUser.setProfileUrls(user.getProfileUrls());
            }
            if(Objects.nonNull(user.getActiveCount())){
                tempUser.setActiveCount(user.getActiveCount());
            }
            if(Objects.nonNull(user.getRating())){
                tempUser.setRating(user.getRating());
            }
            if(Objects.nonNull(user.getStatus())){
                tempUser.setStatus(user.getStatus());
            }
            if(Objects.nonNull(user.getRole())){
                tempUser.setRole(user.getRole());
            }
            if(Objects.nonNull(user.getKudosEarned())){
                tempUser.setKudosEarned(user.getKudosEarned());
            }
            User updatedUser = userRepo.save(tempUser);
        }
        return "User updated successfully";
    }

    //DELETE Methods
    @Override
    public String deleteUserByUserId(Integer id) {
        List<User> tempUser = this.userRepo.findUsersByUserId(id);
        try {
            int userId = tempUser.get(0).getId();
            this.userRepo.deleteById(userId);
            return "user deleted successfully";
        }catch (Exception e) {
            return "Cannot delete user";
        }
    }

}
