package ftn.xmlws.adminmodule.beans;

import java.io.Serializable;

public class StarRating implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long ratingId;
	private String ratingName;
	
	public StarRating() {}

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public String getRatingName() {
		return ratingName;
	}

	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
	};
	
	
	

}
