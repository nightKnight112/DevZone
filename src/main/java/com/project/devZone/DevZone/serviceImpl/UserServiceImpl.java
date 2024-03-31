package com.project.devZone.DevZone.serviceImpl;

import com.project.devZone.DevZone.entities.Comments;
import com.project.devZone.DevZone.entities.Follows;
import com.project.devZone.DevZone.entities.User;
import com.project.devZone.DevZone.repos.CommentsRepository;
import com.project.devZone.DevZone.repos.FollowsRepository;
import com.project.devZone.DevZone.repos.UserRepository;
import com.project.devZone.DevZone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public String saveNewUser(User user) {
        userRepo.save(user);
        return "User Added Successfully";
    }

    @Override
    public List<User> fetchAllUser(){
        List<User> allUserList = userRepo.findAll();
        return allUserList;
    }

    @Override
    public String updateUserById(User user, Integer id) {
        Optional<User> userExists = this.userRepo.findById(id);
        if(userExists.isEmpty()) {
            throw new IllegalArgumentException("User Does not exist");
        }else{
            User tempUser = userExists.get();
            if(Objects.nonNull(user.getUserName()) && tempUser.getUserName().equalsIgnoreCase(user.getUserName())){
                tempUser.setUserName(user.getUserName());
            }
            if(Objects.nonNull(user.getUserId()) && tempUser.getUserId().equals(user.getUserId())){
                tempUser.setUserId(user.getUserId());
            }
            User updatedUser = userRepo.save(tempUser);
        }
        return "User updated successfully";
    }

    @Override
    public String deleteUserById(Integer id) {

        this.userRepo.deleteById(id);
        return "user deleted successfully";
    }

    @Override
    public List<User> fetchUsersSortedByKudosEarned() {
        return null;
    }

    @Override
    public List<Follows> fetchAllFollowersOfUser(Integer Id) {
        return null;
    }

    @Override
    public List<Comments> fetchAllCommentsByUser(Integer Id) {
        return null;
    }

}
