package com.example.test.controller;

import com.example.test.entity.Body;
import com.example.test.exception.BodyErrorResponse;
import com.example.test.exception.BodyNotFoundException;
import com.example.test.service.BodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BodyController {

    private final BodyService bodyService;

    @Autowired
    public BodyController(BodyService bodyService) {
        this.bodyService = bodyService;
    }

    @PostMapping("/test/{dynamic_number}")
    public Body createBody(@RequestBody List<Body> bodies, @PathVariable int dynamic_number,
                           @RequestHeader UUID bodyId) {
        bodyService.saveBody(bodies);
        Body returnBody = null;
        for (Body body : bodyService.allBody()) {
            if (body.getBodyId().equals(bodyId) && body.getBodyIdNumber()== dynamic_number) {
                returnBody=  body;
            }
        }
        if (returnBody == null) {
            throw new BodyNotFoundException("not found");
        }
        return returnBody;
    }

    @ExceptionHandler
    public ResponseEntity<BodyErrorResponse> handleException(BodyNotFoundException e){

        BodyErrorResponse bodyErrorResponse = new BodyErrorResponse();

        bodyErrorResponse.setMessage(e.getMessage());

        return new ResponseEntity<>(bodyErrorResponse, HttpStatus.NOT_FOUND);
    }

}