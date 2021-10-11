package com.demo.ss7.model;

import java.util.List;

public class FiveDay {
    private List<DailyForecasts> DailyForecasts;

    public List<com.demo.ss7.model.DailyForecasts> getDailyForecasts() {
        return DailyForecasts;
    }

    public void setDailyForecasts(List<com.demo.ss7.model.DailyForecasts> dailyForecasts) {
        DailyForecasts = dailyForecasts;
    }
}
