package qa.automation.report;

import com.relevantcodes.extentreports.ExtentReports;

import qa.automation.page.tests.base.BaseTest;

public class ExtentReportManager extends BaseTest {

	private static ExtentReports reporter;

	public static String reportPath;
//	private static String reportPath2;

	// Don't allow initiation outside the class
	private ExtentReportManager() {
	}

	/**
	 * Allow only single reporter and enforce synchronize access
	 * 
	 * @return
	 */
	public synchronized static ExtentReports getReporter() {
		if (reporter == null) {
			reportPath = System.getProperty("user.dir") + "/logs/ExtentReports/ExtentReportResults-JenkinsNEW"
					+ ".html";
			reporter = new ExtentReports(reportPath, true);
			reporter.addSystemInfo("TestNG xml file", "");
			reporter.addSystemInfo("TestNG Suite", "");
		}
		return reporter;
	}

}
