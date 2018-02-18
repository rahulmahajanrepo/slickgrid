package com.raltd;

import com.raltd.model.Product;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by rahulmahajan on 18/02/2018.
 */
public class Utils {
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public static String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public static Date genDate() {
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
        Calendar cal=Calendar.getInstance();
        String str_date1="01-June-15 02:10:15";
        String str_date2="01-June-17 02:10:20";
        Long value1 = null;
        Long value2 = null;
        try {
            cal.setTime(formatter.parse(str_date1));
            value1 = cal.getTimeInMillis();
            cal.setTime(formatter.parse(str_date2));
            value2 = cal.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long value3 = (long)(value1 + Math.random()*(value2 - value1));
        cal.setTimeInMillis(value3);
        return cal.getTime();
    }

    public static float randFloat(float min, float max) {

        Random rand = new Random();

        float result = rand.nextFloat() * (max - min) + min;

        return result;

    }


    public static List<Product> getList(int num){
        List<Product> products = new ArrayList<>();
        List<String> cats = new ArrayList<>();
        cats.add("Soap");
        cats.add("TV");
        cats.add("Radio");
        cats.add("Pen");
        cats.add("Chair");
        cats.add("Computer");

        Random r = new Random();

        for(int index=0; index<num;index++){
            products.add(new Product(index+1, randomString(6), cats.get(r.nextInt(5)), genDate(), randomString(15), randFloat(5, 50)));
        }

        return products;
    }
}
