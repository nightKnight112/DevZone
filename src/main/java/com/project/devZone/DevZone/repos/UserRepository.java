package com.project.devZone.DevZone.repos;
import com.project.devZone.DevZone.entities.Comments;
import com.project.devZone.DevZone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findUsersByUserId(Integer userid);
    List<User> findUsersByUserName(String name);
    List<User> findUsersByRole(String role);
    List<User> findUsersByStatus(Boolean status);
    List<Comments> findAllCommentsByUserId(Integer userId);

}
