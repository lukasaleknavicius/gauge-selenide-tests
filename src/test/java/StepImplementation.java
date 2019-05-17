import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.Step;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class StepImplementation {

    @BeforeSuite
    public void setUpDriver() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).version("72").setup();
    }

    @Step("Navigate to page")
    public void navigateToPage() {
        open("https://www.saucedemo.com/");
    }

    @Step("Login <username>")
    public void loginUser(String username) {
        $x("//input[@id=\"user-name\"]").val(username);
        $x("//input[@id=\"password\"]").val("secret_sauce");
        $x("//input[@type=\"submit\"]").click();
        sleep(5000);
    }
}
