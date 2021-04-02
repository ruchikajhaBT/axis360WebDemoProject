package com.bt.qa.testcases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.images.Eyes;

public class AppliToolsDemoTest{
	public  Eyes eyes;
	BufferedImage img;
	
	
	public AppliToolsDemoTest(){
	    // Define the OS and hosting application to identify the baseline.

	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		eyes = new Eyes();
		eyes.setApiKey("VJ1d3kQtEHQ108TPMSgXWakGsYYZmC75MkuwgPLCy7HWQ110");
	    eyes.setHostOS("Windows 10");
	    eyes.setHostApp("Chrome");

	}
	
	@Test
	public void loginTest() throws IOException{
		eyes.open("Axis360", "login-popup", new RectangleSize(800, 600));
		File file = new File("C:/Projects/EclipseProjects/Axis360Web/src/main/resources/percy_screenshots/login-popup.jpg");
		URL url = file.toURI().toURL();

		// Load page image and validate.
        img = ImageIO.read(url);

		// Visual validation.
        eyes.checkImage(img, "login-popup");
	}
	

	@AfterTest
	public void tearDown(){
		 eyes.close();
	}
	
}
