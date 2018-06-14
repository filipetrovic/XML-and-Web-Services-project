package ftn.xmlws.adminmodule.beans;

import java.io.Serializable;

public class StarRating implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	
	public StarRating() {}

	public Long getId() {
		return id;
	}

	public void setId(Long ratingId) {
		this.id = ratingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String ratingName) {
		this.name = ratingName;
	};
	
	
	

}
