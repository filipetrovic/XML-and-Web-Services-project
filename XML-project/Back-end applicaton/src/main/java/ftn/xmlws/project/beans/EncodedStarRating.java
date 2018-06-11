package ftn.xmlws.project.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


//Sifarnik za kategorizaciju
@Entity
@Table(name="encoded_star_rating")
public class EncodedStarRating implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ratingID;
	
	@NotNull
	@Column
	private String ratingName;
	
	public EncodedStarRating() {}
	
	public Long getRatingID() {
		return ratingID;
	}

	public void setRatingID(Long ratingID) {
		this.ratingID = ratingID;
	}

	public String getRatingName() {
		return ratingName;
	}

	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
	}

}
