package web.cts.crpyto.test;

import java.io.File;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Assume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import web.cts.crpyto.crpyto.SignInPage;
import web.cts.crpyto.parsers.Parser;
import web.cts.crpyto.utils.TestUtils;
import web.cts.crpyto.wrappers.WebDriverWrapper;


public abstract class AbstractBaseTest {

	private Map<String, Object> parsedData;
	
	@Autowired
	@Qualifier("jsonParser")
	private Parser parser;
	
	@Autowired
	private TestUtils testUtils;

	//@Autowired
	//private AuthenticatePage authenticatePage;
	
	@Autowired
	public WebDriverWrapper webDriver;
	
	public Map<String, Object> getParsedData(String fileName) throws Exception {
		if( parsedData == null ){
			
			File file = FileUtils.getFile("src", "test",  "resources", fileName);

			parsedData = parser.parseData(file);
		}
		return parsedData;
	}
	
     public void  setUpChecks(String testName) throws Exception {
		// Check Run mode
	    if (testUtils==null){
	    	System.out.print("failed to intiatie testUtils bean");
	    	
	    }
		if (testUtils.isSkip(testName)) {
			Assume.assumeTrue(false);
		}
//				if(!authenticatePage.isUserLoggedIn()) {
//		            authenticatePage.doLogin() ;
//		}
		
	}
	
	public void signOut() {
//		authenticatePage.logout();
	}
	
	public void takeScreenShot(String screenShotName){
		webDriver.takeScreenShot(screenShotName ) ;
	}

}
