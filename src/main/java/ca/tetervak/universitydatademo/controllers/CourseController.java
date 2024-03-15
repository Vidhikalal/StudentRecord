package ca.tetervak.universitydatademo.controllers;

import ca.tetervak.universitydatademo.domain.Course;
import ca.tetervak.universitydatademo.domain.Department;
import ca.tetervak.universitydatademo.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    CourseRepository courseRepository;
    @PutMapping("/{id}")
    public String putCourse(@RequestBody Course course, @PathVariable Integer id){
        course.setId(id);
        courseRepository.save(course);
        return "Total Records:" + courseRepository.count();

    }
    @PutMapping("/course")
    public String putStudentList(@RequestBody List<Course> courseList){
        courseRepository.saveAll(courseList);
        return "Ok";

    }

    @GetMapping
    public List<Course> getAllCourses(){

        List<Course>courseList=new ArrayList<>();
        courseRepository.findAll().forEach(courseList::add);
        return courseList;
    }
}
