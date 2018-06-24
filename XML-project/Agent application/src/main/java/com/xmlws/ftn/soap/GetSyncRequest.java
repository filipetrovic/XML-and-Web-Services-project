
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
 *         &lt;element name="agentId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="encodedAccomodation" type="{http://ftn.xmlws.com/soap}encodedAccomodation" maxOccurs="unbounded"/&gt;
 *         &lt;element name="encodedPriceList" type="{http://ftn.xmlws.com/soap}encodedPriceList" maxOccurs="unbounded"/&gt;
 *         &lt;element name="encodedRequest" type="{http://ftn.xmlws.com/soap}encodedRequest" maxOccurs="unbounded"/&gt;
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
    "agentId",
    "encodedAccomodation",
    "encodedPriceList",
    "encodedRequest"
})
@XmlRootElement(name = "getSyncRequest")
public class GetSyncRequest {

    @XmlElement(required = true)
    protected String agentId;
    @XmlElement(required = true)
    protected List<EncodedAccomodation> encodedAccomodation;
    @XmlElement(required = true)
    protected List<EncodedPriceList> encodedPriceList;
    @XmlElement(required = true)
    protected List<EncodedRequest> encodedRequest;

    /**
     * Gets the value of the agentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * Sets the value of the agentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentId(String value) {
        this.agentId = value;
    }

    /**
     * Gets the value of the encodedAccomodation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the encodedAccomodation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncodedAccomodation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EncodedAccomodation }
     * 
     * 
     */
    public List<EncodedAccomodation> getEncodedAccomodation() {
        if (encodedAccomodation == null) {
            encodedAccomodation = new ArrayList<EncodedAccomodation>();
        }
        return this.encodedAccomodation;
    }

    /**
     * Gets the value of the encodedPriceList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the encodedPriceList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncodedPriceList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EncodedPriceList }
     * 
     * 
     */
    public List<EncodedPriceList> getEncodedPriceList() {
        if (encodedPriceList == null) {
            encodedPriceList = new ArrayList<EncodedPriceList>();
        }
        return this.encodedPriceList;
    }

    /**
     * Gets the value of the encodedRequest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the encodedRequest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncodedRequest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EncodedRequest }
     * 
     * 
     */
    public List<EncodedRequest> getEncodedRequest() {
        if (encodedRequest == null) {
            encodedRequest = new ArrayList<EncodedRequest>();
        }
        return this.encodedRequest;
    }

}
