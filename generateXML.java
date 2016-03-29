package com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.beust.testng.TestNG;

public class generateXML
{

	
	public static void main(String[] args) throws IOException
	{
		xmlCreation();
		testNGRun();
	}

	public static void testNGRun()
	{
		List<String> file = new ArrayList<String>();
		
		file.add(System.getProperty("user.dir")+"\\testng.xml");
		
		TestNG tng = new TestNG();
		
		tng.setTestSuites(file);
		
		tng.run();
	}
	public static void xmlCreation() throws IOException
	{

		XmlSuite suite = new XmlSuite();
		 suite.setName("Regerssion");
	        suite.setParallel("false");
	        suite.setThreadCount(10);

	        XmlTest test = new XmlTest(suite);
	        test.setName("Test");
	        test.setPreserveOrder("true");

        XmlClass testClass = null;


        ArrayList<XmlClass> classes = new ArrayList<XmlClass>();
        ArrayList<XmlInclude> methodsToRun = new ArrayList<XmlInclude>();

        testClass = new XmlClass();
        testClass.setName("com.TestNGClass");
        methodsToRun.add(new XmlInclude("test1"));
        methodsToRun.add(new XmlInclude("test2"));
        
        testClass.setIncludedMethods(methodsToRun);
        classes.add(testClass);
        test.setXmlClasses(classes);


        //methodsToRun.clear();
        


       /* XmlClass testClass = null;
        
        
        ArrayList<XmlClass> classes = new ArrayList<XmlClass>();
        ArrayList<XmlInclude> methodsToRun = new ArrayList<XmlInclude>();
        
        testClass = new XmlClass();
        testClass.setName("com.TestNGClass");
        methodsToRun.add(new XmlInclude("test1"));
        methodsToRun.add(new XmlInclude("test2"));
        
        testClass.setIncludedMethods(methodsToRun);
        classes.add(testClass);
        test.setXmlClasses(classes);
       */ 
        //methodsToRun.clear();
        File file = new File(System.getProperty("user.dir")+"\\config.xml");
        FileWriter writer = new FileWriter(file);
        writer.write(suite.toXml());
        writer.close(); 

	}
}
