package com.aops.main.JavaTesting;

import java.awt.Color;
import java.util.Objects;

public class POJO {

    private int number;
    public String string;
    private Color color;

    public POJO(int number, String string, Color color) {
        this.number = number;
        this.string = string;
        this.color = color;
    }

    public POJO(String string, Color color) {
        this.string = string;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getString() {
        return string;
    }

    private void setString(String string) {
        this.string = string;
    }

    public Color getColor() {
        return color;
    }
    
    public boolean equals(POJO o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POJO POJO = (POJO) o;
        return number == POJO.number && string.equals(o.string) && color.equals(o.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, string, color);
    }

    @Override
    public String toString() {
        return "POJO{" +
                "number=" + number +
                ", string='" + string + '\'' +
                ", color=" + color +
                '}';
    }
}
