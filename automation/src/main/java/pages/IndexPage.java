package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Shuvashish on 3/13/2018.
 */
public class IndexPage {

    @FindBy(how = How.XPATH, using = "//form[@name='todo']/ul/li")
    private List<WebElement> allTodoList;
    @FindBy(how = How.XPATH, using = "//input[@name='data']")
    private WebElement dataText;
    @FindBy(how = How.XPATH, using = "//input[@name='data']/following-sibling::input[@name='submit']")
    private WebElement dataSubmit;
    @FindBy(how = How.CSS, using = "input[value='Remove']")
    private WebElement removeButton;
    @FindBy(how = How.CSS, using ="select[name='category']" )
    private WebElement categoryDropdown;
    @FindBy(how = How.CSS, using ="select[name='due_day']" )
    private WebElement dayDropdown;
    @FindBy(how = How.CSS, using ="select[name='due_month']" )
    private WebElement monthDropdown;
    @FindBy(how = How.CSS, using ="select[name='due_year']" )
    private WebElement yearDropdown;
    @FindBy(how = How.CSS, using = "a[href^='delcat.php']>span")
    private List<WebElement> allCategories;
    @FindBy(how = How.CSS, using = "input[name=categorydata]")
    private WebElement categoryText;
    @FindBy(how = How.CSS, using = "input[value='Add category']")
    private WebElement addCategoryButton;

    By todoCheckbox = By.cssSelector("input[name^='todo']");

    public IndexPage addTodoTask(String taskName){
        int sizeAfter;
        int sizeBefore = getTodoListSize();
        dataText.sendKeys(taskName);
        dataSubmit.click();
        sizeAfter = getTodoListSize();
        Assert.assertEquals(sizeBefore+1, sizeAfter);
        return this;
    }

    public  IndexPage addTodoTask(String taskName, String category){
        int sizeAfter;
        int sizeBefore = getTodoListSize();
        dataText.sendKeys(taskName);
        Select categorySelect = new Select(categoryDropdown);
        categorySelect.selectByVisibleText(category);
        dataSubmit.click();
        sizeAfter = getTodoListSize();
        Assert.assertEquals(sizeBefore+1, sizeAfter);
        return this;
    }

    public  IndexPage addTodoTask(String taskName, String category,
                      String day, String month, String year){
        int sizeAfter;
        int sizeBefore = getTodoListSize();
        Select categorySelect = new Select(categoryDropdown);
        Select daySelect = new Select(dayDropdown);
        Select monthSelect = new Select(monthDropdown);
        Select yearSelect = new Select(yearDropdown);
        dataText.sendKeys(taskName);
        categorySelect.selectByVisibleText(category);
        daySelect.selectByVisibleText(day);
        monthSelect.selectByVisibleText(month);
        yearSelect.selectByVisibleText(year);
        dataSubmit.click();
        sizeAfter = getTodoListSize();
        Assert.assertEquals(sizeBefore+1, sizeAfter);
        return this;
    }

    public IndexPage verifyTaskExistInTodoList(String taskName, boolean expectedResult){
        boolean isExist = allTodoList.stream()
                .anyMatch(tdl-> tdl.getText().contains(taskName));
        Assert.assertEquals(isExist, expectedResult);
        return this;
    }

    public IndexPage verifyTaskExistWithCategoryAndDuedate(
            String taskName, boolean expectedResult, String category,
            String day, String month, String year){
        if(day.length()==1)
            day="0"+day;
        String date = day+"/"+getCorrespondingMonth(month)+"/"+year.substring(Math.max(year.length() - 2, 0));
        String finalString = taskName+" ("+date+")"+"("+category+")";

        boolean isExist = allTodoList.stream().anyMatch(tdl -> tdl.getText()
                .contains(finalString));
        Assert.assertEquals(isExist, expectedResult);
        return this;
    }

    public IndexPage deleteTask(String taskName){
        allTodoList.stream().filter(tdl -> tdl.getText().contains(taskName))
                .findFirst().get().findElement(todoCheckbox)
                .click();
        removeButton.click();
        return this;
    }

    public int getTodoListSize(){
        return allTodoList.size();
    }

    public int getCtegoryListSize(){
        return allTodoList.size();
    }

    public IndexPage addCategory(String categoryName){
        int sizeAfter ;
        int sizeBefore = getCtegoryListSize();
        categoryText.sendKeys(categoryName);
        addCategoryButton.click();
        sizeAfter = getCtegoryListSize();
        Assert.assertEquals(sizeBefore+1, sizeAfter);
        return this;
    }

    public IndexPage veifyCategoryExist(String categoryName, boolean expectedResult){
        boolean isExist = allCategories.stream()
                .anyMatch(ac -> ac.getText().equals(categoryName));
        Assert.assertEquals(isExist, expectedResult);
        return this;
    }

    private String getCorrespondingMonth(String stringMonth){
        String numberMonth = "";
        switch (stringMonth){
            case "Jan":
                numberMonth = "01";
                break;
            case "Feb":
                numberMonth = "02";
                break;
            case "Mar":
                numberMonth = "03";
                break;
            case "Apr":
                numberMonth = "04";
                break;
            case "May":
                numberMonth = "05";
                break;
            case "Jun":
                numberMonth = "06";
                break;
            case "Jul":
                numberMonth = "07";
                break;
            case "Aug":
                numberMonth = "08";
                break;
            case "Sep":
                numberMonth = "09";
                break;
            case "Oct":
                numberMonth = "10";
                break;
            case "Nov":
                numberMonth = "11";
                break;
            case "Dec":
                numberMonth = "12";
                break;
        }
    return numberMonth;
    }
}
