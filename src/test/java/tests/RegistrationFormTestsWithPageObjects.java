package tests;

import org.junit.jupiter.api.Test;

import pages.RegistrationPage;

public class RegistrationFormTestsWithPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        String pageAddress = "/automation-practice-form",
                firstName = "Ivan",
                lastName = "Ivanov",
                email = "ivanov@ivanov.com",
                gender = "Male",
                phoneNumber = "0123456789",
                dayOfBirthday = "02",
                monthOfBirthday = "June",
                yearOfBirthday = "1985",
                subject = "Maths",
                hobby = "Sports",
                imageName = "testImage.png",
                imagePath = "img/testImage.png",
                currentAddress = "Montenegro",
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
                .successfulFormFilling("Date of Birth", dayOfBirthday + " " + monthOfBirthday + "," + yearOfBirthday)
                .successfulFormFilling("Subjects", subject)
                .successfulFormFilling("Hobbies", hobby)
                .successfulFormFilling("Picture", imageName)
                .successfulFormFilling("Address", currentAddress)
                .successfulFormFilling("State and City", state + " " + city)
                .successfulReturnToForm();

    }
}