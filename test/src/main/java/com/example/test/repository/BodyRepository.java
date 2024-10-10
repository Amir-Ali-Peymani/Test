package com.example.test.repository;


import com.example.test.entity.Body;

import java.util.List;
import java.util.UUID;

public interface BodyRepository {
    void saveBody(Body body);

    List<Body> allBody();

    Body getBodyById(UUID id);

}
