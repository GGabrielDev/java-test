package com.test.timezoneCalculator;

public class TimezoneResponse<R> {
    
    private final R r;

    public TimezoneResponse(R r) {
        this.r = r;
    }

    public R getResponse() {
        return r;
    }

}
