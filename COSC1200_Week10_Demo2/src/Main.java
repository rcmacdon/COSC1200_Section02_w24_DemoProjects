/* **********************************
File:       Task Management System Main File
Author:     Clint MacDonald
Date:       March 2024
Purpose:    To learn Enums, Interfaces, and Queues
************************************* */
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        
        Task task1 = new Task();
        task1.setTitle("Task Number 1");
        task1.setDetails("Some things to do here when we have time!");
        task1.setStatus(Task.Status.PENDING);
        task1.setPriority(Task.Priority.MEDIUM);
        task1.setDueDate(LocalDate.now().plusDays(7));

        System.out.println("Task1");
        System.out.print(task1.toString());
    }
}