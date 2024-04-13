package com.project.devZone.DevZone.service;

import com.project.devZone.DevZone.entities.Comments;
import com.project.devZone.DevZone.entities.Follows;
import com.project.devZone.DevZone.entities.User;
import com.project.devZone.DevZone.payload.LoginBody;

import java.util.List;

public interface UserService {

    String saveNewUser(User user);
    List<User> fetchAllUser();
    String updateUserById(User user, Integer id);
    String deleteUserByUserId(Integer id);
    List<Follows> fetchAllFollowersOfUser(Integer Id);
    List<Comments> fetchAllCommentsByUser(Integer Id);
    List<User> getUserDetails(Integer id);
    String userLogin(LoginBody loginBody);
    List<User> getUserDetailsByUserName(String userName);
}
