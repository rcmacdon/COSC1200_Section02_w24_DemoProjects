/* **********************************
File:       Task Class and Interface Definition
Author:     Clint MacDonald
Date:       March 2024
Purpose:    Defining both the task interface and the task instance class
************************************* */
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Queue;
import java.util.LinkedList;

interface TaskInterface {
    public void assignToUser(String user);
    public void changeStatus(Task.Status status);
    public String toString();
}

public class Task implements TaskInterface {

    //<editor-fold desc="Static Variables and Globals">
    public static int taskAutoID = 1;
    public static Queue<Task> tasks = new LinkedList<Task>();

    public static enum Status {
        PENDING,
        IN_PROGRESS,
        TESTING,
        FOR_REVIEW,
        COMPLETE,
        CLOSED,
        CANCELLED
    }

    public static enum Priority {
        LOW,
        MEDIUM,
        HIGH,
        EMERGENCY
    }
    //</editor-fold>

    //<editor-fold desc="Properties">
    private int taskID;
    private String title;
    private String details;
    private String userAssigned;
    private Status status;
    private Priority priority;
    private LocalDate dueDate;
    //</editor-fold>

    //<editor-fold desc="Getters and Setters">

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID() {
        this.taskID = taskAutoID++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUserAssigned() {
        return userAssigned;
    }

    public void setUserAssigned(String userAssigned) {
        this.userAssigned = userAssigned;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    //</editor-fold>

    //<editor-fold desc="Constructors">
    // Default Constructor
    public Task() {
        setTaskID();
    }

    // Parameterized Constructor
    public Task(String title, String details, String userAssigned,
                Status status, Priority priority, LocalDate dueDate) {
        setTaskID();
        setTitle(title);
        setDetails(details);
        setUserAssigned(userAssigned);
        setStatus(status);
        setPriority(priority);
        setDueDate(dueDate);
    }

    //</editor-fold>

    //<editor-fold desc="Instance Methods">
    public void assignToUser(String user) {

    };
    public void changeStatus(Task.Status status) {

    };

    @Override
    public String toString() {
        return String.format("""
                TaskID:     %d
                User:       %s
                Title:      %s
                Details:    %s
                Priority:   %s
                Status:     %s
                Due Date:   %s
                """, taskID, userAssigned, title, details, priority, status,
                dueDate.toString());

    }
    //</editor-fold>
}
