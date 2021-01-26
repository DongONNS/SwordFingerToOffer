package edu.csu.leetcode.Top300;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class TimeStampToDateTime {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date(1611645215238l));
        System.out.println(date);
    }
}
