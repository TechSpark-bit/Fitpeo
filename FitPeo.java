package assessments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FitPeo {

	public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drvr/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);
        
      
            // 1. Navigate to the FitPeo Homepage
            driver.get("https://www.fitpeo.com");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            System.out.println("FitPeo Homepage.");

           // 2. Navigate to the Revenue Calculator Page
            WebElement revenueCalculatorLink = driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]"));
            revenueCalculatorLink.click();
            Thread.sleep(2000);
            System.out.println("Revenue Calculator link clicked.");

            // 3. Scroll Down to the Slider section
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Thread.sleep(2000);
            WebElement sliderSection = driver.findElement(By.xpath("//h4[(text() = 'Medicare Eligible Patients')] ")); 
            js.executeScript("arguments[0].scrollIntoView(true);", sliderSection);
            Thread.sleep(2000);
            System.out.println("Scrolled to Medicare Eligible Patients section.");
            
            // 4. Adjust the Slider
            WebElement slider = driver.findElement(By.xpath("(//input[@id=':r0:'])[1]"));
            slider.clear();
            Thread.sleep(2000);
            WebElement sliderThumb = driver.findElement(By.xpath("//span[contains(@class, 'MuiSlider-thumb')]"));
            WebElement sliderRail = driver.findElement(By.xpath("//span[contains(@class, 'MuiSlider-rail')]"));
            int sliderWidth = sliderRail.getSize().getWidth();
            int sliderStartX = sliderRail.getLocation().getX();
            int targetValue = 761; 
            int maxValue = 2000;   
            int moveToX = (int) ((targetValue / (double) maxValue) * sliderWidth);
            int finalX = sliderStartX + moveToX;
            Actions actions = new Actions(driver);
                actions.clickAndHold(sliderThumb)
                       .moveByOffset((finalX - sliderThumb.getLocation().getX()), 0) 
                       .release()
                       .perform(); 

                // validating slider value
                WebElement inputBox = driver.findElement(By.xpath("//input[@type='number']")); 
                String updatedValue = inputBox.getAttribute("value");
                if ("822".equals(updatedValue)) {  
                System.out.println("Slider successfully adjusted to the value: " + updatedValue);
            } else {
                System.out.println("Slider adjustment failed. Expected: 816, Found: " + updatedValue);
            }
        
             // 5.	Update the Text Field:
               WebElement sliderThumb1 = driver.findElement(By.xpath("//span[contains(@class, 'MuiSlider-thumb')]"));
               WebElement sliderRail1 = driver.findElement(By.xpath("//span[contains(@class, 'MuiSlider-rail')]"));
                int sliderWidth1 = sliderRail.getSize().getWidth();
               int sliderStartX1 = sliderRail.getLocation().getX();
               int targetValue1 = 500; 
               int maxValue1 = 2000;   
               int moveToX1 = (int) ((targetValue1 / (double) maxValue1) * sliderWidth1);
               int finalX1 = sliderStartX1 + moveToX1;
               Actions actions1 = new Actions(driver);
               actions1.clickAndHold(sliderThumb1)
                      .moveByOffset((finalX1 - sliderThumb1.getLocation().getX()), 0) 
                      .release()
                      .perform();

               // 6.	Validate Slider Value:
               WebElement inputBox1 = driver.findElement(By.xpath("//input[@type='number']"));
               String updatedValue1 = inputBox.getAttribute("value");
                 if ("562".equals(updatedValue1)) {  
               System.out.println("Slider successfully adjusted to the value: " + updatedValue1);
           } else {
               System.out.println("Slider adjustment failed. Expected: 560, Found: " + updatedValue1);
           }
           
                
            // 7. Select CPT Codes
            driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
            driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
            driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
            driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
            Thread.sleep(2000);
            System.out.println("CPT codes");

             // 8. Validate Total Recurring Reimbursement
            WebElement reimbursementValue = driver.findElement(By.xpath("(//p[contains(text(),'Total Recurring Reimbursement')])[1]")); 
            String actualText = reimbursementValue.getText();

            if (actualText.equals("$110700")) {
                System.out.println("Total Recurring Reimbursement validated successfully!");
            } else {
                System.out.println("Validation failed! Expected: $110700, but found: " + actualText);
            }
            driver.quit();

            }}        

    

	


