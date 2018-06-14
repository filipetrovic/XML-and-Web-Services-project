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
	private Long id;
	
	@NotNull
	@Column(unique=true)
	private String name;
	
	public EncodedStarRating() {}
	
	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String ratingName) {
		this.name = ratingName;
	}

}
