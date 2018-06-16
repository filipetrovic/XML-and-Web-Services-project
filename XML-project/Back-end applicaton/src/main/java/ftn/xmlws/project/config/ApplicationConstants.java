package ftn.xmlws.project.config;

/**
 * Interface containing all application constants
 * @author sansajn
 */
public interface ApplicationConstants {

    public static String ENDPOINT_AGENT = "http://ftn.xmlws.com/soap";
    public static String LOCAL_PART_AGENT = "getSyncRequest";

    public static String CONFIG_LOCATION_URI = "/soapWS";
    public static String CONFIG_SERVICE = "SyncServicePort";
    public static String CONFIG_SERVLET_REGISTRATION = "/soapWS/*";
    public static String CONFIG_SCHEMA_LOCATION = "schemas/sync.xsd";

}