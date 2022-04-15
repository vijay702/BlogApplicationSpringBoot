package com.emindsblogapplication.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
@ApiModel(description = "Post Model Informations")
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
	@ApiModelProperty(value = "Blog Post Id")
	private Long id;
	@ApiModelProperty(value = "Blog Post title")
	private String title;
	@ApiModelProperty(value = "Blog Post descrption")
	private String descrption;
	@ApiModelProperty(value = "Blog Post content")
	private String content;
	private String apiStatus;
	private String apiMessage;
	private Set<CommentDto> comments;

}
