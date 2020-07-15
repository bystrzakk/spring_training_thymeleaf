package com.app.service;

import com.app.dto.CourseDto;
import org.springframework.data.domain.Page;

public interface CourseService {


    Page<CourseDto> getAllCourse(int page, int size);

    CourseDto getCourseById(int id);

    void saveCourse(CourseDto course);

    void deleteCourse(int id);


}
