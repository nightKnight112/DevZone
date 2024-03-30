package com.project.devZone.DevZone.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column
    private String commentBody;

    @Column
    private Integer likes;

    @Column
    private Integer dislikes;

    @Column(name = "love_reacts")
    private Integer loveReacts;

    @Column(name = "attachemnt_url")
    private String commentAttachments;

    @Column(name = "by_user_id")
    private Integer byUserId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User users;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "posts_has_comments",
            joinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "commentId"),
            inverseJoinColumns = @JoinColumn(name = "post_id", referencedColumnName = "postId")
    )
    private List<Posts> posts = new ArrayList<>();


}
