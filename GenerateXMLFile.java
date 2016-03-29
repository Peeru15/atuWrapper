package com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class GenerateXMLFile {

	public static void main(String[] args) throws IOException
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
	        testClass.setName("ClassName1");
	        methodsToRun.add(new XmlInclude("Method01"));
	        methodsToRun.add(new XmlInclude("Method02"));
	        methodsToRun.add(new XmlInclude("Method03"));
	        methodsToRun.add(new XmlInclude("Method04"));
	        methodsToRun.add(new XmlInclude("Method05"));

	        testClass.setIncludedMethods(methodsToRun);
	        classes.add(testClass);
	        test.setXmlClasses(classes);


	        methodsToRun.clear();

	        XmlClass testClass1 = new XmlClass();
	        testClass1.setName("ClassName21");
	        methodsToRun.add(new XmlInclude("Method21"));
	        methodsToRun.add(new XmlInclude("Method22"));
	        methodsToRun.add(new XmlInclude("Method23"));
	        methodsToRun.add(new XmlInclude("Method24"));
	        methodsToRun.add(new XmlInclude("Method25"));

	        testClass1.setIncludedMethods(methodsToRun);
	        classes.add(testClass1);

	        test.setXmlClasses(classes);

	        File file = new File(System.getProperty("user.dir")+"\\src\\TestNG.xml");
	        System.out.println("file"+file);

	        FileWriter writer = new FileWriter(file);
	        writer.write(suite.toXml());
	        writer.close(); 
		// TODO Auto-generated method stub

	}

}
