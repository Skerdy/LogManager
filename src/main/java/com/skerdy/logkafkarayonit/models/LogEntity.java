package com.skerdy.logkafkarayonit.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log")
public class LogEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    private Date date;
    private String type;
    private String message;

    public LogEntity(){

    }

    public LogEntity(Date date, String type, String message) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
