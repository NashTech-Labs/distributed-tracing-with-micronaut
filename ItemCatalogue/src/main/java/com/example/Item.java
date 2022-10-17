package com.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.NotBlank;

@Introspected
public class Item {

    @NonNull
    @NotBlank
    private String itemId;
    @NonNull
    @NotBlank

    private String name;

    public Item() {}

    public Item(@NonNull @NotBlank String itemId, @NonNull @NotBlank String name) {
        this.itemId = itemId;
        this.name = name;
    }

    @NonNull
    public String getItemId() { return itemId; }

    public void setItemId(String itemId) { this.itemId = itemId; }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!itemId.equals(item.itemId)) return false;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        int result = itemId.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
