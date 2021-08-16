package dev.patika.hw02.business.concretes;

import dev.patika.hw02.business.abstracts.InstructorService;
import dev.patika.hw02.dataaccess.abstracts.InstructorRepository;
import dev.patika.hw02.entities.concretes.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorManager implements InstructorService {

    private final InstructorRepository repository;

    @Autowired
    public InstructorManager(InstructorRepository repository) {
        this.repository = repository;
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
    public Instructor create(Instructor instructor) {
        return repository.save(instructor);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return repository.update(instructor);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
