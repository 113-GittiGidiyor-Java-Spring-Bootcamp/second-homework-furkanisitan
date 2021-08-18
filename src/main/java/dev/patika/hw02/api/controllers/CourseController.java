package dev.patika.hw02.api.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.patika.hw02.business.abstracts.CourseService;
import dev.patika.hw02.core.utilities.constants.ResponseMessage;
import dev.patika.hw02.core.utilities.helpers.ApiErrors;
import dev.patika.hw02.core.utilities.results.abstracts.DataResult;
import dev.patika.hw02.core.utilities.results.helpers.DataResultHelper;
import dev.patika.hw02.entities.concretes.Course;
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
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @JsonIgnoreProperties({"instructor"})
    @GetMapping
    public ResponseEntity<DataResult<List<Course>>> getAll() {
        return ResponseEntity.ok(DataResultHelper.ok(courseService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Course>> getById(@PathVariable long id) {

        Course course = courseService.findById(id);

        return course != null ?
                ResponseEntity.ok(DataResultHelper.ok(course)) :
                ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(DataResultHelper.fail(ResponseMessage.NOT_FOUND,
                                ApiErrors.entityNotFound(Course.class.getSimpleName(), Pair.of("id", id))));
    }

}
