package TestData;

import com.github.javafaker.Faker;
import java.time.Month;
import java.util.*;

public class GeneratorTestData {

    Faker faker = new Faker();
    public String[] generatedDate = generateDate();

    private static final Map<String, List<String>> STATE_TO_CITIES = new HashMap<>();

    static {
        STATE_TO_CITIES.put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
        STATE_TO_CITIES.put("Uttar Pradesh", Arrays.asList("Agra", "Lucknow", "Merrut"));
        STATE_TO_CITIES.put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
        STATE_TO_CITIES.put("Haryana", Arrays.asList("Karnal", "Panipat"));
    }

    public Map<String, String> stateCity = generatorStateCities();


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
                    state = stateCity.get("state"),
                    city = stateCity.get("city");


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

    public Map<String, String> generatorStateCities(){
        List<String> states = new ArrayList<>(STATE_TO_CITIES.keySet());
        String state = states.get(faker.number().numberBetween(0, states.size()));

        List<String> cities = STATE_TO_CITIES.get(state);
        String city = cities.get(faker.number().numberBetween(0, cities.size()));

        return Map.of("state",state,"city",city);
    }

}
