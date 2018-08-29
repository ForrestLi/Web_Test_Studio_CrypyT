package web.cts.crpyto.parsers;

import java.io.File;
import java.util.Map;

public interface Parser {

	public Map<String, Object> parseData(File data) throws Exception;
	
	
	public String getparserName();
}