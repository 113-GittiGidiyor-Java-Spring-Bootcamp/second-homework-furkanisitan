package dev.patika.hw02.business.abstracts;

import dev.patika.hw02.entities.concretes.Instructor;
import dev.patika.hw02.entities.concretes.PermanentInstructor;
import dev.patika.hw02.entities.concretes.VisitingResearcher;

import java.util.List;

public interface InstructorService {

    List<Instructor> findAll();

    Instructor findById(Long id);

    Instructor findByPhoneNumber(String phoneNumber);

    Instructor createPermanentInstructor(PermanentInstructor permanentInstructor);

    Instructor createVisitingResearcher(VisitingResearcher visitingResearcher);

    Instructor updatePermanentInstructor(PermanentInstructor permanentInstructor);

    Instructor updateVisitingResearcher(VisitingResearcher visitingResearcher);

    void deleteById(Long id);
}
