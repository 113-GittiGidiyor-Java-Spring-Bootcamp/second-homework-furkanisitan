package dev.patika.hw02.business.abstracts;

import dev.patika.hw02.entities.concretes.Course;
import dev.patika.hw02.entities.concretes.Instructor;

import java.util.List;

public interface InstructorService {

    List<Instructor> findAll();

    Instructor findById(Long id);

    Instructor create(Instructor instructor);

    Instructor update(Instructor instructor);

    void deleteById(Long id);
}
