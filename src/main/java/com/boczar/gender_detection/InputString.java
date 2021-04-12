package com.boczar.gender_detection;

import java.util.Objects;

public class InputString {
    private String name;

    public InputString(String name) {
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
        if (!(o instanceof InputString)) return false;
        InputString that = (InputString) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "InputString{" +
                "name='" + name + '\'' +
                '}';
    }
}
