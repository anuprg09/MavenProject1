package Itustra.MavenProject1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class EventListner implements ITestListener{

	@Override
	  public void onStart(ITestContext context) {
    	Reporter.log("Test Suite Startted...");	
		  }

	@Override
	public void onFinish(ITestContext arg0) {					
      // TODO Auto-generated method stub				
      	Reporter.log("On Finish...");	
  }		

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName() + "....Started");
		Reporter.log("Test Begin executed....");
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log(result.getName() + "....Sucess");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		Reporter.log(result.getName() + "....Fail");

	}
}
