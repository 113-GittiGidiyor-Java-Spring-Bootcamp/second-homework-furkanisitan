package dev.patika.hw02.dataaccess.concretes;

import dev.patika.hw02.dataaccess.abstracts.BaseRepository;
import dev.patika.hw02.dataaccess.abstracts.CourseRepository;
import dev.patika.hw02.entities.concretes.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
class CourseRepositoryImpl extends BaseRepository<Course, Long> implements CourseRepository {

    @Autowired
    protected CourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
