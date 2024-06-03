package com.NewsViews;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class CRUD {

    private String id;
    private String name;
    private Map<String, Long> subjectMarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Long> getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(Map<String, Long> subjectMarks) {
        this.subjectMarks = subjectMarks;
    }
}
