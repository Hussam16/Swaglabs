package report;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {
	private static String path;
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();

		return extent;
	}


	public static ExtentReports createInstance() {
		if (extent == null) {
			String workingDir = System.getProperty("user.dir");
			String reportName = "Report.html";
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
	        String repName = "Test-Report-" + timeStamp + ".html";



			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(".\\Reports\\" + repName);// specify the location of the report

			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setDocumentTitle("Report");
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setReportName("Automated Tests - Report");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		}
		return extent;
	}

}
