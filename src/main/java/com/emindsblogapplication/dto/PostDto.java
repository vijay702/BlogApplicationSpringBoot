package com.emindsblogapplication.dto;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
	
	
	public Long getId() {
		return id;
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
	private Long id;
	private String title;
	private String descrption;
	private String content;

}
