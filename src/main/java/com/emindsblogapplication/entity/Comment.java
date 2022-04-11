package com.emindsblogapplication.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comment" , uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    private String name;
    private String email;
    private String body;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name ="postId")
    private Post post;


}
