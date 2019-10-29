package com.smokies.smokies;

public class Event {
	private String description;

	private String id;

	private String title;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "ClassPojo [description = " + description + ", id = " + id + ", title = " + title + "]";
	}
}
