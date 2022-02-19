package com.gmail.at.motanmayank.todo.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.gmail.at.motanmayank.todo.bean.Task;

public class ToDoService {
	private ArrayList<Task> taskList = new ArrayList<>();
	private int statusOpen = 0, statusClosed = 0;

	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Display the To do list data from ArrayList
	 * 
	 */

	public void displayInput() {
		int counter = 0;
		int choice;

//  System.out.println("Please Enter your choice - for sorting");
//  System.out.println("1.Sort based on Date");
//  System.out.println("2.Sort based on Project");

		choice = 2; // scanInput();

		if (choice == 1) {
			taskList.sort((Task d1, Task d2) -> d1.getTaskDate().compareTo(d2.getTaskDate()));
		} else if (choice == 2) {
			taskList.sort((Task d1, Task d2) -> d1.getProjectName().compareTo(d2.getProjectName()));
		}
		String format1 = "%-9s %-40s %-43s %-12s %-15s";
		System.out.println(String.format(format1, "Task No", "Task Name", "ProjectName", "Status", " Date"));
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------");

		for (Task task : taskList) {
			counter = counter + 1;

			System.out.println(String.format(format1, counter, task.getTaskName(), task.getProjectName(),
					task.getSatus(), formatter.format(task.getTaskDate())));
			
			String changeCase = task.getSatus().toUpperCase();
			
			if (changeCase.equals("OPEN")) {
				statusOpen = statusOpen + 1;
			} else if (changeCase.equals("CLOSED")) {
				statusClosed = statusClosed + 1;
			}
		}
		System.out.println("Number of Tasks open : " + statusOpen + " Number of Tasks Closed " + statusClosed);
		statusOpen = 0;
		statusClosed = 0;

	}

	public void addRecord(Task task) throws IOException, ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

//* Get the current date. Consider only the Date portion for comparison

		Date today = new Date();
		Date todayWithZeroTime = formatter.parse(formatter.format(today));
		Date inputDateWithZeroTime = formatter.parse(formatter.format(task.getTaskDate()));

		if (inputDateWithZeroTime.compareTo(todayWithZeroTime) < 0) {
			System.out.println("Date Entered should be greater than today");
		} else {
			taskList.add(task);
		}

	}

	/*
	 * Edit the already existing Todo list
	 */

	public void editRecord(int editIndex, String inputField, int changeField) throws IOException, ParseException

	{
		if(taskList.size() <= editIndex ) {
			throw new RuntimeException("Task Index is incorrect. ");
		}
		
		Date date = null;

		if (changeField == 1) {
			taskList.set(editIndex, new Task(inputField, taskList.get(editIndex).getProjectName(), taskList.get(editIndex).getSatus(),
					taskList.get(editIndex).getTaskDate()));
		}
		if (changeField == 2) {
			taskList.set(editIndex, new Task(taskList.get(editIndex).getTaskName(), inputField, taskList.get(editIndex).getSatus(),
					taskList.get(editIndex).getTaskDate()));
		}
		if (changeField == 3) {
			taskList.set(editIndex, new Task(taskList.get(editIndex).getTaskName(), taskList.get(editIndex).getProjectName(),
					inputField, taskList.get(editIndex).getTaskDate()));
		}
		if (changeField == 4) {

			try {

				date = formatter.parse(inputField);

			} catch (ParseException p) {
				System.out.println(" Error occured while editing the arraylist record");
			}

			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			// * Get the current date. Consider only the Date portion for comparison

			Date today = new Date();
			Date todayWithZeroTime = formatter.parse(formatter.format(today));
			Date inputDateWithZeroTime = formatter.parse(formatter.format(date));

			if (inputDateWithZeroTime.compareTo(todayWithZeroTime) < 0) {
				System.out.println("Date Entered should be greater than today");
			} else {
				taskList.set(editIndex, new Task(taskList.get(editIndex).getTaskName(), taskList.get(editIndex).getProjectName(),
						taskList.get(editIndex).getSatus(), date));
			}
		}
	}

	/*
	 * Delete the Todo task which are done or which you don't want to maintain in
	 * the TOdo list
	 */

	public void deleteRecord(int removeindex) throws IOException {
		if(taskList.size() <= removeindex ) {
			throw new RuntimeException("Task Index is incorrect. ");
		}
		taskList.remove(removeindex);

		System.out.println("Record deleted sucessfully ");
	}

	/*
	 * Get the choice from the user.
	 */

	public int scanInput() {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		return i;
	}

}
