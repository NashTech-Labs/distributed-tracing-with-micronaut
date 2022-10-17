package com.example;

import io.micronaut.core.annotation.Introspected;

import java.util.Objects;

@Introspected
public class ItemRecommendation {
    private String name;

    public ItemRecommendation() {}

    public ItemRecommendation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemRecommendation that = (ItemRecommendation) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
