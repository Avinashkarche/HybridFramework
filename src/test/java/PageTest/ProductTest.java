package PageTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentListeners.TestNGListeners;
import pages.ProductPage;

public class ProductTest extends TestNGListeners {
	
	
	@Test(priority = 3)
	public void validateFilter()
	{
	int count = productpage.applyFilters();
	test.info("To get the no of product");

	Assert.assertEquals(count, 1);
	test.info("Validated product Count");
	}

	@Test(priority = 4)
	public void resetFilterValidation() {

		int cardcount = productpage.resetFilters();
		test.info("Filter reset");

		boolean isgreater = cardcount>1;

		Assert.assertEquals(isgreater, true);
		test.info("succesfully validated filter has been reset");

	}

	@Test(priority = 5)
	public void sortingFilter() throws InterruptedException
	{
		productpage.sortingByValue("Price High to Low");
		test.info("Sorting the product from high to low");

		Thread.sleep(2000);

		productpage.sortingByValue("Name Z - A");
		test.info("Sorting the product from A-Z");
	}

	@Test(priority = 6)
	public void navToProduct()
	{
		productpage.applyFilters();
		test.info("Reset the filters");

		productpage.clickOnProduct();
		test.info("Click on the product");
	}
}
