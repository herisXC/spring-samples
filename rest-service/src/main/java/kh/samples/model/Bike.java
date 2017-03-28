package kh.samples.model;

import lombok.Data;

/**
 * Created by krzysiek on 27.03.17.
 */
@Data
public class Bike {

    private String serialNumber;

    private String brand;

    private String model;

    private BikeType type;

    private float weight;

}
