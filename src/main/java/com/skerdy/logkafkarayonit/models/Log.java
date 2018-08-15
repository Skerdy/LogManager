package com.skerdy.logkafkarayonit.models;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {

    public static final String ERROR = "Error";
    public static final String WARNING = "Warning";
    public static final String UNKNOWN = "Unknown";

    private Date date;
    private String type;
    private String message;

    public Log(){

    }

    public Log(Date date, String type, String message) {
        this.date = date;
        this.type = type;
        this.message = message;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
