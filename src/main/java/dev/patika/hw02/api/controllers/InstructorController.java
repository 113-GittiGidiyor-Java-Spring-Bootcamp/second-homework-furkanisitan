package dev.patika.hw02.api.controllers;

import dev.patika.hw02.api.helpers.DataResultResponseHelper;
import dev.patika.hw02.api.helpers.ResultResponseHelper;
import dev.patika.hw02.business.abstracts.InstructorService;
import dev.patika.hw02.core.results.abstracts.DataResult;
import dev.patika.hw02.core.results.abstracts.Result;
import dev.patika.hw02.core.results.helpers.DataResultHelper;
import dev.patika.hw02.entities.concretes.Instructor;
import dev.patika.hw02.entities.concretes.PermanentInstructor;
import dev.patika.hw02.entities.concretes.Student;
import dev.patika.hw02.entities.concretes.VisitingResearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<DataResult<List<Instructor>>> getAll() {
        return ResponseEntity.ok(DataResultHelper.ok(instructorService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Instructor>> getById(@PathVariable long id) {

        Instructor instructor = instructorService.findById(id);

        return instructor != null ?
                ResponseEntity.ok(DataResultHelper.ok(instructor)) :

                // return 404 if instructor does not exist
                DataResultResponseHelper.notFound(Student.class.getSimpleName(), Pair.of("id", id));
    }

    @PostMapping("/permanent-instructors")
    public ResponseEntity<DataResult<Instructor>> createPermanentInstructor(@RequestBody PermanentInstructor permanentInstructor) {
        return create(permanentInstructor);
    }

    @PostMapping("/visiting-researchers")
    public ResponseEntity<DataResult<Instructor>> createVisitingResearcher(@RequestBody VisitingResearcher visitingResearcher) {
        return create(visitingResearcher);
    }

    private ResponseEntity<DataResult<Instructor>> create(Instructor instructor) {

        instructor.setId(null);
        Instructor createdInstructor = instructorService.create(instructor);

        // location header
        URI uri = MvcUriComponentsBuilder.fromMethodCall(
                on(InstructorController.class).getById(createdInstructor.getId())).buildAndExpand().toUri();

        return ResponseEntity.created(uri).body(DataResultHelper.ok(createdInstructor));
    }

    @PutMapping("/permanent-instructors/{id}")
    public ResponseEntity<Result> updatePermanentInstructor(@PathVariable long id, @RequestBody PermanentInstructor permanentInstructor) {

        permanentInstructor.setId(id);
        instructorService.updatePermanentInstructor(permanentInstructor);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/visiting-researchers/{id}")
    public ResponseEntity<Result> updateVisitingResearcher(@PathVariable long id, @RequestBody VisitingResearcher visitingResearcher) {

        visitingResearcher.setId(id);
        instructorService.updateVisitingResearcher(visitingResearcher);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable long id) {

        Instructor existsInstructor = instructorService.findById(id);

        // return 404 if student does not exist
        if (existsInstructor == null)
            return ResultResponseHelper.notFound(Student.class.getSimpleName(), Pair.of("id", id));

        instructorService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}

