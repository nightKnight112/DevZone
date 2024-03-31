package com.project.devZone.DevZone.repos;
import com.project.devZone.DevZone.entities.Follows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FollowsRepository extends JpaRepository<Follows, Integer> {

    List<Follows>findFollowersByFollowedUserId(Integer followedUserId);

    List<Follows>findFollowersByFollowId(Integer followId);

}
