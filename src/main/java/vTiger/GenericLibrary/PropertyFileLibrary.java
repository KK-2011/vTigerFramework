package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author KRISHNA KANTH
 *
 */
public class PropertyFileLibrary {
     /**
      * This method will read the value from property file for the key given by user
      * @param key
      * @return
      * @throws IOException
      */
	public String readDataFromPropertyFile(String key) throws IOException
     {
    	FileInputStream fis = new FileInputStream(IConstantsLibrary.propertyFilePath);
		Properties pObj = new Properties();
    	pObj.load(fis);
    	String value = pObj.getProperty(key);
    	return value;
     }
}
