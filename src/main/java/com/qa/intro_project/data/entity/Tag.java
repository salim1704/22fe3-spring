package com.qa.intro_project.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tag")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "name", unique = true)
	@Size(min = 2, max = 24, message = "Tag name must have at least 3 characters, but no more than 24")
	private String name;
	
	@ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Post> posts;
	
	protected Tag() {
		super();
	}
	
	public Tag(String name) {
		super();
		this.name = name;
	}

	public Tag(String name, List<Post> posts) {
		super();
		this.name = name;
		this.posts = posts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
}
