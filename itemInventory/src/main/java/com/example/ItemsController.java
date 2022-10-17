package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.SpanTag;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Controller("/items")
public class ItemsController {

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/stock/{itemId}")
    @ContinueSpan // <1>
    public Boolean stock(@SpanTag("stock.itemId") @NotBlank String itemId) { // <2>
        return itemInventoryByItemId(itemId).map(bi -> bi.getStock() > 0).orElse(null);
    }

    private Optional<ItemInventory> itemInventoryByItemId(String itemId) {
        if (itemId.equals("1491950358")) {
            return Optional.of(new ItemInventory(itemId, 4));

        } else if (itemId.equals("1680502395")) {
            return Optional.of(new ItemInventory(itemId, 5));
        }
        return Optional.empty();
    }
}
