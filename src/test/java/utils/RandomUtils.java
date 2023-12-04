package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static Faker faker = new Faker(new Locale("en"));
    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomString(int length) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);

        return values[index];
    }


    public static String getFirstName(){

        return faker.name().firstName();
    }

    public static String getLastName(){

        return faker.name().lastName();
    }

    public static String getEmail(){

        return faker.internet().emailAddress();
    }

    public static String getGender(){

        return faker.demographic().sex();
    }

    public static String getCurrentAddress(){

        return faker.address().fullAddress();
    }
}
