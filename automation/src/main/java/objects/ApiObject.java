package objects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shuvashish on 3/10/2018.
 */
public class ApiObject {
    private String id;
    private String status;
    @SerializedName("task name")
    private String taskName;
    private String category;
    @SerializedName("due date")
    private String dueDate;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}
