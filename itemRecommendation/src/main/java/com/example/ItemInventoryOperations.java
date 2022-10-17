package com.example;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import javax.validation.constraints.NotBlank;

public interface ItemInventoryOperations {
    Mono<Boolean> stock(@NotBlank String itemId);
}
