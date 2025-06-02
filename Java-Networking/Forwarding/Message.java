package Forwarding;

import java.io.Serializable;

public class Message implements Serializable {
    private String To,From,sms;
    Message(String To, String From, String sms){
        this.To = To;
        this.From = From;
        this.sms = sms;
    }
    public String getTo() {
        return To;
    }
    public String getFrom() {
        return From;
    }
    public String getSms() {
        return sms;
    }
}
