package Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgPracticeTest {
	@BeforeSuite
	public void bsuite()
	{
		System.out.println("before suite");
	}
	@BeforeTest
	public void btest()
	{
		System.out.println("before test");
	}
	@BeforeMethod
	public void bmethod1()
	{
		System.out.println("before method1");
	}
	@BeforeMethod
	public void bmethod2()
	{
		System.out.println("before method2");
	}
	@BeforeClass
	public void bclass()
	{
		System.out.println("before class");
	}
	@Test(enabled=false)
	public void acttest1()
	{
		System.out.println("mumbai");
	}
	@AfterMethod
	public void aftrmethod()
	{
		System.out.println("after method");
	}

	@Test(dependsOnMethods ="acttest3" )
	public void acttest2()
	{ 
	    
		System.out.println("karnataka");
	}

	@Test(priority = 0,invocationCount = 2)
	public void acttest3()
	{
		System.out.println("india");
	}

	@AfterClass
	public void afrclass()
	{
		System.out.println("after class");
	}
	@AfterSuite
	public void afrsuite()
	{
		System.out.println("after suite");
	}
	}

