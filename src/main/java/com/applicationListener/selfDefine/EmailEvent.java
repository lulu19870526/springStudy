package com.applicationListener.selfDefine;

import org.springframework.context.ApplicationEvent;


public class EmailEvent extends ApplicationEvent {
 private String address;
private String text;
public EmailEvent(Object source, String address, String text){
 super(source);
 this.address = address;
 this.text = text;
   }
public EmailEvent(Object source) {
   super(source);
  }

    public String getAddress() {
        return address;
    }

    public String getText() {
        return text;
    }
}
