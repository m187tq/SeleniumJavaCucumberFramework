package automationteststore.Learn_Interface;

import org.testng.annotations.Test;

public class ImplementInterface {

    @Test
    public void isDisplayed() {
        Home home = () -> System.out.println("It is displayed");
        home.isDisplayed();
    }
}
