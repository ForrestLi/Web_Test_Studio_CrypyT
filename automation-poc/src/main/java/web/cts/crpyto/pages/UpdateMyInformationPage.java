package web.cts.crpyto.pages;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import web.cts.crpyto.core.AbstractPage;
import web.cts.crpyto.wrappers.WebDriverWrapper;

@Component
public class UpdateMyInformationPage extends AbstractPage {

	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(UpdateMyInformationPage.class);
	private static final String PAGE_ACTION_FLOW_INPUT_FILE="UpdateMyInformationPageActionFlow.json";
	
	@Autowired
	private WebDriverWrapper webDriver;
		

	@SuppressWarnings("unchecked")
	public boolean updateMyInformation(Map<String, String> inputParameters)throws Exception{
		Map<String, Object> parsedPageFlowData = getParsedPageFlowData(PAGE_ACTION_FLOW_INPUT_FILE);		
		Map<String, Object> siteSearchResultsPage = (HashMap<String, Object>) parsedPageFlowData.get("UpdateMyInformationPage"); 
		executePageAction(siteSearchResultsPage, inputParameters);
		return true;
	}

}
