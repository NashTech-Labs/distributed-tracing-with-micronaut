package com.example;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class ItemsControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    public void testRetrieveBooks() {
        HttpRequest request = HttpRequest.GET("/items");
        List items = client.toBlocking().retrieve(request, Argument.listOf(Item.class));
        assertEquals(3, items.size());
        assertTrue(items.contains(new Item("1491950358", "Building Microservices")));
        assertTrue(items.contains(new Item("1680502395", "Release It!")));
    }
}
