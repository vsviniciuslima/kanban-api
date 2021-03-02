package com.looplex.kanbanapi.controller;

import com.looplex.kanbanapi.model.Student;
import com.looplex.kanbanapi.model.paging.StudentPage;
import com.looplex.kanbanapi.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @GetMapping
    public ResponseEntity<Page<Student>> getStudents(StudentPage studentPage) {
        return new ResponseEntity<>(studentService.getStudents(studentPage), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
    }

    @GetMapping(value="/specific")
    public ResponseEntity<Page<Student>> getFilteredStudents(StudentPage studentPage) {
        return new ResponseEntity<>(studentService.getFilteredStudents(studentPage), HttpStatus.OK);
    }

    /*
    @GetMapping(value="/specific")
    public ResponseEntity<Map<String, Object>> getStudentByName(StudentPage studentPage) {
        Sort sort = Sort.by(studentPage.getSortDirection(), studentPage.getSortBy());

        List<Student> students = new ArrayList<Student>();
        String name = studentPage.getFilterByFirstName();

        Pageable paging = PageRequest.of(studentPage.getPageNumber(), studentPage.getPageSize());
        Page<Student> pageStudents = studentRepository.findByFirstName(name, paging);

        students = pageStudents.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("students", students);
        response.put("currentPage", pageStudents.getNumber());
        response.put("totalItems", pageStudents.getTotalElements());
        response.put("totalPages", pageStudents.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/



    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

}
