package com.demo.ss7.model;

public class DayTemperature {
    private Temperature Minimum;
    private Temperature Maximum;

    public Temperature getMinimum() {
        return Minimum;
    }

    public void setMinimum(Temperature minimum) {
        Minimum = minimum;
    }

    public Temperature getMaximum() {
        return Maximum;
    }

    public void setMaximum(Temperature maximum) {
        Maximum = maximum;
    }
}
