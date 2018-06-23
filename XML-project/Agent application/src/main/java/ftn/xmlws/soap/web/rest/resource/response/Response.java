package ftn.xmlws.soap.web.rest.resource.response;

public class Response {

    private String message;
    private Object payload;

    public Response() {

    }

    public Response(String message, Object payload) {
        this.message = message;
        this.payload = payload;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", objectDTO=" + payload +
                '}';
    }
}
