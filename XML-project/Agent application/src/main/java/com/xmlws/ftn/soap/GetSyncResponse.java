
package com.xmlws.ftn.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="encodedAccommodationType" type="{http://ftn.xmlws.com/soap}encodedAccommodationType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="encodedFacility" type="{http://ftn.xmlws.com/soap}encodedFacility" maxOccurs="unbounded"/&gt;
 *         &lt;element name="encodedStarRating" type="{http://ftn.xmlws.com/soap}encodedStarRating" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "encodedAccommodationType",
    "encodedFacility",
    "encodedStarRating"
})
@XmlRootElement(name = "getSyncResponse")
public class GetSyncResponse {

    @XmlElement(required = true)
    protected List<EncodedAccommodationType> encodedAccommodationType;
    @XmlElement(required = true)
    protected List<EncodedFacility> encodedFacility;
    @XmlElement(required = true)
    protected List<EncodedStarRating> encodedStarRating;

    /**
     * Gets the value of the encodedAccommodationType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the encodedAccommodationType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncodedAccommodationType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EncodedAccommodationType }
     * 
     * 
     */
    public List<EncodedAccommodationType> getEncodedAccommodationType() {
        if (encodedAccommodationType == null) {
            encodedAccommodationType = new ArrayList<EncodedAccommodationType>();
        }
        return this.encodedAccommodationType;
    }

    /**
     * Gets the value of the encodedFacility property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the encodedFacility property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncodedFacility().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EncodedFacility }
     * 
     * 
     */
    public List<EncodedFacility> getEncodedFacility() {
        if (encodedFacility == null) {
            encodedFacility = new ArrayList<EncodedFacility>();
        }
        return this.encodedFacility;
    }

    /**
     * Gets the value of the encodedStarRating property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the encodedStarRating property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncodedStarRating().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EncodedStarRating }
     * 
     * 
     */
    public List<EncodedStarRating> getEncodedStarRating() {
        if (encodedStarRating == null) {
            encodedStarRating = new ArrayList<EncodedStarRating>();
        }
        return this.encodedStarRating;
    }

}
