package edu.csu.swordFingerOffer.secondPractice;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTransport {
    public static void main(String[] args) throws ParseException {
        // 2021-03-04 与 当前时间的凌晨比较
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();

        String nowString = dateFormat.format(now);
        ParsePosition parsePosition = new ParsePosition(8);

        Date currentTime = dateFormat.parse(nowString, parsePosition);

        Date latestDay = dateFormat.parse("2021-03-04");

        if (latestDay.before(currentTime)) {
            System.out.println("当前时间参数错误");
        }

    }
}
