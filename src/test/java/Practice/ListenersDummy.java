package Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.genericUtility.BaseClass;
@Listeners(com.scm.genericUtility.ListnersImplementation.class)
public class ListenersDummy extends BaseClass {
@Test(retryAnalyzer=com.scm.genericUtility.RetryImplementation.class)
public void listenersDummyTest() {
	Assert.fail();
}
}
