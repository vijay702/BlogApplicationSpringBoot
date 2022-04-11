package com.emindsblogapplication.entity;

import javax.persistence.*;

import lombok.*;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Table(
		
		name = "posts" , uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
		)
@Entity
@Getter
@Setter
@ToString
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="postId")
	private Long id;
	
	@Column(name = "title " , nullable = false)
	private String title;
	@Column(name = "descrption " , nullable = false)
	private String descrption;
	@Column(name = "content " , nullable = false)
	private String content;
	private String apiStatus;
	private String apiMessage;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "postId")
   private Set<Comment> comments = new HashSet<>();



}
