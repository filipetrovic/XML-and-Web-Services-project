package ftn.xmlws.soap.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private boolean checked = false;

    @Column(name = "check_in_date", nullable = false)
    private Date checkInDate;

    @Column(name = "check_out_date", nullable = false)
    private Date checkOutDate;

    @Column
    private boolean arrivalConfirmed;

    @Column
    private float priceOfReservation;

    @OneToMany(mappedBy="reservation", cascade = CascadeType.ALL)
    private Set<Message> messages;

    public Reservation() {

    }

    public Reservation(String username, boolean checked) {
        this.username = username;
        this.checked = checked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public boolean isArrivalConfirmed() {
        return arrivalConfirmed;
    }

    public void setArrivalConfirmed(boolean arrivalConfirmed) {
        this.arrivalConfirmed = arrivalConfirmed;
    }

    public float getPriceOfReservation() {
        return priceOfReservation;
    }

    public void setPriceOfReservation(float priceOfReservation) {
        this.priceOfReservation = priceOfReservation;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
