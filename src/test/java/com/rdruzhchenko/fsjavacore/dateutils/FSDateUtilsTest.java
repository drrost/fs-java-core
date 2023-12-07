package com.rdruzhchenko.fsjavacore.dateutils;

import com.rdruzhchenko.fsjavacore.FSDateUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FSDateUtilsTest {

    @Test
    void testDateByAddDays() {
        // Given
        String date = "19.04.2022";

        // When
        String yesterday = FSDateUtils.dateByAddDays(date, -1);

        // Then
        assertEquals("18.04.2022", yesterday);
    }

    @Test
    void isDateLessThan_LessDay() {
        // Given
        String date1 = "21.06.2022";
        String date2 = "20.06.2022";

        // When
        boolean result = FSDateUtils.isDateLessThan(date1, date2);

        // Then
        assertFalse(result);
    }

    @Test
    void isDateLessThan_LessMonth() {
        // Given
        String date1 = "21.06.2022";
        String date2 = "21.05.2022";

        // When
        boolean result = FSDateUtils.isDateLessThan(date1, date2);

        // Then
        assertFalse(result);
    }

    @Test
    void isDateLessThan_LessYear() {
        // Given
        String date1 = "21.06.2022";
        String date2 = "21.06.2021";

        // When
        boolean result = FSDateUtils.isDateLessThan(date1, date2);

        // Then
        assertFalse(result);
    }

    @Test
    void isDateLessThan_GreaterDay() {
        // Given
        String date1 = "21.06.2022";
        String date2 = "22.06.2022";

        // When
        boolean result = FSDateUtils.isDateLessThan(date1, date2);

        // Then
        assertTrue(result);
    }

    @Test
    void isDateLessThan_GreaterMonth() {
        // Given
        String date1 = "21.06.2022";
        String date2 = "21.07.2022";

        // When
        boolean result = FSDateUtils.isDateLessThan(date1, date2);

        // Then
        assertTrue(result);
    }

    @Test
    void isDateLessThan_GreaterYear() {
        // Given
        String date1 = "21.06.2022";
        String date2 = "21.06.2023";

        // When
        boolean result = FSDateUtils.isDateLessThan(date1, date2);

        // Then
        assertTrue(result);
    }

    @Test
    void isDateLessThan_Equal() {
        // Given
        String date1 = "21.06.2022";
        String date2 = "21.06.2022";

        // When
        boolean result = FSDateUtils.isDateLessThan(date1, date2);

        // Then
        assertFalse(result);
    }

    //
    @Test
    void isDateLessThan_LessDay2() {
        // Given
        String dateOut = "29.04.2022";
        String dateX = "23.06.2022";

        // When
        boolean result = FSDateUtils.isDateLessThan(dateOut, dateX);

        // Then
        assertTrue(result);
    }

    //
    @Test
    void isDateLessThan_LessDay_01_07() {
        // Given
        String dateOut = "01.07.2022";
        String dateX = "23.06.2022";

        // When
        boolean result = FSDateUtils.isDateLessThan(dateOut, dateX);

        // Then
        assertFalse(result);
    }

    // Week start
    @Test
    void getWeekStart_28022022() {
        // Given
        String date = "26.02.2022";

        // When
        var weekStart = FSDateUtils.getWeekStart(date);

        // Then
        assertEquals("21.02.2022", weekStart);
    }

    @Test
    void getWeekStart_27022022() {
        // Given
        String date = "28.02.2022";

        // When
        var weekStart = FSDateUtils.getWeekStart(date);

        // Then
        assertEquals("28.02.2022", weekStart);
    }

    @Test
    void getWeekStart_01032022() {
        // Given
        String date = "01.03.2022";

        // When
        var weekStart = FSDateUtils.getWeekStart(date);

        // Then
        assertEquals("28.02.2022", weekStart);
    }

    @Test
    void getWeekStart_04032022() {
        // Given
        String date = "04.03.2022";

        // When
        var weekStart = FSDateUtils.getWeekStart(date);

        // Then
        assertEquals("28.02.2022", weekStart);
    }

    @Test
    void getWeekStart_06032022() {
        // Given
        String date = "06.03.2022";

        // When
        var weekStart = FSDateUtils.getWeekStart(date);

        // Then
        assertEquals("28.02.2022", weekStart);
    }

    // Week end
    @Test
    void getWeekEnd_28022022() {
        // Given
        var date = "28.02.2022";

        // When
        var weekEnd = FSDateUtils.getWeekEnd(date);

        // Then
        assertEquals("06.03.2022", weekEnd);
    }

    @Test
    void getWeekEnd_06032022() {
        // Given
        var date = "06.03.2022";

        // When
        var weekEnd = FSDateUtils.getWeekEnd(date);

        // Then
        assertEquals("06.03.2022", weekEnd);
    }

    @Test
    void getWeekEnd_01032022() {
        // Given
        var date = "01.03.2022";

        // When
        var weekEnd = FSDateUtils.getWeekEnd(date);

        // Then
        assertEquals("06.03.2022", weekEnd);
    }

    @Test
    void getWeekEnd_27022022() {
        // Given
        var date = "27.02.2022";

        // When
        var weekEnd = FSDateUtils.getWeekEnd(date);

        // Then
        assertEquals("27.02.2022", weekEnd);
    }

    // Time
    @Test
    void getTimeFromDate_01052023_2320() {
        // Given
        var date = "27.02.2022 23:20";

        // When
        var time = FSDateUtils.getTimeFromDateTime(date);

        // Then
        assertEquals("23:20", time);
    }

    @Test
    void plus5minutesToTime_2320() {
        // Given
        var date = "23:20";

        // When
        var time = FSDateUtils.plusMinutesToTime(date, 5);

        // Then
        assertEquals("23:25", time);
    }

    @Test
    void isTimeLessThan_Less() {
        // Given
        String time1 = "15:00";
        String time2 = "15:15";

        // When
        boolean result = FSDateUtils.isTimeLessThan(time1, time2);

        // Then
        assertTrue(result);
    }

    @Test
    void isTimeLessThan_Greater() {
        // Given
        String time1 = "23:37";
        String time2 = "15:15";

        // When
        boolean result = FSDateUtils.isTimeLessThan(time1, time2);

        // Then
        assertFalse(result);
    }

    @Test
    void isTimeLessThan_Equal() {
        // Given
        String time = "23:37";

        // When
        boolean result = FSDateUtils.isTimeLessThan(time, time);

        // Then
        assertFalse(result);
    }

    @Test
    void isTimeGreaterThan_Less() {
        // Given
        String time1 = "15:00";
        String time2 = "15:15";

        // When
        boolean result = FSDateUtils.isTimeGreaterThan(time1, time2);

        // Then
        assertFalse(result);
    }

    @Test
    void isTimeGreaterThan_Greater() {
        // Given
        String time1 = "23:37";
        String time2 = "15:15";

        // When
        boolean result = FSDateUtils.isTimeGreaterThan(time1, time2);

        // Then
        assertTrue(result);
    }

    @Test
    void isTimeGreaterThan_Equal() {
        // Given
        String time = "23:37";

        // When
        boolean result = FSDateUtils.isTimeGreaterThan(time, time);

        // Then
        assertFalse(result);
    }

    @Test
    void isTimeGreaterThan_EqualDifferentObjects() {
        // Given
        String time1 = "23:37";
        String time2 = "23:3";
        time2 += "7";

        // When
        boolean result = FSDateUtils.isTimeGreaterThan(time1, time2);

        // Then
        assertFalse(result);
    }
}