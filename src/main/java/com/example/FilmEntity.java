package com.example;

import java.io.Serializable;

public class FilmEntity implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String description;
	private String year;
    private String producer;
    private String image;
    private Boolean isLiked;
    

    public FilmEntity() {}
    
    

    public FilmEntity(String id, String name, String description, String year, String producer, String image,
			Boolean isLiked) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.year = year;
		this.producer = producer;
		this.image = image;
		this.isLiked = isLiked;
	}



	public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getIsLiked() {
		return isLiked;
	}

	public void setIsLiked(Boolean isLiked) {
		this.isLiked = isLiked;
	}
	
	@Override
	public String toString() {
		return "FilmEntity [id=" + id + ", name=" + name + ", description=" + description + ", year=" + year
				+ ", producer=" + producer + ", image=" + image + ", isLiked=" + isLiked + "]";
	}
}