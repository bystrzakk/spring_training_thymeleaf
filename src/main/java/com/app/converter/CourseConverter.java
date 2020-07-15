package com.app.converter;

import com.app.dto.CourseDto;
import com.app.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter {

    public Course convertFromDto(CourseDto courseDto) {
        final Course course = new Course();
        course.setC_id(courseDto.getC_id());
        course.setCategories(courseDto.getCategories());
        course.setCourseName(courseDto.getCourseName());

        return course;
    }

    public CourseDto convertToDto(Course course) {
        final CourseDto courseDto = new CourseDto();
        courseDto.setCategories(course.getCategories());
        courseDto.setCourseName(course.getCourseName());
        courseDto.setC_id(course.getC_id());

        return courseDto;
    }

}
