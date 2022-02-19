package com.gmail.at.motanmayank.todo.bean;

/*
 * Gives option to the user the Action to be performed on Todo List.
 */
import java.io.IOException;
import java.util.*;

import com.gmail.at.motanmayank.todo.service.ToDoService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class TaskInput {

	private int option, taskNo;
	private boolean setExit = false;
	private String status, taskName, projectName, taskDate;
	private int changeField;
	private ToDoService toDoService;
	private Date date;
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	public TaskInput() {
		toDoService = new ToDoService();
	}
	
	public void displayOption() throws ParseException {
		


		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("  %55s", "                To do List Actions         "));
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%45s", "      1- Display List      "));
		System.out.println(String.format("%45s", "      2- Add New Task      "));
		System.out.println(String.format("%45s", "      3- Edit Task         "));
		System.out.println(String.format("%45s", "      4- Delete Task       "));
		System.out.println(String.format("%45s", "      5- Exit       "));
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		
		System.out.print(" Select action number :");
		option = scanInput();

		while (!(setExit)) {
			if (option < 1 || option > 5)
			{
				System.out.println("Invalid option selected. Please select valid option");
				option = scanInput();
			}
			/*
			 * Display the To do list task
			 */
			if (option == 1) {
				displayTask();
			}

			/*
			 * Add new task to the list
			 */
			if (option == 2) {
				addTask();
			}

			/*
			 * Edit the Todo List
			 */
			if (option == 3) {
				editTask();
			}

			/*
			 * Delete the task from the list
			 */
			if (option == 4) {
				deleteTask();
			}

			/*
			 * Save and Exit
			 */
			if (option == 5) {
				saveExittask();
			}
		}
		
		System.out.println("********** Program exited ssuccessfully ***********");
	}

	public int scanInput() {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		return i;
	}

	/*
	 * Read the input FileReader
	 */
	public String scanString() {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		return line;
	}

	/*
	 * Add task
	 */
	private void addTask() throws ParseException {
		System.out.println("Enter the Task name   :  ");
		taskName = scanString();
		System.out.println("Enter the ProjectName :  ");
		projectName = scanString();
		System.out.println("Enter the Status      :  ");
		status = scanString();
		System.out.println("Enter the TaskDate(yyyy-MM-dd)      :  ");
		taskDate = scanString();
		try {
			date = formatter.parse(taskDate);

		} catch (ParseException p) {
			System.out.println(" Error occured while trying to covert date ");
		}

		try {
			//toDoService.addRecord(taskName, projectName, status, date);
			toDoService.addRecord(new Task(taskName, projectName, status, date)); 
			System.out.println("Task addeed successfully.");
			
			System.out.println("Enter the option");
			option = scanInput();
		} catch (IOException f) {
			System.out.println("Problem occured when trying to add a record ");
		}
		
		
	}

	/*
	 * edit task
	 */
	private void editTask() throws ParseException {
		System.out.println("Enter the Task No you want  to Edit");
		taskNo = scanInput();
		taskNo = taskNo - 1;
		System.out.println("Enter the field you want to Edit");
		System.out.println("1.Task Name  ");
		System.out.println("2.Project Name ");
		System.out.println("3.Status ");
		System.out.println("4.Date");
		option = scanInput();
		if (option == 1) {
			System.out.println("Edit the Task Name : ");
			taskName = scanString();
			changeField = 1;
			try {
				toDoService.editRecord(taskNo, taskName, changeField);
			}catch (RuntimeException ex) {
				System.out.println(ex.getMessage()); 
			} 			
			catch (IOException e) {

				System.out.println("Error occured while trying to edit Task Name");
			}
			System.out.println("Enter the option");
			option = scanInput();

		}
		if (option == 2) {
			System.out.println("Edit the Project Name : ");
			projectName = scanString();
			changeField = 2;
			try {
				toDoService.editRecord(taskNo, projectName, changeField);

			} catch (IOException f) {
				System.out.println("Error occured while trying to edit ProjectName");
			}
			System.out.println("Enter the option");
			option = scanInput();

		}
		if (option == 3) {
			System.out.println("Edit the status : ");
			status = scanString();
			changeField = 3;
			try {
				toDoService.editRecord(taskNo, status, changeField);
			} catch (IOException g) {
				System.out.println("Error occured while trying to edit Staus");
			}
			System.out.println("Enter the option");
			option = scanInput();
		}
		if (option == 4) {
			System.out.println("Edit the TaskDate(yyyy-MM-dd) : ");
			taskDate = scanString();
			changeField = 4;
			try {
				toDoService.editRecord(taskNo, taskDate, changeField);
			} catch (IOException g) {
				System.out.println("Error occured while trying to edit Date");
			}
			System.out.println("Enter the option");
			option = scanInput();
		}
	}

	/*
	 * delete task
	 */
	private void deleteTask() {
		System.out.println("Enter the Task No you want  to delete ");
		taskNo = scanInput();
		taskNo = taskNo - 1;
		try {
			toDoService.deleteRecord(taskNo);
		}catch (RuntimeException ex) {
			System.out.println(ex.getMessage()); 
		}  catch (IOException g) {
			System.out.println(" Problem occured when trying to delete a record");
		}
		System.out.println("Enter the option");
		option = scanInput();
	}

	/*
	 * Save and Exit task
	 */
	private void saveExittask() {

		setExit = true;
	}

	/*
	 * Display Task
	 */
	private void displayTask() {
		toDoService.displayInput();
		System.out.print("Enter the option :");
		option = scanInput();
	}
}
