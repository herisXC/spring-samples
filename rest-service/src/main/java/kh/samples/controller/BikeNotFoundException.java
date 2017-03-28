package kh.samples.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by krzysiek on 28.03.17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Bike not exists.")
public class BikeNotFoundException extends RuntimeException {

    public BikeNotFoundException(String message) {
        super(message);
    }
}
