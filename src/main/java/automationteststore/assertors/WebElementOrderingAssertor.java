package automationteststore.assertors;

import java.util.ArrayList;
import java.util.List;

import automationteststore.helperutilities.WebElementFinderUtils;
import automationteststore.helperutilities.WebElementOrderChecker;
import automationteststore.helperutilities.WebElementOrderCheckerImpl;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebElementOrderingAssertor {

	private String idOfParentWebElement;

	public WebElementOrderingAssertor(String idOfParentWebElement) {
		this.idOfParentWebElement = idOfParentWebElement;
	}

	public WebElementOrderingAssertor() {
		// TODO Auto-generated constructor stub
	}

	public void assertOnOrderOfWebElementsByListOrder(List<String> expectedOrderOfElementIds) {
		List<WebElement> childWebElementsInActualOrder = WebElementFinderUtils
				.findAllChildElementsOfParentElementInActualOrder(idOfParentWebElement);
		assertOnWebElementOrder(childWebElementsInActualOrder, expectedOrderOfElementIds);
	}

	private void assertOnWebElementOrder(List<WebElement> childWebElementsInActualOrder,
			List<String> expectedOrderOfElementIds) {
		WebElementOrderChecker webElementOrderChecker = new WebElementOrderCheckerImpl(childWebElementsInActualOrder);
		Assert.assertTrue(webElementOrderChecker.areWebElementsOrderedLikeSpecifiedListByElementId(
								getModifiableIdListOfExpectedChildElements(expectedOrderOfElementIds)),
				"Web Elements are not in the expected order");
	}

	private List<String> getModifiableIdListOfExpectedChildElements(List<String> elementIds) {
		List<String> ids = new ArrayList<>();
		for (String elementId : elementIds) {
			ids.add(elementId);
		}
		return ids;
	}

	public void assertOnOrderOfWebElementsByListOrder(List<String> expectedOrderOfElementIds,
			WebElement parentElement) {
		List<WebElement> childWebElementsInActualOrder = WebElementFinderUtils
				.findAllChildElementsOfParentElementInActualOrder(parentElement);
		assertOnWebElementOrder(childWebElementsInActualOrder, expectedOrderOfElementIds);
	}

}
