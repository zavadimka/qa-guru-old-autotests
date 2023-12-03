package tests;

import org.junit.jupiter.api.Test;

import pages.RegistrationPage;

public class RegistrationFormTestsWithPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        String pageAddress = "/automation-practice-form";
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String email = "ivanov@ivanov.com";
        String gender = "Male";
        String phoneNumber = "0123456789";
        String dayOfBirthday = "02";
        String monthOfBirthday = "June";
        String yearOfBirthday = "1985";
        String subject1 = "Maths";
        String subject2 = "English";
        String hobby = "Sports";
        String imageName = "testImage.png";
        String imagePath = "img/testImage.png";
        String currentAddress = "Montenegro";
        String state = "NCR";
        String city = "Delhi";

        registrationPage.openPage(pageAddress)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDateOfBirthday(dayOfBirthday, monthOfBirthday, yearOfBirthday)
                .setSubjects(subject1, subject2)
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
                .successfulFormFilling("Date of Birth", dayOfBirthday + " " + monthOfBirthday + "," + yearOfBirthday)
                .successfulFormFilling("Subjects", subject1 + ", " + subject2)
                .successfulFormFilling("Hobbies", hobby)
                .successfulFormFilling("Picture", imageName)
                .successfulFormFilling("Address", currentAddress)
                .successfulFormFilling("State and City", state + " " + city)
                .successfulReturnToForm();

    }
}