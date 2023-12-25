package com.osxm.je.topic.test.bdd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    WebDriver driver;

    @Given("^I navigated to mysite$")
    public void i_navigated_to_lemfix_site() throws Throwable {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://localhost:8080/login?from=%2F");
    }

    @When("^I input \"([^\"]*)\" and \"([^\"]*)\" to login$")
    public void i_input_vincent_and_password_to_login(String us_name, String us_psswd) throws Throwable {
        WebElement loginTop;
        WebElement username;
        WebElement password;
        WebElement loginBTN;

        us_name = "admin";
        us_psswd = "cplm";
        username = driver.findElement(By.id("j_username"));
        password = driver.findElement(By.name("j_password"));
        loginBTN = driver.findElement(By.xpath("html/body/div/div/form/div[2]/input"));
        username.click();
        username.sendKeys(us_name);
        password.click();
        password.sendKeys(us_psswd);
        loginBTN.click();

        Thread.sleep(1000);
    }

    @Then("^I verify login \"([^\"]*)\"")
    public void i_verify_login_result(String rs) throws Throwable {
        String title = driver.getTitle();
        String result;
        if (title.contains("登录")) {
            result = "fail";
        } else if (title.equals("Lemfix")) {
            result = "success";
        } else {
            result = null;
        }
        System.out.println(title);
        System.out.println("result=" + result);
        Thread.sleep(1000);
        driver.quit();
    }
}
