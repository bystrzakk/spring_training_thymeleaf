package com.app.service;

import com.app.converter.CourseConverter;
import com.app.dto.CourseDto;
import com.app.model.Course;
import com.app.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ServiceImpl implements CourseService {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);
    private final CourseRepository repository;
    private final CourseConverter converter;

    @Autowired
    public ServiceImpl(CourseRepository repository, CourseConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Page<CourseDto> getAllCourse(int page, int size) {
        LOG.info("Getting courses for page {} and sie {}", page, size);
        final Page<Course> repositoryAll = repository.findAll(PageRequest.of(page, size));
        final List<CourseDto> courseDtos = repositoryAll.stream().map(converter::convertToDto).collect(Collectors.toList());
        return new PageImpl<>(courseDtos, repositoryAll.getPageable(), repositoryAll.getTotalPages());
    }

    @Override
    public CourseDto getCourseById(int id) {
        final Optional<Course> byId = repository.findById(id);
        return byId.map(converter::convertToDto).orElse(null);
    }

    @Override
    public void saveCourse(CourseDto courseDto) {
        final Course convertCourse = converter.convertFromDto(courseDto);
        repository.save(convertCourse);
    }

    @Override
    public void deleteCourse(int id) {
        repository.deleteById(id);
    }

}
