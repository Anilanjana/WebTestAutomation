package genericlibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * @author Indrapal Singh captureScreenShot method to capture screenshoot for
 *         failed test captureScreenShot method to capture screenshoot after
 *         every test
 */

public class ScreenshotUtilities {

	private ScreenshotUtilities() {
		throw new IllegalStateException("Utility class");
	}

	public static void captureScreenShot() throws IOException {

		// Take screenshot and store
		File src = ((TakesScreenshot) BrowserUtilities.driver).getScreenshotAs(OutputType.FILE);

		// now copy the screenshot to desired location using copyFile method

		
		FileUtils.copyFile(src,
				new File(BrowserUtilities.prop.getProperty("Screenshotpath") + System.currentTimeMillis() + ".png"));

	}
}
