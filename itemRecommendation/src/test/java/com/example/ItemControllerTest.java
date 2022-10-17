package com.example;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class ItemControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @DisabledIfEnvironmentVariable(named = "CI", matches = "true")
    @Test
    public void testRetrieveItems() {
        List<ItemRecommendation> items = client.toBlocking()
                .retrieve(HttpRequest.GET("/items"), Argument.listOf(ItemRecommendation.class));
        assertEquals(1, items.size());
        assertEquals("Building Microservices", items.get(0).getName());
    }
}
