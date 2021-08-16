package dev.patika.hw02.business.concretes;

import dev.patika.hw02.business.abstracts.CourseService;
import dev.patika.hw02.dataaccess.abstracts.CourseRepository;
import dev.patika.hw02.entities.concretes.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseManager implements CourseService {

    private final CourseRepository repository;

    @Autowired
    public CourseManager(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Course create(Course course) {
        return repository.save(course);
    }

    @Override
    public Course update(Course course) {
        return repository.update(course);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
