import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestCases {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    //######################## Positive Test case ########################
    @Test
    public void validData() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        //Browsing URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Zoom out
        Robot robot = new Robot();
        for (int i = 0; i<5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Firstname
        driver.findElement(By.id("firstName")).sendKeys("Tawsif");

        //Lastname
        driver.findElement(By.id("lastName")).sendKeys("Mahmud");

        //Email
        driver.findElement(By.id("userEmail")).sendKeys("tawsifmahmud05@gmail.com");

        //Gender
        WebElement radbut = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));

        actions.click(radbut).perform();

        //Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1892567644");

        //DOB
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.sendKeys(Keys.CONTROL + "a");
        datePicker.sendKeys("29 Dec 1999");
        datePicker.sendKeys(Keys.ENTER);

        //Subject
        for(int i =0;i<=5;i++) {
            driver.findElement(By.id("subjectsInput")).click();
            driver.findElement(By.id("subjectsInput")).sendKeys("c");
            driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);
        }

        actions.moveToElement(driver.findElement(By.id("dateOfBirth-label"))).click();

        //hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();

        //photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\SDET Course\\Assignment\\Assignment 8 ( Junit Project )\\Junit_Assignment\\src\\test\\resources\\sample.png");

        //Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Bashundhara");

        //State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        //City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        actions.click(driver.findElement(By.id("submit"))).perform();

        String expectedMessage = "Thanks for submitting the form";
        String actualMessage = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }


    //######################## Negative Test case ########################

    //----------- Empty First Name -----------
    @Test
    public void emptyFirstName() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        //Browsing URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Zoom out
        Robot robot = new Robot();
        for (int i = 0; i<5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Firstname
        driver.findElement(By.id("firstName")).sendKeys("");

        //Lastname
        driver.findElement(By.id("lastName")).sendKeys("Mahmud");

        //Email
        driver.findElement(By.id("userEmail")).sendKeys("tawsifmahmud05@gmail.com");

        //Gender
        WebElement radbut = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));

        actions.click(radbut).perform();

        //Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1892567644");

        //DOB
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.sendKeys(Keys.CONTROL + "a");
        datePicker.sendKeys("29 Dec 1999");
        datePicker.sendKeys(Keys.ENTER);

        //Subject
        for(int i =0;i<=5;i++) {
            driver.findElement(By.id("subjectsInput")).click();
            driver.findElement(By.id("subjectsInput")).sendKeys("c");
            driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);
        }

        actions.moveToElement(driver.findElement(By.id("dateOfBirth-label"))).click();

        //hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();

        //photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\SDET Course\\Assignment\\Assignment 8 ( Junit Project )\\Junit_Assignment\\src\\test\\resources\\sample.png");

        //Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Bashundhara");

        //State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        //City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        actions.click(driver.findElement(By.id("submit"))).perform();

        String expectedMessage = "rgb(206, 212";
        String actualMessage = driver.findElement(By.id("firstName")).getCssValue("border-color");


        System.out.println(actualMessage);
        System.out.println(expectedMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //----------- Empty Last Name -----------
    @Test
    public void emptyLastName() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        //Browsing URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Zoom out
        Robot robot = new Robot();
        for (int i = 0; i<5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Firstname
        driver.findElement(By.id("firstName")).sendKeys("Tawsif");

        //Lastname
        driver.findElement(By.id("lastName")).sendKeys("");

        //Email
        driver.findElement(By.id("userEmail")).sendKeys("tawsifmahmud05@gmail.com");

        //Gender
        WebElement radbut = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));

        actions.click(radbut).perform();

        //Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1892567644");

        //DOB
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.sendKeys(Keys.CONTROL + "a");
        datePicker.sendKeys("29 Dec 1999");
        datePicker.sendKeys(Keys.ENTER);

        //Subject
        for(int i =0;i<=5;i++) {
            driver.findElement(By.id("subjectsInput")).click();
            driver.findElement(By.id("subjectsInput")).sendKeys("c");
            driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);
        }

        actions.moveToElement(driver.findElement(By.id("dateOfBirth-label"))).click();

        //hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();

        //photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\SDET Course\\Assignment\\Assignment 8 ( Junit Project )\\Junit_Assignment\\src\\test\\resources\\sample.png");

        //Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Bashundhara");

        //State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        //City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        actions.click(driver.findElement(By.id("submit"))).perform();

        String expectedMessage = "rgb(206, 212";
        String actualMessage = driver.findElement(By.id("lastName")).getCssValue("border-color");


        System.out.println(actualMessage);
        System.out.println(expectedMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //----------- invalid Email -----------
    @Test
    public void invalidEmail() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        //Browsing URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Zoom out
        Robot robot = new Robot();
        for (int i = 0; i<5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Firstname
        driver.findElement(By.id("firstName")).sendKeys("Tawsif");

        //Lastname
        driver.findElement(By.id("lastName")).sendKeys("Mahmud");

        //Email
        driver.findElement(By.id("userEmail")).sendKeys("tawsifmahmud05gmail.com");

        //Gender
        WebElement radbut = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));

        actions.click(radbut).perform();

        //Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1892567644");

        //DOB
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.sendKeys(Keys.CONTROL + "a");
        datePicker.sendKeys("29 Dec 1999");
        datePicker.sendKeys(Keys.ENTER);

        //Subject
        for(int i =0;i<=5;i++) {
            driver.findElement(By.id("subjectsInput")).click();
            driver.findElement(By.id("subjectsInput")).sendKeys("c");
            driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);
        }

        actions.moveToElement(driver.findElement(By.id("dateOfBirth-label"))).click();

        //hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();

        //photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\SDET Course\\Assignment\\Assignment 8 ( Junit Project )\\Junit_Assignment\\src\\test\\resources\\sample.png");

        //Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Bashundhara");

        //State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        //City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        actions.click(driver.findElement(By.id("submit"))).perform();

        String expectedMessage = "rgb(206, 212";
        String actualMessage = driver.findElement(By.id("userEmail")).getCssValue("border-color");


        System.out.println(actualMessage);
        System.out.println(expectedMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //----------- No Gender -----------
    @Test
    public void noGender() throws AWTException, InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        //Browsing URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Zoom out
        Robot robot = new Robot();
        for (int i = 0; i<5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Firstname
        driver.findElement(By.id("firstName")).sendKeys("Tawsif");

        //Lastname
        driver.findElement(By.id("lastName")).sendKeys("Mahmud");

        //Email
        driver.findElement(By.id("userEmail")).sendKeys("tawsifmahmud05@gmail.com");

        //Gender
//        WebElement radbut = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
//        actions.click(radbut).perform();

        //Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1892567644");

        //DOB
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.sendKeys(Keys.CONTROL + "a");
        datePicker.sendKeys("29 Dec 1999");
        datePicker.sendKeys(Keys.ENTER);

        //Subject
        for(int i =0;i<=5;i++) {
            driver.findElement(By.id("subjectsInput")).click();
            driver.findElement(By.id("subjectsInput")).sendKeys("c");
            driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);
        }

        actions.moveToElement(driver.findElement(By.id("dateOfBirth-label"))).click();

        //hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();

        //photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\SDET Course\\Assignment\\Assignment 8 ( Junit Project )\\Junit_Assignment\\src\\test\\resources\\sample.png");

        //Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Bashundhara");

        //State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        //City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        actions.click(driver.findElement(By.id("submit"))).perform();

        String expectedMessage = "rgb(220, 53";
        String actualMessage = driver.findElement(By.xpath("//label[contains(text(),'Male')]")).getCssValue("color");


        System.out.println(actualMessage);
        System.out.println(expectedMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //----------- invalid phone number -----------
    @Test
    public void invalidPhoneNumber() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        //Browsing URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Zoom out
        Robot robot = new Robot();
        for (int i = 0; i<5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Firstname
        driver.findElement(By.id("firstName")).sendKeys("Tawsif");

        //Lastname
        driver.findElement(By.id("lastName")).sendKeys("Mahmud");

        //Email
        driver.findElement(By.id("userEmail")).sendKeys("tawsifmahmud05@gmail.com");

        //Gender
        WebElement radbut = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radbut).perform();

        //Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("18925676");

        //DOB
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.sendKeys(Keys.CONTROL + "a");
        datePicker.sendKeys("29 Dec 1999");
        datePicker.sendKeys(Keys.ENTER);

        //Subject
        for(int i =0;i<=5;i++) {
            driver.findElement(By.id("subjectsInput")).click();
            driver.findElement(By.id("subjectsInput")).sendKeys("c");
            driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);
        }

        actions.moveToElement(driver.findElement(By.id("dateOfBirth-label"))).click();

        //hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();

        //photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\SDET Course\\Assignment\\Assignment 8 ( Junit Project )\\Junit_Assignment\\src\\test\\resources\\sample.png");

        //Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Bashundhara");

        //State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        //City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        actions.click(driver.findElement(By.id("submit"))).perform();

        String expectedMessage = "rgb(206,";
        String actualMessage = driver.findElement(By.id("userNumber")).getCssValue("border-color");


        System.out.println(actualMessage);
        System.out.println(expectedMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //----------- null phone number -----------
    @Test
    public void nullPhoneNumber() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        //Browsing URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Zoom out
        Robot robot = new Robot();
        for (int i = 0; i<5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Firstname
        driver.findElement(By.id("firstName")).sendKeys("Tawsif");

        //Lastname
        driver.findElement(By.id("lastName")).sendKeys("Mahmud");

        //Email
        driver.findElement(By.id("userEmail")).sendKeys("tawsifmahmud05@gmail.com");

        //Gender
        WebElement radbut = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radbut).perform();

        //Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("");

        //DOB
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.sendKeys(Keys.CONTROL + "a");
        datePicker.sendKeys("29 Dec 1999");
        datePicker.sendKeys(Keys.ENTER);

        //Subject
        for(int i =0;i<=5;i++) {
            driver.findElement(By.id("subjectsInput")).click();
            driver.findElement(By.id("subjectsInput")).sendKeys("c");
            driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);
        }

        actions.moveToElement(driver.findElement(By.id("dateOfBirth-label"))).click();

        //hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();

        //photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\SDET Course\\Assignment\\Assignment 8 ( Junit Project )\\Junit_Assignment\\src\\test\\resources\\sample.png");

        //Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Bashundhara");

        //State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        //City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        actions.click(driver.findElement(By.id("submit"))).perform();

        String expectedMessage = "rgb(206,";
        String actualMessage = driver.findElement(By.id("userNumber")).getCssValue("border-color");


        System.out.println(actualMessage);
        System.out.println(expectedMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //----------- invalid DOB -----------
    @Test
    public void invalidDOB() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        //Browsing URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Zoom out
        Robot robot = new Robot();
        for (int i = 0; i<5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Firstname
        driver.findElement(By.id("firstName")).sendKeys("Tawsif");

        //Lastname
        driver.findElement(By.id("lastName")).sendKeys("Mahmud");

        //Email
        driver.findElement(By.id("userEmail")).sendKeys("tawsifmahmud05@gmail.com");

        //Gender
        WebElement radbut = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));

        actions.click(radbut).perform();

        //Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1892567644");

        //DOB
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.sendKeys(Keys.CONTROL + "a");
        datePicker.sendKeys("3598626987456215569");
        datePicker.sendKeys(Keys.ENTER);

        //Subject
        for(int i =0;i<=5;i++) {
            driver.findElement(By.id("subjectsInput")).click();
            driver.findElement(By.id("subjectsInput")).sendKeys("c");
            driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);
        }

        actions.moveToElement(driver.findElement(By.id("dateOfBirth-label"))).click();

        //hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();

        //photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\SDET Course\\Assignment\\Assignment 8 ( Junit Project )\\Junit_Assignment\\src\\test\\resources\\sample.png");

        //Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Bashundhara");

        //State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        //City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        actions.click(driver.findElement(By.id("submit"))).perform();
        Thread.sleep(1000);

        int expectedMessage = 2022;
        String date = driver.findElement(By.xpath("//tbody/tr[5]/td[2]")).getText();

        System.out.println(date);
        int year = Integer.parseInt(date.split(",")[1].trim());

        Assert.assertTrue(year > expectedMessage);

    }

    //----------- empty Subject -----------
    @Test
    public void emptySubject() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        //Browsing URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Zoom out
        Robot robot = new Robot();
        for (int i = 0; i<5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Firstname
        driver.findElement(By.id("firstName")).sendKeys("Tawsif");

        //Lastname
        driver.findElement(By.id("lastName")).sendKeys("Mahmud");

        //Email
        driver.findElement(By.id("userEmail")).sendKeys("tawsifmahmud05@gmail.com");

        //Gender
        WebElement radbut = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));

        actions.click(radbut).perform();

        //Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1892567644");

        //DOB
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.sendKeys(Keys.CONTROL + "a");
        datePicker.sendKeys("29 Dec 1999");
        datePicker.sendKeys(Keys.ENTER);

        //Subject
