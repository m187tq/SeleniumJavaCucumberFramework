package automationteststore.helperutilities;

import java.util.ArrayList;
import java.util.List;

import automationteststore.exceptions.TableRowDoesNotExistException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WebElementFinderUtils {
	static WebDriver driver;

	public static List<WebElement> findAllChildElementsOfParentElementInActualOrder(String idOfParentElement) {
		WebElement parentWebElement = driver.findElement(By.id(idOfParentElement));
		List<WebElement> childWebElementsInActualOrder = parentWebElement.findElements(By.xpath(".//*"));
		return childWebElementsInActualOrder;
	}

	public static WebElement findTableRow(String idOfTableBodyElement, int rowNumber)
			throws TableRowDoesNotExistException {
		List<WebElement> rowsInActualOrder = findAllTableRows(idOfTableBodyElement);
		TableRowDoesNotExistException.checkIfTableRowExistsOrElseThrowException(
				"The specified row does not exist within the Table.", rowsInActualOrder, rowNumber);
		return !rowsInActualOrder.isEmpty() ? rowsInActualOrder.get(rowNumber) : null;
	}

	public static List<WebElement> findAllTableRows(String idOfTableBodyElement) {
		List<WebElement> childWebElementsInActualOrder = findAllChildElementsOfParentElementInActualOrder(
				idOfTableBodyElement);
		List<WebElement> rowsInActualOrder = new ArrayList<>();
		for (WebElement element : childWebElementsInActualOrder) {
			if (element.getTagName().equals("tr")) {
				rowsInActualOrder.add(element);
			}
		}

		return rowsInActualOrder;
	}

	public static List<WebElement> findAllChildElementsOfParentElementInActualOrder(WebElement parentWebElement) {
		List<WebElement> childWebElementsInActualOrder = parentWebElement.findElements(By.xpath(".//*"));
		String tagName = childWebElementsInActualOrder.get(childWebElementsInActualOrder.size() - 1).getText();
		return childWebElementsInActualOrder;
	}

}
