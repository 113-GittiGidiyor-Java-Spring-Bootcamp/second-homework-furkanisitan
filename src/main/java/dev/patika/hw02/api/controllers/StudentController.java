package dev.patika.hw02.api.controllers;

import dev.patika.hw02.business.abstracts.StudentService;
import dev.patika.hw02.core.utilities.constants.ResponseMessage;
import dev.patika.hw02.core.utilities.helpers.ApiErrors;
import dev.patika.hw02.core.utilities.results.abstracts.DataResult;
import dev.patika.hw02.core.utilities.results.helpers.DataResultHelper;
import dev.patika.hw02.entities.concretes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<DataResult<List<Student>>> getAll() {
        return ResponseEntity.ok(DataResultHelper.ok(studentService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Student>> getById(@PathVariable long id) {

        Student student = studentService.findById(id);

        return student != null ?
                ResponseEntity.ok(DataResultHelper.ok(student)) :
                ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(DataResultHelper.fail(ResponseMessage.NOT_FOUND,
                                ApiErrors.entityNotFound(Student.class.getSimpleName(), Pair.of("id", id))));
    }
}
