package com.project.devZone.DevZone.service;

import com.project.devZone.DevZone.entities.Comments;
import com.project.devZone.DevZone.entities.Follows;
import com.project.devZone.DevZone.entities.User;

import java.util.List;

public interface UserService {

    String saveNewUser(User user);
    List<User> fetchAllUser();
    String updateUserById(User user, Integer id);
    String deleteUserById(Integer id);
    List<User> fetchUsersSortedByKudosEarned();
    List<Follows> fetchAllFollowersOfUser(Integer Id);
    List<Comments> fetchAllCommentsByUser(Integer Id);
}
