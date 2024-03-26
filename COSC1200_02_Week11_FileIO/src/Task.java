/* **********************************
File:       Task Class and Interface Definition
Author:     Clint MacDonald
Date:       March 2024
Purpose:    Defining both the task interface and the task instance class
************************************* */
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Queue;
import java.util.LinkedList;
import java.io.*;

interface TaskInterface {
    public void assignToUser(String user);
    public void changeStatus(Task.Status status);
    public String toString();
}

/**
 *
 */
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

    /**
     * Parameterized Constructor
     * @param title - A custom title assigned to the task
     * @param details - A long text description of the task details
     * @param userAssigned - the user currently assigned to the task
     * @param status - the status of the task (using build-in enum)
     * @param priority - the priority of the task (using built-in enum)
     * @param dueDate - the date the task is expected to be completed
     */
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
    public void changeStatus(Status status) {

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

    //<editor-fold desc="Static Methods">

    public static boolean readFromFile(String fileName) throws IOException {
        boolean didWork = false;

        // open input stream to file
        FileReader fr = new FileReader(fileName);
        BufferedReader in = new BufferedReader(fr);

        // read the data from the buffer - add to the tasks queue
        String line = in.readLine();
        while (line != null) {
            System.out.println(line);
            tasks.add(createTaskFromInputFile(line));
            line = in.readLine();
        }

        // MUST close the file
        in.close();
        // fr.close(); // happens automatically anyways with in.close();

        didWork = true;
        return didWork;
    }

    private static Task createTaskFromInputFile(String line) {
        // take line of text and split it by the comma into a String array
        String[] items;
        items = line.split(",");

        // now instantiate the task and populate the properties
        Task task = new Task();
        task.setTitle(items[0]);
        task.setDetails(items[1]);
        task.setUserAssigned(items[2]);
        // status
        for (Status status : Task.Status.values()) {
            if (items[3].equalsIgnoreCase(status.toString())) {
                task.setStatus(status);
            }
        }
        //priority
        for (Priority priority: Task.Priority.values()) {
            if (items[4].equalsIgnoreCase(priority.toString())) {
                task.setPriority(priority);
            }
        }
        task.setDueDate(LocalDate.parse(items[5])); // needs data validation and ex handling

        return task;
    }

    public static boolean writeToFile(String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);   // opens the stream
        BufferedWriter b = new BufferedWriter(fw);  // reserves memory to hold content
        PrintWriter out = new PrintWriter(b);       // pushes content to the file

        for (Task task: tasks) {
            out.println(String.format("%s,%s,%s,%s,%s,%s",
                    task.title, task.details, task.userAssigned,
                    task.status.toString(), task.priority.toString(),
                    task.dueDate.toString()));
        }

        out.close();
        return true;
    }
    //</editor-fold>
}
