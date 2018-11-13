package web.cts.crpyto.crpyto;

import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import web.cts.crpyto.core.AbstractPage;
import web.cts.crpyto.wrappers.WebDriverWrapper;

@Component
public class SignInPage extends AbstractPage {
	
	private final Logger logger = LoggerFactory.getLogger(WebDriverWrapper.class);
	
	@Value("${crpyto.email}")
	private String email;
	
	@Value("${crpyto.password}")
	private String password;
	
	@Autowired
	private WebDriverWrapper webDriver;
	
	private boolean userLoggedIn;
		
	public boolean isUserLoggedIn(){
		return this.userLoggedIn ;
	}
	public boolean doLogin() throws InterruptedException{	
		webDriver.getObject("//button[@class='btn btn-default']").click();
		webDriver.getObjectById("email").sendKeys(email);
		webDriver.getObjectById("password").sendKeys(password);
		webDriver.getObject("//button[@class='full-width btn btn-primary']").click();		
		Thread.sleep(500);
		if(webDriver.getObject("//div[@class='myTokens']").getText().contains("My Binfinity Tokens") ){
			userLoggedIn= true;
			logger.info("Login successful for email: " + email);
		}else{
			userLoggedIn=false;
			logger.error("Login failed for email: " + email);
		}
		logger.info("Completed Login Execution");
		return userLoggedIn ;
	}
	
	//logout after all operation
	/*
	public void logout(){
		if(userLoggedIn){
			webDriver.waitForAction(15);

			userLoggedIn=false;
			webDriver.closeDriver();
		}		
	}
	*/

}
