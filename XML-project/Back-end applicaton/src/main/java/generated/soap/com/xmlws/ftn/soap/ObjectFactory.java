//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.23 at 09:17:58 PM UTC 
//


package com.xmlws.ftn.soap;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.xmlws.ftn.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.xmlws.ftn.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSyncRequest }
     * 
     */
    public GetSyncRequest createGetSyncRequest() {
        return new GetSyncRequest();
    }

    /**
     * Create an instance of {@link GetSyncResponse }
     * 
     */
    public GetSyncResponse createGetSyncResponse() {
        return new GetSyncResponse();
    }

    /**
     * Create an instance of {@link EncodedAccommodationType }
     * 
     */
    public EncodedAccommodationType createEncodedAccommodationType() {
        return new EncodedAccommodationType();
    }

    /**
     * Create an instance of {@link EncodedFacility }
     * 
     */
    public EncodedFacility createEncodedFacility() {
        return new EncodedFacility();
    }

    /**
     * Create an instance of {@link EncodedStarRating }
     * 
     */
    public EncodedStarRating createEncodedStarRating() {
        return new EncodedStarRating();
    }

}
