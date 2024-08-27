package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateExtentReports {

	public static ExtentReports getReportsObjects() {
		//ExtentReport  ExtentSparkReporter
				String path = System.getProperty("user.dir")+"\\reports\\index.html";
				ExtentSparkReporter report = new ExtentSparkReporter(path);
				report.config().setReportName("Flipcart Demo Automation for AddToCartProduct");
				report.config().setDocumentTitle("Flipcart Pvt. Ltd");
				
				ExtentReports extent = new ExtentReports();
				extent.attachReporter(report);
				extent.setSystemInfo("Tester","SHIRISH MISTARI");
				return extent;
	}

}
