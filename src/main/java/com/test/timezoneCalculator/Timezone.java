package com.test.timezoneCalculator;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Timezone {

    private final String timezone;
    private final String time;
    private static final String OUTPUT_ZONE = "UTC";

    public Timezone(String inputTime, Integer inputTimezone) {
        this.timezone = OUTPUT_ZONE;
        this.time = calculateOffsetOfTime(inputTime, inputTimezone);
    }

    private String calculateOffsetOfTime(String time, Integer timezone)  {
        String output, strOffset = new String();

        strOffset = (timezone > -10 && timezone < 0)
            ? String.format("%03d", timezone) 
            : String.format("%02d", timezone);
        strOffset = (timezone >= 0)
            ? String.format("+%s:00", strOffset)
            : String.format("%s:00", strOffset);

        ZoneId inputZone = ZoneId.of(String.format("UTC%s", strOffset));
        ZonedDateTime inputTime = LocalDateTime.parse(String.format("2020-01-01T%s", time), 
            DateTimeFormatter.ISO_DATE_TIME).atZone(inputZone);

        ZoneId outputZone = ZoneId.of(OUTPUT_ZONE);
        ZonedDateTime outputTime = inputTime.withZoneSameInstant(outputZone);

        DateTimeFormatter outputFormat = DateTimeFormatter.ISO_LOCAL_TIME;
        output = outputFormat.format(outputTime);

        return output;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getTime() {
        return time;
    }

}