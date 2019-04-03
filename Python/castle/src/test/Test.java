package test;

import java.math.BigInteger;

import java.time.*;
import static java.lang.System.out;


public class Test {
    public static void main(String[] args){
        LocalDate date = java.time.LocalDate.of(2019,12,31);
        System.out.println(date);
        int year = date.getYear();
        int month = date.getMonth().getValue();
        int day = date.getDayOfMonth();
        int dateofweek = date.getDayOfWeek().getValue();
        out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(dateofweek);

        BigInteger bi = BigInteger.valueOf(8912123);
        BigInteger mod = BigInteger.valueOf(100000007);
        bi = bi.multiply(bi);
        bi = bi.multiply(bi);
        bi = bi.multiply(bi);
        bi = bi.multiply(bi);
        bi = bi.multiply(bi);
        System.out.println(bi);
        bi = bi.mod(mod);
        System.out.println(bi);



    }
}

