package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.PageObject;

public class StudentPage extends PageObject {

  public StudentPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(css = "div[data-rowindex='0']")
  private WebElement tableItem;

  @FindBy(css = "button[aria-label='add']")
  private WebElement formInsertButton;

  @FindBy(id = "formik-text-field-112")
  private WebElement name;

  @FindBy(id = "formik-text-field-114")
  private WebElement surname;

  @FindBy(id = "formik-text-field-116")
  private WebElement accountName;

  @FindBy(id = "formik-text-field-118")
  private WebElement email;

  @FindBy(id = "formik-text-field-120")
  private WebElement bankCardNumber;

  @FindBy(css = "button[data-test-id='save']")
  private WebElement saveButton;

  @FindBy(css = "button[data-test-id='delete']")
  private WebElement deleteButton;

  @FindBy(css = "button[data-test-id='courses']")
  private WebElement toggleCoursesButton;

  @FindBy(css = "button[data-test-id='add-courses']")
  private WebElement addCoursesButton;

  @FindBy(id = "formik-select-field-428")
  private WebElement courseDropDownList;

  @FindBy(css = "button[data-test-id='cancel']")
  private WebElement cancelButton;

  @FindBy(css = "data-field='courseName'")
  private WebElement courseName;

  @FindBy(css = "data-field='classesBought'")
  private WebElement classesBought;

  @FindBy(id = "formik-select-field-498")
  private WebElement newCourseDropDownList;

  @FindBy(id = "formik-text-field-500")
  private WebElement newCourseClassesBought;

  @FindBy(className = "MultiTablePagination-caption")
  private WebElement tablePagination;

  public boolean isInitialized() {
    return name.isDisplayed();
  }

  public int getNumberOfEntries() {
    return Integer.parseInt(tablePagination.getAttribute("innerText").split(" ")[2]);
  }

  public void addStudent() {
    this.formInsertButton.click();

    this.name.sendKeys("name");
    this.surname.sendKeys("surname");
    this.accountName.sendKeys("accountName");
    this.email.sendKeys("email@email.com");
    this.bankCardNumber.sendKeys("12345678");

    this.saveButton.click();
  }

  public void updateStudent() {
    this.tableItem.click();

    this.name.sendKeys("_updated");
    this.surname.sendKeys("_updated");
    this.email.clear();
    this.email.sendKeys("updatedEmail@email.com");

    this.saveButton.click();
  }
}
