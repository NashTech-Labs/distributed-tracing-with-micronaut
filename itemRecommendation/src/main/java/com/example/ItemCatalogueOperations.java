package com.example;

import org.reactivestreams.Publisher;

public interface ItemCatalogueOperations {
    Publisher<Item> findAll();
}
