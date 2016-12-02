package edu.hansung.ait.wediary.Week;

/**
 * Created by tickt on 2016-12-01.
 */

public class WeekDate {
    private int weekDate;
    private String weekText;

    public WeekDate(int weekDate, String weekText) {
        this.weekDate = weekDate;
        this.weekText = weekText;
    }

    public int getWeekDate() {
        return weekDate;
    }

    public String getWeekText() {
        return weekText;
    }
}
