package com.test.timezoneCalculator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimezoneController {

    @PostMapping("/")
    public Timezone timezoneCalculate(@RequestBody Timezone timezone){ 
        return new TimezoneResponse(timezone);
    } 
}