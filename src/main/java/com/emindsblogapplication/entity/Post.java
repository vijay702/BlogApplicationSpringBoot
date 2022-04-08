package com.emindsblogapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Table(
		
		name = "posts" , uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
		)
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "title " , nullable = false)
	private String title;
	@Column(name = "descrption " , nullable = false)
	private String descrption;
	@Column(name = "content " , nullable = false)
	private String content;
	private String apiStatus;
	private String apiMessage;
	public Long getId() {
		return id;
	}

	public String getApiStatus() {
		return apiStatus;
	}

	public void setApiStatus(String apiStatus) {
		this.apiStatus = apiStatus;
	}

	public String getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(String apiMessage) {
		this.apiMessage = apiMessage;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
