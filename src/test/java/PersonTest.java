
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;


public class PersonTest {

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        }

        @BeforeClass
        void BeforeClass() {
            System.out.println("Before Class");
            currentTime();
        }

        @AfterClass
        void AfterClass() {
            System.out.println("After Class");
            currentTime();
        }
        @BeforeMethod
        public void setUp(){
            System.out.println("TeenageTest started");
        }
        @AfterMethod
        public void tearDown(){
            System.out.println("TeenageTest done");
        }

        @DataProvider(name = "ageDataProvider")
        Object[][] ageDataProvider() {
            return new Object[][]{
                    {0, false},
                    {10, false},
                    {13, true},
                    {14, true},
                    {18, true},
                    {19, true},
                    {20, false},
                    {50, false}
            };
        }

        @Test(dataProvider = "ageDataProvider")
        public void Test(int age, boolean expectedResult) {
            boolean result = Person.isTeenager(age);
            System.out.println(result);
            assertEquals(result, expectedResult);
        }

    }
