package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Flux;
import org.reactivestreams.Publisher;

@Controller("/items")
public class ItemController {

    private final ItemCatalogueOperations itemCatalogueOperations;
    private final ItemInventoryOperations itemInventoryOperations;

    public ItemController(ItemCatalogueOperations itemCatalogueOperations,
                          ItemInventoryOperations itemInventoryOperations) {
        this.itemCatalogueOperations = itemCatalogueOperations;
        this.itemInventoryOperations = itemInventoryOperations;
    }

    @Get
    public Publisher<ItemRecommendation> index() {

        return Flux.from(itemCatalogueOperations.findAll())
                .flatMap(b -> Flux.from(itemInventoryOperations.stock(b.getItemId()))
                        .filter(Boolean::booleanValue)
                        .map(rsp -> b)
                ).map(item -> new ItemRecommendation(item.getName()));
    }
}
