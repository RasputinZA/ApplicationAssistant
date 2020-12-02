package za.ac.cput.service.previousQualification.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.previousQualification.Qualification;
import za.ac.cput.repository.previousQualification.QualificationRepository;
import za.ac.cput.service.previousQualification.QualificationService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QualificationServiceImpl implements QualificationService {


    @Autowired
    private QualificationRepository repository;


    @Override
    public Set<Qualification> getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


    @Override
    public Set<Qualification> getAllStartingWith(String letter) {
        Set<Qualification> qualifications = getAll();
        Set<Qualification> qualificationsStartingWith = new HashSet<>();
        for (Qualification Qualification : qualifications) {
            if (Qualification.getLevelOfQualifications().trim().toLowerCase().startsWith(letter)) {
                qualificationsStartingWith.add(Qualification);
            }
        }
        return qualificationsStartingWith;
    }

   /* @Override
    public ArrayList<Course> checkIfQualifies(Qualification qualification) {
        ArrayList<Course> subjectsQualified = new ArrayList<>();
        Set<Course> courseLIst = CourseServiceImpl.getService().getAll();
        for(Course course : courseLIst)
        {
            int passed = 0;
            for(Subject subject : qualification.getSubjectList())
            {
                for(Subject requirement : course.getCourseRequirement())
                {
                    if(subject.getSubjectName() == requirement.getSubjectName())
                    {
                        if(subject.getSubjectMark() >= requirement.getSubjectMark())
                        {
                            passed++;
                        }
                    }
                }

            }
            if(passed == course.getCourseRequirement().size())
            {
                subjectsQualified.add(course);
            }
        }
        return subjectsQualified;
    }*/

    @Override
    public Qualification create(Qualification qualification) {
        return this.repository.save(qualification);
    }

    @Override
    public Qualification read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Qualification update(Qualification qualification) {
        if (this.repository.existsById(qualification.getQualificationId()))
        return this.repository.save(qualification);

        return null;
    }

    @Override
    public boolean delete(String s) {

         this.repository.deleteById(s);

        if (this.repository.existsById(s)) {
            return false;
        }
        else return true;
    }
}
