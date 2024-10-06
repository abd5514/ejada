package org.utils.generator;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class RandomDataGenerator {

    public static int randomNumber(int upperbound){

        Random randValue = new Random();
        int value = randValue.nextInt(upperbound);
        if (value == 0)
            return randValue.nextInt(upperbound);
        else
            return value;
    }

    public static String getSaltString(int stringLength) {

        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < stringLength) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    public static String getTomorrowDate(){
        LocalDate today = LocalDate.now();
        String tomorrow = (today.plusDays(1)).format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        return tomorrow;
    }
}
