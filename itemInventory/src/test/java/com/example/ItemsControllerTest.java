package example.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class ItemsControllerTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    public void testItemsController() {
        HttpResponse<Boolean> rsp = httpClient.toBlocking().exchange(HttpRequest.GET("/items/stock/1491950358"), Boolean.class);
        assertEquals(rsp.status(), HttpStatus.OK);
        assertTrue(rsp.body());
    }

    @Test
    public void testItemsControllerWithNonExistingItemId() {
        HttpClientResponseException thrown = assertThrows(HttpClientResponseException.class, () -> {
            httpClient.toBlocking().exchange(HttpRequest.GET("/items/stock/XXXXX"), Boolean.class);
        });

        assertEquals(
                HttpStatus.NOT_FOUND,
                thrown.getResponse().getStatus()
        );

    }
}
