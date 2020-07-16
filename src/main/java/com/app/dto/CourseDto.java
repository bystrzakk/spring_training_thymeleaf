package com.app.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CourseDto {

    private int id;

    @NotNull
    @Size(min = 1, max = 30, message = "Nazwa kursu jest wymagana!")
    private String courseName;

    @NotNull
    @Size(min = 1, max = 30, message = "Kategoria kursu jest wymagana!")
    private String categories;

    public CourseDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
