package ftn.xmlws.project.beans;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PricePerInterval")
public class PricePerInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private Long accomodationId;

    @Column
    private float price;

    public PricePerInterval() {

    }

	public PricePerInterval(Long id, Date startDate, Date endDate, Long accomodationId, float price) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.accomodationId = accomodationId;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getAccomodationId() {
		return accomodationId;
	}

	public void setAccomodationId(Long accomodationId) {
		this.accomodationId = accomodationId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

    
    
}