//        for(int i =0;i<=5;i++) {
//            driver.findElement(By.id("subjectsInput")).click();
//            driver.findElement(By.id("subjectsInput")).sendKeys("c");
//            driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);
//        }

        actions.moveToElement(driver.findElement(By.id("dateOfBirth-label"))).click();

        //hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();

        //photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\SDET Course\\Assignment\\Assignment 8 ( Junit Project )\\Junit_Assignment\\src\\test\\resources\\sample.png");

        //Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Bashundhara");

        //State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        //City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        String expectedMessage = "";
        String actualMessage = driver.findElement(By.xpath("//tbody/tr[6]/td[2]")).getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //----------- No Hobby -----------
    @Test
    public void noHobby() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        //Browsing URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Zoom out
        Robot robot = new Robot();
        for (int i = 0; i<5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Firstname
        driver.findElement(By.id("firstName")).sendKeys("Tawsif");

        //Lastname
        driver.findElement(By.id("lastName")).sendKeys("Mahmud");

        //Email
        driver.findElement(By.id("userEmail")).sendKeys("tawsifmahmud05@gmail.com");

        //Gender
        WebElement radbut = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));

        actions.click(radbut).perform();

        //Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1892567644");

        //DOB
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.sendKeys(Keys.CONTROL + "a");
        datePicker.sendKeys("29 Dec 1999");
        datePicker.sendKeys(Keys.ENTER);

        //Subject
        for(int i =0;i<=5;i++) {
            driver.findElement(By.id("subjectsInput")).click();
            driver.findElement(By.id("subjectsInput")).sendKeys("c");
            driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);
        }

        actions.moveToElement(driver.findElement(By.id("dateOfBirth-label"))).click();

        //hobbies
