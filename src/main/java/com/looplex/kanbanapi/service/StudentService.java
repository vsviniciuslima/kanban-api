package com.looplex.kanbanapi.service;

import com.looplex.kanbanapi.model.Student;
import com.looplex.kanbanapi.model.paging.StudentPage;
import com.looplex.kanbanapi.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public Page<Student> getStudents(StudentPage studentPage) {
        Sort sort = Sort.by(studentPage.getSortDirection(), studentPage.getSortBy());
        Pageable pageable = PageRequest.of(studentPage.getPageNumber(),
                studentPage.getPageSize(), sort);

        if(studentPage.getFilterArgument() != null) {
            return studentRepository.findByFirstName(studentPage.getFilterArgument(), pageable);
        }
        return studentRepository.findAll(pageable);

    }

    public Page<Student> getFilteredStudents(StudentPage studentPage) {
        Sort sort = Sort.by(studentPage.getSortDirection(), studentPage.getSortBy());
        Pageable pageable = PageRequest.of(studentPage.getPageNumber(),
                studentPage.getPageSize(), sort);
        return studentRepository.findAll(pageable);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    /*
    public Page<Student> getStudentByName(StudentPage studentPage) {
        Sort sort = Sort.by(studentPage.getSortDirection(), studentPage.getSortBy());

        String filterCriteria = studentPage.getFilterByFirstName();

        List<Student> firstNameEqualsToStudents =
                studentRepository.findAll().stream().filter(p -> p.getFirstName().equals(filterCriteria)).collect(Collectors.toList());

        Pageable pageable = PageRequest.of(studentPage.getPageNumber(),
                studentPage.getPageSize(), sort);


        //System.out.println(firstNameEqualsToStudents.toString());
        return studentRepository.findByFirstName(filterCriteria, pageable);
    }*/

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
