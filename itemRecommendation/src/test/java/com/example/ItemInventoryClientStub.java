package com.example;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.retry.annotation.Fallback;
import org.reactivestreams.Publisher;
import jakarta.inject.Singleton;
import javax.validation.constraints.NotBlank;
import reactor.core.publisher.Mono;

@Requires(env = Environment.TEST)
@Fallback
@Singleton
public class ItemInventoryClientStub implements ItemInventoryOperations {

    @Override
    public Mono<Boolean> stock(@NotBlank String itemId) {
        if (itemId.equals("1491950358")) {
            return Mono.just(Boolean.TRUE);

        } else if (itemId.equals("1680502395")) {
            return Mono.just(Boolean.FALSE);
        }
        return Mono.empty();
    }
}
