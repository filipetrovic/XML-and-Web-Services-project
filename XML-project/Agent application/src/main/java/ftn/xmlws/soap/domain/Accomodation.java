package ftn.xmlws.soap.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Accomodation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    private String image;

    private String description;

    private String city;

    private String address;

    private String agentName;

    @OneToOne
    private StarRating starRating;

    private int number;

    @OneToOne
    private Category category;

    @ManyToMany
    private List<Addition> additions;

    @Column
    private Date startDateAvailable;

    @Column
    private Date endDateAvailable;

    public Accomodation() {

    }

    public Accomodation(String name, String image, String description, String city, String address, String agentName, int number, Category category, List<Addition> additions, StarRating starRating) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.city = city;
        this.address = address;
        this.agentName = agentName;
        this.number = number;
        this.category = category;
        this.additions = additions;
        this.starRating = starRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Addition> getAdditions() {
        return additions;
    }

    public void setAdditions(List<Addition> additions) {
        this.additions = additions;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public StarRating getStarRating() {
        return starRating;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }

    public Date getStartDateAvailable() {
        return startDateAvailable;
    }

    public void setStartDateAvailable(Date startDateAvailable) {
        this.startDateAvailable = startDateAvailable;
    }

    public Date getEndDateAvailable() {
        return endDateAvailable;
    }

    public void setEndDateAvailable(Date endDateAvailable) {
        this.endDateAvailable = endDateAvailable;
    }

    @Override
    public String toString() {
        return "Accomodation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", agentName='" + agentName + '\'' +
                ", starRating=" + starRating +
                ", number=" + number +
                ", category=" + category +
                ", additions=" + additions +
                '}';
    }
}
