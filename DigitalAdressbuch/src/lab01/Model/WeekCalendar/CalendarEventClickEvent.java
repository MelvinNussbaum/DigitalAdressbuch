package lab01.Model.WeekCalendar;

import java.awt.*;

public class CalendarEventClickEvent extends AWTEvent {

	private static final long serialVersionUID = 2872743763685045950L;

	private CalendarEvent calendarEvent;

    public CalendarEventClickEvent(Object source, CalendarEvent calendarEvent) {
        super(source, 0);
        this.calendarEvent = calendarEvent;
    }

    public CalendarEvent getCalendarEvent() {
        return calendarEvent;
    }
}
