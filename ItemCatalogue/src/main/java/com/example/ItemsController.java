package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Arrays;
import java.util.List;

@Controller("/items")
public class ItemsController {

    @Get
    public List<Item> index() {
        Item buildingMicroservices = new Item("1491950358", "Building Microservices");
        Item releaseIt = new Item("1680502395", "Release It!");
        Item cidelivery = new Item("0321601912", "Continuous Delivery:");
        return Arrays.asList(buildingMicroservices, releaseIt, cidelivery);
    }
}
