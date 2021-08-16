package dev.patika.hw02.dataaccess.concretes;

import dev.patika.hw02.dataaccess.abstracts.BaseRepository;
import dev.patika.hw02.dataaccess.abstracts.InstructorRepository;
import dev.patika.hw02.entities.concretes.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class InstructorRepositoryImpl extends BaseRepository<Instructor, Long> implements InstructorRepository {

    @Autowired
    protected InstructorRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
