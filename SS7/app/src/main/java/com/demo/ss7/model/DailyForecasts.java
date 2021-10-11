package com.demo.ss7.model;

public class DailyForecasts {
    private String Date;
    private DayTemperature Temperature;
    private Day Day;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public DayTemperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(DayTemperature temperature) {
        Temperature = temperature;
    }

    public com.demo.ss7.model.Day getDay() {
        return Day;
    }

    public void setDay(com.demo.ss7.model.Day day) {
        Day = day;
    }
}
