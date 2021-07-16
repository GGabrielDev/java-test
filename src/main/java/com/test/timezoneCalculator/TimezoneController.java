package com.test.timezoneCalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimezoneController {
    @GetMapping("/")
    public Timezone timezone (
        @RequestParam(value = "time", defaultValue = "00:00:00") String time,
        @RequestParam(value = "offset", defaultValue = "0") Integer offset)
    {
        return new Timezone(time, offset);
    }
}