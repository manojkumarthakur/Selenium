package org.manoj.testng;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    @Test
    @Parameters({"browser", "url", "database"})
    public void testLogin(@Optional("Safari") String browser, @Optional("https://google.com") String url,
                          @Optional("Mongo") String db) {
        System.out.println("using Database " + db);
        System.out.println("Testing with browser: " + browser + " and URL: " + url);
        // Add your test logic here
    }
}
