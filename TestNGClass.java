package com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNGClass
{
	
  @Test
  public void test1() 
  {
	System.out.println("In Test 1");  
  }
  
  @Test
  public void test2() 
  {
	  System.out.println("In Test 2");
	  
  }
  @BeforeClass
  public void beforeClass()
  {
	  System.out.println("In Before Class ");
  }

  @AfterClass
  public void afterClass()
  {
	  System.out.println("In After Class");
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("In Before Test");
  }

  @AfterTest
  public void afterTest()
  {
	  System.out.println("In After Test");
  }

}
