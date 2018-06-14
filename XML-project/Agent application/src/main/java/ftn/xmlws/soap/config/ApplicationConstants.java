package ftn.xmlws.soap.config;

/**
 * Interface containing all application constants
 * @author sansajn
 */
public interface ApplicationConstants {

    public static String ENDPOINT_AGENT = "http://ftn.xmlws.com/soap";
    public static String LOCAL_PART_AGENT = "getAgentRequest";

    public static String CONFIG_LOCATION_URI = "/soapWS";
    public static String CONFIG_SERVICE = "AgentServicePort";
    public static String CONFIG_SERVLET_REGISTRATION = "/soapWS/*";
    public static String CONFIG_SCHEMA_LOCATION = "schemas/agent.xsd";
}
