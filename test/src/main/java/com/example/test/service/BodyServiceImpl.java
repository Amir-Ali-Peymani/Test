package com.example.test.service;

import com.example.test.entity.Body;
import com.example.test.repository.BodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class BodyServiceImpl implements BodyService{

    private final BodyRepository bodyRepository;

    @Autowired
    public BodyServiceImpl(BodyRepository bodyRepository) {
        this.bodyRepository = bodyRepository;
    }

    @Override
    @Transactional
    public void saveBody(List<Body> bodies) {
        for (Body body : bodies) {
            if (body.getBodyId() != null) {
                Body existingBody = bodyRepository.getBodyById(body.getBodyId());
                if (existingBody != null) {
                    // Update existing body fields
                    existingBody.setBodyIdNumber(body.getBodyIdNumber());
                    existingBody.setName(body.getName());
                    // Save the updated body directly
                    bodyRepository.saveBody(existingBody);
                } else {
                    // Save new body directly
                    bodyRepository.saveBody(body);
                }
            } else {
                // Save new body without BodyId
                bodyRepository.saveBody(body);
            }
        }
    }

    @Override
    public List<Body> allBody() {
        return bodyRepository.allBody();
    }

    @Override
    public Body getBodyById(UUID id) {
        return bodyRepository.getBodyById(id);
    }
}
