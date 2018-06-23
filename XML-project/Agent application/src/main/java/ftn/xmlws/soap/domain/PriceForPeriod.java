package ftn.xmlws.soap.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PriceForPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @OneToOne
    private Accomodation accomodation;

    private float price;

    public PriceForPeriod() {

    }

    public PriceForPeriod(Date startDate, Date endDate, Accomodation accomodation, float price) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.accomodation = accomodation;
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

    public Accomodation getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(Accomodation accomodation) {
        this.accomodation = accomodation;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
