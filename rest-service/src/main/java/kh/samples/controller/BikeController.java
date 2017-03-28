package kh.samples.controller;

import kh.samples.model.Bike;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "bikes", method = RequestMethod.POST)
    public Bike create(@RequestBody Bike bike) {
        return BikeCollection.add(bike);
    }

    @RequestMapping(value = "bikes/{serialNumber}", method = RequestMethod.GET)
    public Bike get(@PathVariable String serialNumber) {
        return BikeCollection.get(serialNumber);
    }

    @RequestMapping(value = "bikes/{serialNumber}", method = RequestMethod.PUT)
    public Bike update(@PathVariable String serialNumber, @RequestBody Bike bike) {
        Bike updatedBike = BikeCollection.update(serialNumber, bike);
        if (updatedBike == null) {
            throw new BikeNotFoundException(String.format("Bike with serial number %s not exists.", serialNumber));
        }

        return updatedBike;
    }

    @RequestMapping(value = "bikes/{serialNumber}", method = RequestMethod.DELETE)
    public Bike delete(@PathVariable String serialNumber) {
        Bike deletedBike = BikeCollection.delete(serialNumber);
        if (deletedBike == null) {
            throw new BikeNotFoundException(String.format("Bike with serial number %s not exists.", serialNumber));
        }

        return deletedBike;
    }

}