//        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
//        actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
//        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();

        //photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\SDET Course\\Assignment\\Assignment 8 ( Junit Project )\\Junit_Assignment\\src\\test\\resources\\sample.png");

        //Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Bashundhara");

        //State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        //City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        String expectedMessage = "";
        String actualMessage = driver.findElement(By.xpath("//tbody/tr[7]/td[2]")).getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //----------- No image -----------
    @Test
    public void invalidFile() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        //Browsing URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Zoom out
        Robot robot = new Robot();
        for (int i = 0; i<5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Firstname
        driver.findElement(By.id("firstName")).sendKeys("Tawsif");

        //Lastname
        driver.findElement(By.id("lastName")).sendKeys("Mahmud");

        //Email
        driver.findElement(By.id("userEmail")).sendKeys("tawsifmahmud05@gmail.com");

        //Gender
        WebElement radbut = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));

        actions.click(radbut).perform();

        //Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1892567644");

        //DOB
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.sendKeys(Keys.CONTROL + "a");
        datePicker.sendKeys("29 Dec 1999");
        datePicker.sendKeys(Keys.ENTER);

        //Subject
        for(int i =0;i<=5;i++) {
            driver.findElement(By.id("subjectsInput")).click();
            driver.findElement(By.id("subjectsInput")).sendKeys("c");
            driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);
        }

        actions.moveToElement(driver.findElement(By.id("dateOfBirth-label"))).click();

        //hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();

        //photo
