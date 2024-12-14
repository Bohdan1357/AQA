package task13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ISuite;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static task12.DriverProvider.driver;

public class CustomTest13Listener implements ITestListener, ISuiteListener {

    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    // ITestListener methods
    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Started {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.error("Test failed: {}", result.getName());

        // Get HTML source
        String pageSource = driver.getPageSource();

        // Generate unique filename
        String testName = result.getName();
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String uniqueID = UUID.randomUUID().toString();
        String fileName = testName + "_" + timestamp + "_" + uniqueID + ".html";

        // Specify the directory path
        Path directoryPath = Paths.get("test_failure_html");
        Path filePath = directoryPath.resolve(fileName);

        // Save to file
        try {
            Files.createDirectories(directoryPath);

            try (FileWriter writer = new FileWriter(filePath.toFile())) {
                writer.write(pageSource);
                LOGGER.info("Saved HTML source to file: {}", filePath.toString());
            }
        } catch (IOException e) {
            LOGGER.error("Failed to save HTML source to file", e);
        }
    }

    // ISuiteListener methods
    @Override
    public void onStart(ISuite suite) {
        LOGGER.info("Test Suite Started: {}", suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        LOGGER.info("Test Suite Finished: {}", suite.getName());
    }
}