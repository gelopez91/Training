package com.sdc.controller;

import com.sdc.controller.BackEntities.ActorB;
import com.sdc.controller.BackEntities.Movie;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MovieDAOImp implements MovieDAO {

    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    public Movie getMovie(Long movieId) throws DataAccessException {
        return getEntityManager().find(Movie.class, movieId);
    }

    @Transactional (propagation = Propagation.REQUIRED)
    public String addActor(ActorB actor){
        try {
            getEntityManager().persist(actor);
            return "Exito";
        }
        catch (Exception e){
            return ""+e;
        }
    }
}