//        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
//        uploadElement.sendKeys("F:\\SDET Course\\Assignment\\Assignment 8 ( Junit Project )\\Junit_Assignment\\src\\test\\resources\\sample.png");

        //Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Bashundhara");

        //State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        //City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        actions.click(driver.findElement(By.id("submit"))).perform();

        String expectedMessage = "Thanks for submitting the form";
        String actualMessage = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //----------- No State No City -----------
    @Test
    public void NoStateCity() throws AWTException, InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        //Browsing URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Zoom out
        Robot robot = new Robot();
        for (int i = 0; i<5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Firstname
        driver.findElement(By.id("firstName")).sendKeys("Tawsif");

        //Lastname
        driver.findElement(By.id("lastName")).sendKeys("Mahmud");

        //Email
        driver.findElement(By.id("userEmail")).sendKeys("tawsifmahmud05@gmail.com");

        //Gender
        WebElement radbut = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));

        actions.click(radbut).perform();

        //Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1892567644");

        //DOB
        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.sendKeys(Keys.CONTROL + "a");
        datePicker.sendKeys("29 Dec 1999");
        datePicker.sendKeys(Keys.ENTER);

        //Subject
        for(int i =0;i<=5;i++) {
            driver.findElement(By.id("subjectsInput")).click();
            driver.findElement(By.id("subjectsInput")).sendKeys("c");
            driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);
        }

        actions.moveToElement(driver.findElement(By.id("dateOfBirth-label"))).click();

        //hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();

        //photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\SDET Course\\Assignment\\Assignment 8 ( Junit Project )\\Junit_Assignment\\src\\test\\resources\\sample.png");

        //Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Bashundhara");

        //State
//        WebElement state = driver.findElement(By.id("react-select-3-input"));
//        state.sendKeys("NCR");
//        state.sendKeys(Keys.ENTER);

        //City
//        WebElement city = driver.findElement(By.id("react-select-4-input"));
//        city.sendKeys("Delhi");
//        city.sendKeys(Keys.ENTER);

        actions.click(driver.findElement(By.id("submit"))).perform();

        String expectedMessage = "Thanks for submitting the form";
        String actualMessage = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }



    @After
    public void quit() throws InterruptedException {
        driver.quit();
        Thread.sleep(4000);
    }
}
