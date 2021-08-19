package dev.patika.hw02.dataaccess.concretes;

import dev.patika.hw02.dataaccess.abstracts.BaseRepository;
import dev.patika.hw02.dataaccess.abstracts.VisitingResearcherRepository;
import dev.patika.hw02.entities.concretes.VisitingResearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class VisitingResearcherRepositoryImpl extends BaseRepository<VisitingResearcher, Long> implements VisitingResearcherRepository {

    @Autowired
    protected VisitingResearcherRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
