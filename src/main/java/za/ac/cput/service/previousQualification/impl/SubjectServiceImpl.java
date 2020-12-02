package za.ac.cput.service.previousQualification.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.financialAid.Funding;
import za.ac.cput.entity.previousQualification.Subject;
import za.ac.cput.repository.previousQualification.SubjectRepository;
import za.ac.cput.service.previousQualification.SubjectService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository repository;

    @Override
    public Set<Subject> getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Subject> searchByName(String name) {
        Set<Subject> subjects = getAll();
        Set<Subject> subjectsByName = new HashSet<>();
        for (Subject subject : subjects) {
            if (subject.getSubjectName().trim().toLowerCase().contains(name))
            {
                subjectsByName.add(subject);
            }
        }
        return subjectsByName;

    }

   /** @Override
    public Set<Subject> sorting(){
        Set<Subject> subjects = getAll();
        Set<Subject> subjectsSorted = new HashSet<>();
        List<Subject> sortedList = new ArrayList<>(subjectsSorted);
        sortedList.sort(Comparator.comparing(Subject::getSubjectName));


        return  subjectsSorted;
    }*/

    @Override
    public Subject create(Subject subject) {

        return this.repository.save(subject);
    }

    @Override
    public Subject read(String id) {

        return this.repository.findById(id).orElseGet(null);
    }

    @Override
    public Subject update(Subject subject) {

        return create(subject);
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        if(this.repository.existsById(id)){
            return false;
        }else{
            return true;
        }
    }
}