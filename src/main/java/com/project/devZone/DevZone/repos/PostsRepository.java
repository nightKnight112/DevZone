package com.project.devZone.DevZone.repos;
import com.project.devZone.DevZone.entities.Comments;
import com.project.devZone.DevZone.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {

    List<Posts> findPostsByPostId(Integer postId);
    List<Posts> findPostsByTitle(String title);
    List<Posts> findPostsByLikes(Integer likes);
    List<Posts> findPostsByStatus(Boolean status);
}
