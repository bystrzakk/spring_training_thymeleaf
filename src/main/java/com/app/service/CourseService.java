package com.app.service;

import com.app.dto.CourseDto;
import com.app.model.Course;
import org.springframework.data.domain.Page;

public interface CourseService {


    Page<CourseDto> getAllCourse(int page, int size);

    Course getCourseById(int id);

    void saveCourse(CourseDto course);

    void deleteCourse(int id);


}
