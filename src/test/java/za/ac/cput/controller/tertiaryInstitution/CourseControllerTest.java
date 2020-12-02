package za.ac.cput.controller.tertiaryInstitution;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.factory.tertiaryInstitution.CourseFactory;

import java.util.Set;

import static org.junit.Assert.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseControllerTest {

    private static Course course = CourseFactory.createCourse("Graphics", "BP3", "2000", 53);
    private static String SECURITY_USERNAME = "Abdullah";
    private static String SECURITY_PASSWORD = "password";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/course/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + course);

        ResponseEntity<Course> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, course, Course.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse);


        course = postResponse.getBody();
        System.out.println("Saved data: " + course);
        assertEquals(course.getCourseId(), postResponse.getBody().getCourseId());
    }

    @Test
    public void e_getAllStartingWith() {
        String url = baseURL + "allwith/" + "b";
        System.out.println("URL: " + url);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + "15e4ecf9-6d3b-40a4-8463-b6aca03a1c69";
        System.out.println("URL: " + url);
        ResponseEntity<Course> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Course.class);

        System.out.println("Saved data: " + response.getBody());
        //assertEquals(course.getCourseId(), response.getBody().getCourseId());
    }

    @Test
    public void c_update() {
        Course updated = new Course.Builder().copy(course).setCourseFees("600").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Course> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, updated, Course.class);
        //assertEquals(course.getCourseId(), response.getBody().getCourseId());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void f_delete() {
        String url = baseURL + "delete/" + course.getCourseId();
        System.out.println("URL: " + url);
        restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }
}