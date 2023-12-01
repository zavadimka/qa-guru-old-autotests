package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;


public class checkPageSoftAssertionsOnGithub {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl="https://github.com";
        Configuration.browserSize="1920x1080";
        Configuration.holdBrowserOpen=true;
    }


    @Test
    void findJUnit5CodeOnPageSoftAssertions(){

        // Откройте страницу Selenide в Github
        open("/selenide/selenide");
        sleep(1000);

        // Перейдите в раздел Wiki проекта
        open("/selenide/selenide/wiki");
        sleep(1000);

        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-body")
                .$(".markdown-body")
                .find("a[href*='SoftAssertions']")
                .should(Condition.exist);

        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        open("/selenide/selenide/wiki/SoftAssertions");
        $("#wiki-body")
                .$(".markdown-body")
                .find("a[href*='junit5']")
                .should(Condition.exist);
        sleep(1000);
    }
}
