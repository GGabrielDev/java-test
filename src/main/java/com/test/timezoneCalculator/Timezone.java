package com.test.timezoneCalculator;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Timezone {

    private final String offset;
    private final String outputTime;

    public Timezone(String time, Integer offset) {
        this.offset = "UTC" ;
        this.outputTime = calcTime(time, offset);
    }

    private String calcTime(String time, Integer offset)  {
        String output, strOffset = new String();

        strOffset = (offset > -10 && offset < 0)
            ? String.format("%03d", offset) 
            : String.format("%02d", offset);
        strOffset = (offset >= 0)
            ? String.format("+%s:00", strOffset)
            : String.format("%s:00", strOffset);

        ZoneId inputZone = ZoneId.of(String.format("UTC%s", strOffset));
        ZonedDateTime inputTime = LocalDateTime.parse(String.format("2020-01-01T%s", time), 
            DateTimeFormatter.ISO_DATE_TIME).atZone(inputZone);

        ZoneId outputZone = ZoneId.of("UTC");
        ZonedDateTime outputTime = inputTime.withZoneSameInstant(outputZone);

        DateTimeFormatter outputFormat = DateTimeFormatter.ISO_LOCAL_TIME;
        output = outputFormat.format(outputTime);

        return output;
    }

    public String getOffset() {
        return offset;
    }

    public String getOutputTime() {
        return outputTime;
    }

}