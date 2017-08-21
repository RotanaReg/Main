package com.rotanareg.skolan.course;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DateB {

    public static Date date(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

