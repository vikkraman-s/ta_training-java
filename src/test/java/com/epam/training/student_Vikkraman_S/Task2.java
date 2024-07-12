package com.epam.training.student_Vikkraman_S;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;

public class Task2 {
    WebDriver driver = new ChromeDriver();

    @Test(priority = 1)
    public void task2() throws InterruptedException, AWTException {

        driver.manage().window().maximize();
        driver.get(" https://pastebin.com/");

        WebElement code = driver.findElement(By.id("postform-text"));
        code.sendKeys("   git config --global user.name  \"New Sheriff in Town\"\n" +
                "            git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "            git push origin master --force\n");

        WebElement dropDownList = driver.findElement(By.xpath("(//span[@class='selection'])[2]"));
        dropDownList.click();

        WebElement selectItem = driver.findElement(By.xpath("(//ul/li[text()='Bash'])[1]"));
        Actions act = new Actions(driver);
        act.moveToElement(selectItem).perform();

        driver.findElement(By.xpath("//li[text()='Bash']")).click();

        WebElement title = driver.findElement(By.id("postform-name"));
        title.sendKeys("how to gain dominance among developers");
        WebElement button = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, '-big')]"));
        button.click();
    }

    @Test(priority = 2)
    public void titleCheck(){
        String actualtTitle = driver.getTitle();
        String title= "how to gain dominance among developers - Pastebin.com";
        Assert.assertEquals(actualtTitle,title);
    }

    @Test(priority = 3)
    public void syntaxCheck(){
        String actualSyntax = driver.findElement(By.xpath("//a[text()='Bash']")).getText();
        String expectedSyntax = "Bash";
        Assert.assertEquals(actualSyntax,expectedSyntax);
    }

    @Test(priority = 3)
    public void codeCheck(){
        String expectedCode = "   git config --global user.name  \"New Sheriff in Town\"\n" +
                "            git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "            git push origin master --force\n";
        String actualCode = driver.findElement(By.xpath("(//div[@class='de1'])[1]")).getText();
        Assert.assertTrue("Code not contails in expected output",expectedCode.contains(actualCode));

    }
}
