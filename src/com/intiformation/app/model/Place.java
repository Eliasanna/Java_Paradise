package com.intiformation.app.model;

import java.io.Serializable;

public class Place  implements Serializable {

    private long id;
    private String name;

    public Place() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}