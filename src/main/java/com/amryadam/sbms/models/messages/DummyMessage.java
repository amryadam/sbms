package com.amryadam.sbms.models.messages;

import java.io.Serializable;

public class DummyMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private String source;
    private String message;

    @Override
    public String toString() {
        return "DummyMessage{" +
               "source='" + source + '\'' +
               ", message='" + message + '\'' +
               '}';
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
