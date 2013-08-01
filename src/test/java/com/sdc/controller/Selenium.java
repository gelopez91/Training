package com.sdc.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    public static void main(String[] args) {

        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.navigate().to("http://localhost:9999/Training/movie");

        WebElement elementName = driver.findElement(By.name("name"));
        WebElement elementDescription = driver.findElement(By.name("description"));
        WebElement elementDirection = driver.findElement(By.name("direction"));
        WebElement elementYear = driver.findElement(By.name("year"));
        WebElement elementLanguage = driver.findElement(By.name("language"));
        WebElement elementDuration = driver.findElement(By.name("duration"));
        WebElement elementSubmit = driver.findElement(By.id("submit"));

        elementName.sendKeys("pruebaNombre");
        elementDescription.sendKeys("Esto es una prueba");
        elementDirection.sendKeys("pruebaDireccion");
        elementYear.sendKeys("pruebaAnno");
        elementLanguage.sendKeys("pruebaIdioma");
        elementDuration.sendKeys("pruebaDuracion");
        elementSubmit.click();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
    }
}
