package za.ac.cput.service.tertiaryInstitution;

import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.service.IService;

import java.util.Set;

public interface CourseService extends IService<Course, String> {
    Set<Course> getAll();


    Set<String> searchByName(String name);

    Set<String> getQualifiedCourses(double markAverage);

}
