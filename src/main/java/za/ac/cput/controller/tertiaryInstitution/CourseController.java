package za.ac.cput.controller.tertiaryInstitution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.factory.tertiaryInstitution.CourseFactory;
import za.ac.cput.service.tertiaryInstitution.impl.CourseServiceImpl;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/course")

public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @PostMapping("/create")
    public Course create(@RequestBody Course course) {
        Course newCourse = CourseFactory.createCourse(course.getCourseName(), course.getCourseCode(), course.getCourseFees(), course.getCourseRequirement());
        return courseService.create(newCourse);
    }

    @GetMapping("/search/{name}")
    public Set<String> searchByName(@PathVariable String name) { return courseService.searchByName(name); }

    @GetMapping("/getcourses/{markAvg}")
    public Set<String> getQualifiedCourses(@PathVariable double markAvg) { return courseService.getQualifiedCourses(markAvg); }

    @GetMapping("/read/{courseId}")
    public Course read(@PathVariable String courseId) { return courseService.read(courseId); }

    @PostMapping("/update")
    public Course update(@RequestBody Course course) { return courseService.update(course); }

    @GetMapping("/all")
    public Set<Course> getAll() { return courseService.getAll(); }

    @DeleteMapping("/delete/{courseId}")
    public boolean delete(@PathVariable String courseId) { return courseService.delete(courseId); }
}
