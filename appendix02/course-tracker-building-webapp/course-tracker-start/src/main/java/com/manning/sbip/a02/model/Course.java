package com.manning.sbip.a02.model;

import javax.validation.constraints.*;

public class Course {

	private int id;

	@NotEmpty(message = "Course name field can't be empty")
	private String name;

	@NotEmpty(message = "Course category field can't be empty")
	private String category;

	@Min(value = 1)
	@Max(value = 5)
	private int rating;

	@NotEmpty(message = "Course description field can't be empty")
	private String description;

	public Course() {}

	public Course(int id, String name, String category, int rating, String description) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.rating = rating;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id=" + id +
				", name='" + name + '\'' +
				", category='" + category + '\'' +
				", rating=" + rating +
				", description='" + description + '\'' +
				'}';
	}
}
