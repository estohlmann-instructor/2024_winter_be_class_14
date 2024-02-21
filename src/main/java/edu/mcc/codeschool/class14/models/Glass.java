package edu.mcc.codeschool.class14.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class Glass {
    @Max(64)
    @NotNull
    int ounces;
    @NotNull
    String shape;
    String material;

    public int getOunces() {
        return ounces;
    }

    public Glass setOunces(int ounces) {
        this.ounces = ounces;
        return this;
    }

    public String getShape() {
        return shape;
    }

    public Glass setShape(String shape) {
        this.shape = shape;
        return this;
    }

    public String getMaterial() {
        return material;
    }

    public Glass setMaterial(String material) {
        this.material = material;
        return this;
    }
}
