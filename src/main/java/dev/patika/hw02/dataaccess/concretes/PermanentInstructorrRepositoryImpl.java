package dev.patika.hw02.dataaccess.concretes;

import dev.patika.hw02.dataaccess.abstracts.BaseRepository;
import dev.patika.hw02.dataaccess.abstracts.PermanentInstructorRepository;
import dev.patika.hw02.entities.concretes.PermanentInstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PermanentInstructorrRepositoryImpl extends BaseRepository<PermanentInstructor, Long> implements PermanentInstructorRepository {

    @Autowired
    protected PermanentInstructorrRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
