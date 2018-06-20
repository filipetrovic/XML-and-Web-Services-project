package ftn.xmlws.soap.web.rest.resource.response;

public class Response {

    private String message;
    private Object objectDTO;

    public Response() {

    }

    public Response(String message, Object objectDTO) {
        this.message = message;
        this.objectDTO = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObjectDTO() {
        return objectDTO;
    }

    public void setObjectDTO(Object objectDTO) {
        this.objectDTO = objectDTO;
    }
}
