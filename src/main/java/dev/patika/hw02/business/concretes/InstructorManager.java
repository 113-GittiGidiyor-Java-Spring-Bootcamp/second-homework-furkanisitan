package dev.patika.hw02.business.concretes;

import dev.patika.hw02.business.abstracts.InstructorService;
import dev.patika.hw02.core.exceptions.EntityNotExistsException;
import dev.patika.hw02.core.exceptions.UniqueConstraintViolationException;
import dev.patika.hw02.dataaccess.abstracts.InstructorRepository;
import dev.patika.hw02.dataaccess.abstracts.PermanentInstructorRepository;
import dev.patika.hw02.dataaccess.abstracts.VisitingResearcherRepository;
import dev.patika.hw02.entities.concretes.Instructor;
import dev.patika.hw02.entities.concretes.PermanentInstructor;
import dev.patika.hw02.entities.concretes.VisitingResearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class InstructorManager implements InstructorService {

    private final InstructorRepository repository;
    private final PermanentInstructorRepository permanentInstructorRepository;
    private final VisitingResearcherRepository visitingResearcherRepository;

    @Autowired
    public InstructorManager(InstructorRepository repository, PermanentInstructorRepository permanentInstructorRepository, VisitingResearcherRepository visitingResearcherRepository) {
        this.repository = repository;
        this.permanentInstructorRepository = permanentInstructorRepository;
        this.visitingResearcherRepository = visitingResearcherRepository;
    }

    @Override
    public List<Instructor> findAll() {
        return repository.findAll();
    }

    @Override
    public Instructor findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Instructor findByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Instructor createPermanentInstructor(PermanentInstructor permanentInstructor) {

        validatePhoneNumberIsUnique(permanentInstructor.getPhoneNumber());
        return permanentInstructorRepository.save(permanentInstructor);
    }

    @Override
    public Instructor createVisitingResearcher(VisitingResearcher visitingResearcher) {

        validatePhoneNumberIsUnique(visitingResearcher.getPhoneNumber());
        return visitingResearcherRepository.save(visitingResearcher);
    }

    @Override
    public Instructor updatePermanentInstructor(PermanentInstructor permanentInstructor) {

        // Check if the PermanentInstructor is exists
        if (permanentInstructorRepository.findById(permanentInstructor.getId()) == null)
            throw new EntityNotExistsException("PermanentInstructor", Pair.of("id", permanentInstructor.getId()));

        return update(permanentInstructor);
    }

    @Override
    public Instructor updateVisitingResearcher(VisitingResearcher visitingResearcher) {

        // Check if the VisitingResearcher is exists
        if (visitingResearcherRepository.findById(visitingResearcher.getId()) == null)
            throw new EntityNotExistsException("VisitingResearcher", Pair.of("id", visitingResearcher.getId()));

        return update(visitingResearcher);
    }

    private Instructor update(Instructor instructor) {

        validatePhoneNumberIsUniqueForUpdate(instructor.getPhoneNumber(), instructor.getId());
        return repository.update(instructor);
    }

    @Override
    public void deleteById(Long id) {

        // Check if the Instructor is exists
        Instructor instructor = findById(id);
        if (instructor == null)
            throw new EntityNotExistsException("Instructor", Pair.of("id", id));

        instructor.clearCourses();
        repository.delete(instructor);
    }

    //region validators
    /**
     * Checks if {@literal phoneNumber} is unique.
     *
     * @param phoneNumber unique value to validate.
     * @throws UniqueConstraintViolationException if {@literal phoneNumber} is not unique.
     */
    private void validatePhoneNumberIsUnique(String phoneNumber) {
        Instructor existsInstructor = findByPhoneNumber(phoneNumber);
        if (existsInstructor != null)
            throw new UniqueConstraintViolationException("phoneNumber", phoneNumber);
    }

    /**
     * Checks if {@literal phoneNumber} is unique for update operation.
     *
     * @param phoneNumber  unique value to validate.
     * @param instructorId the id of the instructor to be updated.
     * @throws UniqueConstraintViolationException if {@literal phoneNumber} is not unique.
     */
    private void validatePhoneNumberIsUniqueForUpdate(String phoneNumber, Long instructorId) {
        Instructor existsInstructor = findByPhoneNumber(phoneNumber);
        if (existsInstructor != null && !Objects.equals(existsInstructor.getId(), instructorId))
            throw new UniqueConstraintViolationException("phoneNumber", phoneNumber);
    }
    //endregion
}
