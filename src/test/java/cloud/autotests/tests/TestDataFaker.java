package cloud.autotests.tests;

import com.github.javafaker.Faker;

import java.io.File;
import java.util.Locale;

import static cloud.autotests.utils.RandomUtils.getRandomInt;

public class TestDataFaker {

    static Faker faker = new Faker(new Locale("en"));

    //Test data variables
    public static String firstName = faker.name().firstName(),//"Anton",
            lastName = faker.name().lastName(), //"Gorodetskiy",
            userEmail = faker.internet().emailAddress(),//"Anton.Gorodetskiy@mail.com",
            gender = "Male",
            userNumber = String.valueOf(getRandomInt(1000000000, 1999999999)),//"9296112233",
            dateOfBirthYear = "1982",
            dateOfBirthMonth = "August",
            subjectsInputFirst = "Social Studies",
            subjectsInputSecond = "Accounting",
            hobbiesFirst = "Sports",
            hobbiesSecond = "Music",
            fileWithPictureName = "AntonG.jpg",
            currentAddress = faker.address().streetAddress(),//"Karnal Bus Stand",
            state = "Haryana",
            city = "Karnal";
    public static Integer dateOfBirthDay = 19;
    public static File fileWithPicture = new File("src/test/resources/AntonG.jpg");

}
