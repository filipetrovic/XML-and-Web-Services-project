package ftn.xmlws.project.soap.service;

import java.util.List;

public class HelperDTO {

    private List<String> messageby;

    private String reservationStatus;

    private List<String> messages;

    public HelperDTO() {

    }

    public List<String> getMessageby() {
        return messageby;
    }

    public void setMessageby(List<String> messageby) {
        this.messageby = messageby;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
