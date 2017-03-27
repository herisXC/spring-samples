package kh.samples.controller;

import kh.samples.model.Bike;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by krzysiek on 27.03.17.
 */
@RestController
@RequestMapping("api/v1")
public class BikeController {

    @RequestMapping(value = "bikes", method = RequestMethod.GET)
    public List<Bike> list() {
        return BikeCollection.list();
    }

}
