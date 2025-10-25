package testData;

import com.github.javafaker.Faker;
import java.time.Month;
import java.util.*;

public class GeneratorTestData {

    static Faker faker = new Faker();
    public String[] generatedDate = generateDate();

    public String
                    firstName = faker.name().firstName(),
                    lastName = faker.name().lastName(),
                    email = faker.internet().emailAddress(),
                    address = faker.address().streetAddress(),
                    phoneNumber = faker.phoneNumber().subscriberNumber(10),
                    gender = faker.options().option("Male", "Female", "Other"),
                    subject = faker.options().option("Maths", "Hindi", "Biology", "Accounting", "Chemistry"),
                    hobbies = faker.options().option("Sports", "Reading", "Music"),
                    picture = faker.options().option("pict/pict1.jpg", "pict/pict2.jpg", "pict/pict3.jpg"),
                    day = generatedDate[0],
                    month = generatedDate[1],
                    year = generatedDate[2],
                    state = getRandomState(),
                    city = selectCity(state);


    public String randomString(int length){
        return faker.lorem().characters(length);
    }

    public String[] generateDate() {
        int year = faker.number().numberBetween(1999, 2010);
        int monthInt =  faker.number().numberBetween(1, 12);
        String month = Month.of(monthInt).getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH);
        int maxDays = java.time.Month.of(monthInt)
                .length(java.time.Year.isLeap(year));
        int day = faker.number().numberBetween(1, maxDays);

        return new String[]{
                String.format("%02d", day),
                String.format(month),
                String.valueOf(year)
        };
    }


    public static String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }
    public static String selectCity(String state) {
        return switch (state) {

            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

}
