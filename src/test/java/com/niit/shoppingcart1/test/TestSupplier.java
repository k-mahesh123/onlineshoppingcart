package com.niit.shoppingcart1.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopinngcart1.model.Supplier;
import com.niit.shopinngcart1.service.SupplierService;

import junit.framework.TestCase;

public class TestSupplier extends TestCase {
	
	
	@Autowired
	static SupplierService supplierservice;
	@Autowired
	static Supplier supplier;
	@Autowired
	static AnnotationConfigApplicationContext context;
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplier=(Supplier)context.getBean("supplier");
		supplierservice=(SupplierService)context.getBean("supplierImpl");
		
	}
	 
	@Test
		public static void get()
		{
			supplier=supplierservice.getSingleSupplier(12);
			System.out.println(supplier);
			Assert.assertEquals("category test case",12, supplier.getSupid());
	}
   @Test
   public void getAllSuppliers()
   {
	   int size= supplierservice.getAllSuppliers().size();
	   Assert.assertEquals("length check",3, size);
   }
//   @Test
//   public static void saveTestCase()
//   {
//	   supplier.setSupid(12);
//	   supplier.setSupname("mahesh");
//	   supplier.setSupaddress("Dilsuknagar");
//	   supplier.setSupcontact("9703208911");
//	   
//	   Assert.assertThat("save test case", true,supplierservice.save(supplier));
//   }
 //  @Test
//   public void updateTestCase()
//   {
//	   
//	  supplier=supplierservice.getSingleSupplier(10);
//	   supplier.setSupaddress("AS rao nagar");
//	   Assert.assertSame("update test case", true,supplierservice.update(supplier));
//   }
//   @Test
//   public void deleteTestCase() {
//	   
//	  supplierservice.deleteSupplier("SN03");
//	  
//	   
//   }

}
