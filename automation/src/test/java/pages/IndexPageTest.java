package pages;

import browser.Browser;
import org.testng.annotations.Test;

/**
 * Created by Shuvashish on 3/13/2018.
 */
public class IndexPageTest extends SeleniumTestBase{

    @Test
    //This test is just to verify that we can add a task without due date and category
    //In the end I deleted the task and made sure task is not shown in the list
    public void verifyTaskCanBeAddedWithoutCategoryAndDueDate(){
        String taskName = "JustTest";
        Browser.openBrowser().addTodoTask(taskName)
                .verifyTaskExistInTodoList(taskName, true)
                .deleteTask(taskName)
                .verifyTaskExistInTodoList(taskName, false);
    }

    @Test
    //This test is just to verify that we can add a task without due date
    //In the end I deleted the task and made sure task is not shown in the list
    public void verifyTaskCanBeAddedWithCategoryAndWioutDueDate(){
        String taskName = "JustTest";
        Browser.openBrowser().addTodoTask(taskName,"Work")
                .verifyTaskExistInTodoList(taskName, true)
                .deleteTask(taskName)
                .verifyTaskExistInTodoList(taskName, false);
    }

    @Test
    //This test is just to verify that we can add a task with due date and category
    //And verified the way task is shown(task name+date+category) in the list
    //In the end I deleted the task and made sure task is not shown in the list
    public void verifyTaskCanBeAddedWithCategoryAndDueDate(){
        String taskName = "JustTest";
        String category = "Work";
        String day = "4";
        String month = "Apr";
        String year = "2018";
        Browser.openBrowser().addTodoTask(taskName,category,day, month, year)
                .verifyTaskExistWithCategoryAndDuedate(taskName,true, category,day, month, year )
                .deleteTask(taskName)
                .verifyTaskExistInTodoList(taskName, false);
    }

    @Test
    //Add a category
    public void verifyCategoryShowWhenCategoryAdded(){
        String categoyName = "Test";
        Browser.openBrowser()
                .addCategory(categoyName)
                .veifyCategoryExist(categoyName, true);
    }

}
