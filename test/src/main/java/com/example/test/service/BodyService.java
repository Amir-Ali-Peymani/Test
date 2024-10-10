package com.example.test.service;

import com.example.test.entity.Body;

import java.util.List;
import java.util.UUID;

public interface BodyService {

    void saveBody(List<Body> bodies);

    List<Body> allBody();

    Body getBodyById(UUID id);

}
