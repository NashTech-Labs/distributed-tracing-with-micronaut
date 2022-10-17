//tag::packageandimports[]
package com.example;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Recoverable;
import org.reactivestreams.Publisher;
//end::packageandimports[]

//tag::harcoded[]
@Client("http://localhost:8081") // <1>
@Recoverable(api = ItemCatalogueOperations.class)
//end::harcoded[]
//tag::clazz[]
public interface ItemCatalogueClient extends ItemCatalogueOperations {

    @Get("/items")
    Publisher<Item> findAll();
}
//end::clazz[]
