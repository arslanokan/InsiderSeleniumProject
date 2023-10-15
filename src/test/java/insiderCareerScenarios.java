
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class insiderCareerScenarios {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void testCareerScenario() throws InterruptedException {
        driver.get("https://useinsider.com/");

        // Başlığın doğru olduğunu kontrol et

        String expectedPageTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";
        String actualPageTitle = driver.getTitle();
        assertEquals(expectedPageTitle, actualPageTitle);

        driver.findElement(By.xpath("//a[contains(.,'Company')]")).click();

        driver.findElement(By.xpath("//a[.='Careers']")).click();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,150)","");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='button-group d-flex flex-row']/a[.='Find your dream job']")).click();

        driver.findElement(By.id("wt-cli-accept-all-btn")).click();

        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("window.scrollBy(0,5000)","");

        String expectedOpenPositionsTitle = "Insider Open Positions | Insider";
        String actualOpenPositionsTitle = driver.getTitle();
        assertEquals(expectedOpenPositionsTitle, actualOpenPositionsTitle);


    }

    @Test
    public void jobsFilterScenario () throws InterruptedException {
        driver.get("https://useinsider.com/careers/quality-assurance/,");

        JavascriptExecutor js2 = (JavascriptExecutor)driver;
        js2.executeScript("window.scrollBy(0,150)","");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='button-group d-flex flex-row']")).click();
        driver.findElement(By.id("wt-cli-accept-all-btn")).click();

        JavascriptExecutor js3 = (JavascriptExecutor)driver;
        js3.executeScript("window.scrollBy(0,150)","");

        WebElement dropdownElement = driver.findElement(By.id("select2-filter-by-location-container"));
        dropdownElement.click();
        WebElement optionElement = driver.findElement(By.cssSelector(".select2-results__option--highlighted"));
        optionElement.click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[title='Quality Assurance']")).click();
        driver.findElement(By.cssSelector(".select2-results__option--highlighted")).click();

        JavascriptExecutor js5 = (JavascriptExecutor)driver;
        js5.executeScript("window.scrollBy(0,150)","");

        driver.findElement(By.xpath("//p[@id='resultCounter']")).getText();

        WebElement departmentText = driver.findElement(By.xpath("//div[@id='jobs-list']/div[1]//div[@class='position-location text-large']"));
        String elementText = departmentText.getText();

        if (elementText.equals("Quality Assurance")) {
            System.out.println("Department texti hatalı.");
        } else {
            System.out.println("Department texti doğru.");
        }

        WebElement departmentElement  = driver.findElement(By.cssSelector("#jobs-list > div:nth-of-type(1) > .position-list-item-wrapper"));
        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("arguments[0].scrollIntoView();", departmentElement);

        WebElement btnViewRole = driver.findElement(By.xpath("//a[@href='https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc']"));
        js4.executeScript("arguments[0].click();", btnViewRole);


    }

    @AfterEach
    public void tearDown() {
        driver.quit();

    }



}

