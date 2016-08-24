/**
 * 
 */
package com.eej.utilities.datatables.test;

import java.io.IOException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author DOIBALMI
 *
 */
public class ScanPackageTest {
	
	private static Logger logger = Logger.getLogger(ScanPackageTest.class);

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		//PropertyConfigurator.configure("classpath:properties/log4j.properties");
		PropertyConfigurator.configure(ScanPackageTest.class.getClassLoader().getResource("properties/log4j.properties"));
		
		String[] classes = {"com.eej.utilities","com.eej.utilities.annotation","com.eej.utilities.datatables.test.model"};
		
		logger.debug("Scan " + classes + " non recursive");
		ScanPackage scanPackage = 
				new ScanPackage(Arrays.asList(classes));
		scanPackage.getClassMap();
		
		logger.debug("---------------------------------------------");
		logger.debug("Scan " + classes + "  recursive");
		scanPackage = 
				new ScanPackage(Arrays.asList(classes), true);
		scanPackage.getClassMap();

	}

}
