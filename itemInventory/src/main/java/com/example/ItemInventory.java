package com.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Introspected
public class ItemInventory {

    @NonNull
    @NotBlank
    private String itemId;

    @NonNull
    @NotNull
    private Integer stock;

    public ItemInventory() {}

    public ItemInventory(@NonNull @NotBlank String itemId, @NonNull @NotNull Integer stock) {
        this.itemId = itemId;
        this.stock = stock;
    }

    @NonNull
    public String getItemId() {
        return itemId;
    }

    public void setItemId(@NonNull String itemId) {
        this.itemId = itemId;
    }

    @NonNull
    public Integer getStock() {
        return stock;
    }

    public void setStock(@NonNull Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemInventory that = (ItemInventory) o;

        if (!itemId.equals(that.itemId)) return false;
        return stock.equals(that.stock);
    }

    @Override
    public int hashCode() {
        int result = itemId.hashCode();
        result = 31 * result + stock.hashCode();
        return result;
    }
}
