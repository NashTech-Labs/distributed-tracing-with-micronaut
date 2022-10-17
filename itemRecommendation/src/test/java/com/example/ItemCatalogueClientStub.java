package com.example;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.retry.annotation.Fallback;
import reactor.core.publisher.Flux;
import org.reactivestreams.Publisher;
import jakarta.inject.Singleton;

@Requires(env = Environment.TEST)
@Fallback
@Singleton
public class ItemCatalogueClientStub implements ItemCatalogueOperations {

    @Override
    public Publisher<Item> findAll() {
        Item buildingMicroservices = new Item("1491950358", "Building Microservices");
        Item releaseIt = new Item("1680502395", "Release It!");
        return Flux.just(buildingMicroservices, releaseIt);
    }
}
