package com.alice.atm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 2018/1/2.
 */

public class Tester {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        System.out.println(now.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(now));
        String s = "1997-10-01";
        try {
            Date birthday = sdf.parse(s);
            System.out.println(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
