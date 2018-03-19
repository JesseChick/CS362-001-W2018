
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {

   private final boolean printStatus = true;

   ResultPair testSchemes[] = { new ResultPair("http://", true),
                                new ResultPair("http//", false),
                                new ResultPair("htp://", false),
                                new ResultPair("", true),
                                new ResultPair("ftp://", true),
                                new ResultPair("f3p://", false)
    };
    ResultPair testAuthorities[] = {new ResultPair("userid:password@example.com", true),
                                    new ResultPair(" shouldfail.com", false),
                                    new ResultPair("www.foo.bar./", false),
                                    new ResultPair("foo.bar/baz", true),
                                    new ResultPair("-a.b.co", false),
                                    new ResultPair("a.b-c.de", true),
    };
    ResultPair testPaths[] = {new ResultPair("", true),
                              new ResultPair("/", true),
                              new ResultPair("/foo", true),
                              new ResultPair("//foo", true),
                              new ResultPair("/foo/bar", true),
                              new ResultPair("/foo//bar", true),
                              new ResultPair("/foo/bar/", true)
    };

   public UrlValidatorTest(String testName) {
      super(testName);
   }



   public void testManualTest()
   {
		UrlValidator urlValidator = new UrlValidator(null, null, 7);
    assertTrue(urlValidator.isValid("http://www.example.com/foo"));
    assertTrue(urlValidator.isValid("http://www.example.com/foo/bar/"));
   }
   public void testManualTest0()
   {

	   UrlValidator urlValidator = new UrlValidator(null,null,7);
	 //this is defineitly valid litterally taken from my computer
		assertTrue(urlValidator.isValid("file:///C:/Users/aaron/Downloads/FinalProject-Part-B%20(1).pdf"));

   }
   public void testManualTest1()
   {
	   UrlValidator urlValidator = new UrlValidator();
		assertTrue(urlValidator.isValid("https://docs.google.com/document/d/1UdJE9-J6HJPgjVcEX1_h5bJ0t1I1l25izZY-Y6QqR2g/edit"));

   }
   public void testManualTest2()
   {
	   UrlValidator urlValidator = new UrlValidator();
		assertTrue(urlValidator.isValid("http://docs.google.com/document/d/1UdJE9-J6HJPgjVcEX1_h5bJ0t1I1l25izZY-Y6QqR2g/edit"));

   }
   public void testManualTest3()
   {
	   UrlValidator urlValidator = new UrlValidator();
		assertTrue(urlValidator.isValid("https://oregonstate.instructure.com/courses/1662159/modules"));

   }
   public void testManualTest4()
   {
	   UrlValidator urlValidator = new UrlValidator();
		assertTrue(urlValidator.isValid("https://www.google.com/search?q=programing+based+testing&rlz=1C1CHBF_enUS697US697&oq=programing+based+testing&aqs=chrome..69i57.6944j0j7&sourceid=chrome&ie=UTF-8"));

   }

   public void testPartitionTestSchemes()
   {
	   UrlValidator urlValidator = new UrlValidator(null,null,0);

	   assertTrue(urlValidator.isValid("http://www.google.com"));
	   assertTrue(urlValidator.isValid("ftp://www.google.com"));
	   assertFalse(urlValidator.isValid("ftp:www.google.com"));
	   assertFalse(urlValidator.isValid("http//www.google.com"));
	   assertFalse(urlValidator.isValid("asdf://www.google.com"));
	   assertFalse(urlValidator.isValid("oqweiur://www.google.com"));
	}

   public void testPartitionTestAuthority()
   {
	   UrlValidator urlValidator = new UrlValidator(null,null,0);

	   assertTrue(urlValidator.isValid("http://www.google.com"));
	   assertTrue(urlValidator.isValid("http://0.0.0.0"));
	  //assertTrue(urlValidator.isValid("google.com"));

	   assertFalse(urlValidator.isValid("http//"));
	   assertFalse(urlValidator.isValid("http//1.2.3.4.5"));
	   assertFalse(urlValidator.isValid("http//.asefk"));
	   assertFalse(urlValidator.isValid("http//asfdl"));
   }
  public void testPartitionTestPort()
   {
	   UrlValidator urlValidator = new UrlValidator(null,null,0);
	   assertTrue(urlValidator.isValid("http://www.google.com:0"));
	   assertTrue(urlValidator.isValid("http://www.google.com:80"));

	   assertFalse(urlValidator.isValid("http://www.google.com:-1"));
	   assertFalse(urlValidator.isValid("http://www.google.com:22a"));
   }
	public void testPartitionTestPathNoOptions()
   {
	   UrlValidator urlValidator = new UrlValidator(null,null,0);
       assertTrue(urlValidator.isValid("http://www.google.com/test1"));
	   assertTrue(urlValidator.isValid("http://www.google.com/test1/"));
	   assertTrue(urlValidator.isValid("http://www.google.com/test1/test2"));
	   assertTrue(urlValidator.isValid("http://www.google.com/"));

	   assertFalse(urlValidator.isValid("http://www.google.com/test1//test2"));
	   //assertFalse(urlValidator.isValid("http://www.google.com/test1/.."));
	   //assertFalse(urlValidator.isValid("http://www.google.com/test1/../"));
   }
   public void testPartitionTestPathOptions()
   {
	   UrlValidator urlValidator = new UrlValidator(null,null,1);
       assertTrue(urlValidator.isValid("http://www.google.com/test1"));
	   assertTrue(urlValidator.isValid("http://www.google.com/test1/"));
	   assertTrue(urlValidator.isValid("http://www.google.com/test1/test2"));
	   assertTrue(urlValidator.isValid("http://www.google.com/"));
	   //assertTrue(urlValidator.isValid("http://www.google.com/test1//test2"));

	   //assertFalse(urlValidator.isValid("http://www.google.com/test1/.."));
	   //assertFalse(urlValidator.isValid("http://www.google.com/test1/../"));
   }
   public void testPartitionTestQuery()
   {
	   UrlValidator urlValidator = new UrlValidator(null,null,0);
       assertTrue(urlValidator.isValid("http://www.google.com?title=Main_page"));
	   assertTrue(urlValidator.isValid("http://www.google.com?color=purple&action=raw"));
	   assertTrue(urlValidator.isValid("http://www.google.com"));

	   //assertFalse(urlValidator.isValid("http://www.google.com?title"));
	    //assertFalse(urlValidator.isValid("http://www.google.com?title="));
   }

   public void testIsValid()
   {
	   //You can use this function for programming based testing
     String url = "";
     UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
     boolean expectedValid, actualValid;
     for (int i=0; i<testSchemes.length; i++) {
       for (int j=0; j<testAuthorities.length; j++) {
         for (int k=0; k<testPaths.length; k++) {
           url = testSchemes[i].item + testAuthorities[j].item + testPaths[k].item;
           expectedValid = testSchemes[i].valid && testAuthorities[j].valid && testPaths[k].valid;
           actualValid = urlVal.isValid(url);
           if (printStatus) {
             if (expectedValid != actualValid) {
               System.out.println("EXPECTED: " + expectedValid + ";\tACTUAL: " + actualValid + ";\t" + url);
             } else {
               // System.out.println("Good: " + url);//expectedValid + "" + actualValid);
             }
           } else {
             assertEquals(expectedValid, actualValid);
           }
         }
       }
     }
   }
}
