package com.project.devZone.DevZone.repos;
import com.project.devZone.DevZone.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {

    List<Comments>findCommentByCommentId(Integer Id);
    List<Comments>findCommentsByLikes(Integer likes);
    List<Comments>findCommentsByLoveReacts(Integer loveReacts);

}
