package com.project.devZone.DevZone.entities;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "title", unique = true)
    @NotEmpty(message = "post title cannot be blank")
    @Length(min=10, max=60, message="title must be between 10 to 60 characters")
    private String title;

    @Column(name = "body")
    @NotEmpty(message = "post body cannot be blank")
    private String postBody;

    @Column(name = "attachemnt_url")
    private String postAttachments;

    @Column(name = "by_user_id")
    private Integer byUserId;

    @Column
    private Boolean status;

    @Column
    private String timestamp;

    @Column
    private Integer likes;

    @Column
    private Integer dislikes;

    @Column(name = "love_reacts")
    private Integer loveReacts;

    @ManyToMany(mappedBy = "posts")
    private List<Comments> comments = new ArrayList<>();
}
