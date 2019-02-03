package main.lesson8.ads;

import java.util.Date;

public class Message extends BaseEntity{
    User userFrom;
    User userTo;
    Date dateSent;
    Date dateRead;
    String message;

    public Message(long id, User userFrom, User userTo, String message) {
        super(id);
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.message = message;
        this.dateSent = new Date();
    }

    void setDateRead() {
        dateRead = new Date();
    }

    boolean isRead() {
        if (dateRead == null) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Message{" +
                "userFrom=" + userFrom +
                ", userTo=" + userTo +
                ", dateSent=" + dateSent +
                ", dateRead=" + dateRead +
                ", message='" + message + '\'' +
                ", id=" + id +
                '}';
    }
}
