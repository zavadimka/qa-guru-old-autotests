package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;

public class RegistrationFormTestsWithRandomDataUtils extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        String[] genders = new String[] {"Male", "Female", "Other"};
        String[] subjects = new String[] {"Maths", "English", "Commerce", "Economics"};
        String[] hobbies = new String[] {"Sports", "Reading", "Music"};

        String pageAddress = "/automation-practice-form",
                firstName = getRandomString(10),
                lastName = getRandomString(10),
                email = getRandomString(10) + "@testmail.com",
                gender = getRandomItemFromArray(genders),
                phoneNumber = "382" + getRandomInt(6000000, 9999999),
                dayOfBirthday = "02",
                subject = getRandomItemFromArray(subjects),
                hobby = getRandomItemFromArray(hobbies),
                imageName = "testImage.png",
                imagePath = "img/testImage.png",
                currentAddress = getRandomString(10),
                state = "NCR",
                city = "Delhi";

        registrationPage.openPage(pageAddress)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDateOfBirthday(dayOfBirthday)
                .setSubjects(subject)
                .setHobby(hobby)
                .addImage(imagePath)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitRegistration();

        registrationPage.successfulSubmit()
                .successfulFormFilling("Student Name", firstName + " " + lastName)
                .successfulFormFilling("Student Email", email)
                .successfulFormFilling("Gender", gender)
                .successfulFormFilling("Mobile", phoneNumber)
                .successfulFormFilling("Subjects", subject)
                .successfulFormFilling("Hobbies", hobby)
                .successfulFormFilling("Picture", imageName)
                .successfulFormFilling("Address", currentAddress)
                .successfulFormFilling("State and City", state + " " + city)
                .successfulReturnToForm();

    }
}