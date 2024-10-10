package com.example.test.repository;

import com.example.test.entity.Body;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class BodyRepositoryImpl implements BodyRepository{

    private final EntityManager entityManager;

    @Autowired
    public BodyRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveBody(Body body) {
        entityManager.persist(body);
    }

    @Override
    public List<Body> allBody() {
        TypedQuery<Body> query = entityManager.createQuery("from Body ", Body.class);
        return query.getResultList();
    }

    @Override
    public Body getBodyById(UUID id) {
        return entityManager.find(Body.class, id);
    }
}
