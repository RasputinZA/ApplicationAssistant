package za.ac.cput.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.factory.tertiaryInstitution.CourseFactory;

public class CourseFactoryTest {

    @Test
    public void createCourse() {
        Course course = CourseFactory.createCourse("Information Technology", "ICT362S", "15000", 53);

        Assert.assertEquals("Information Technology", course.getCourseName());
        Assert.assertEquals("ICT362S", course.getCourseCode());
        Assert.assertEquals("15000", course.getCourseFees());
    }
}