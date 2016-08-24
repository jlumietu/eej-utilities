/**
 * 
 */
package com.eej.utilities.datatables.test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.eej.utilities.annotation.DataTable;

/**
 * @author DOIBALMI
 *
 */
public class ScanPackage {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private List<String> packagesToScan;
	
	private Map<String,String> instances;
	
	private boolean scanSubpackages = false;

	/**
	 * @param packagesToScan
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ScanPackage(List<String> packagesToScan){
		super();
		this.packagesToScan = packagesToScan;
	}
	
	/**
	 * @param packagesToScan
	 * @param scanSubpackages
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ScanPackage(List<String> packagesToScan, boolean scanSubpackages){
		super();
		this.packagesToScan = packagesToScan;
		this.scanSubpackages = scanSubpackages;
	}



	/**
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public Map<String,String> getClassMap() throws ClassNotFoundException, IOException{
		instances = new HashMap<String, String>();
		for(String pack : this.packagesToScan){
			Class[] classes = this.getClasses(pack);
			logger.debug("Classes.length = " + classes.length);
			for(Class clazz : classes){
				logger.debug("class = " + clazz.getName() + " -> " 
							+ clazz.getSimpleName() + " -> " 
							+ convertToJavaStyleInstanceName(clazz.getSimpleName()) );
				if(clazz.isAnnotationPresent(DataTable.class)){
					instances.put(convertToJavaStyleInstanceName(clazz.getSimpleName()), clazz.getName());
				}
			}
			
		}
		logger.debug("instances " + instances);
		return this.instances;
	}
	
	protected String convertToJavaStyleInstanceName(String simpleName) {
		if(simpleName == null || simpleName.length() == 0){
			return simpleName;
		}
		String initialCharacter = simpleName.substring(0,1);
		return initialCharacter.toLowerCase() + simpleName.substring(1);
	}

	/**
	 * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
	 *
	 * @param packageName The base package
	 * @return The classes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	protected Class[] getClasses(String packageName)
	        throws ClassNotFoundException, IOException {
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    assert classLoader != null;
	    String path = packageName.replace('.', '/');
	    Enumeration<URL> resources = classLoader.getResources(path);
	    List<File> dirs = new ArrayList<File>();
	    while (resources.hasMoreElements()) {
	        URL resource = resources.nextElement();
	        dirs.add(new File(resource.getFile()));
	    }
	    ArrayList<Class> classes = new ArrayList<Class>();
	    for (File directory : dirs) {
	        classes.addAll(findClasses(directory, packageName));
	    }
	    return classes.toArray(new Class[classes.size()]);
	}

	/**
	 * Recursive method used to find all classes in a given directory and subdirs.
	 *
	 * @param directory   The base directory
	 * @param packageName The package name for classes found inside the base directory
	 * @return The classes
	 * @throws ClassNotFoundException
	 */
	protected List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
	    List<Class> classes = new ArrayList<Class>();
	    if (!directory.exists()) {
	        return classes;
	    }
	    File[] files = directory.listFiles();
	    for (File file : files) {
	        if (file.isDirectory() && this.scanSubpackages) {
	            assert !file.getName().contains(".");
	            classes.addAll(findClasses(file, packageName + "." + file.getName()));
	        } else if (file.getName().endsWith(".class")) {
	            classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
	        }
	    }
	    return classes;
	}

}
