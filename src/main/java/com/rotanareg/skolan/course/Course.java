package com.rotanareg.skolan.course;
import java.io.Serializable;

public final class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private final long id;
    private final String name;
    private final String description;

public Course (long id, String name, String description){
	    this.id = id;
        this.name = name;
        this.description = description;
}
 public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }	
}
