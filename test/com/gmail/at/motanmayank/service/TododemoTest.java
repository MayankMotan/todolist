package com.gmail.at.motanmayank.service;
import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gmail.at.motanmayank.todo.bean.Task;



class TododemoTest {
	
	 ArrayList<Task> taskList = new ArrayList<>();
	 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	 Date date,date1,date2;
	 Task task;
	 
	 @BeforeEach
	 /** 
	  * 
	  * Load the ArrayList with Date before each method execution.
	  */
	 void setup() throws ParseException
	 {
		 date = formatter.parse("2018-10-08");
		 date1 = formatter.parse("2018-10-05");
		 date2 = formatter.parse("2018-10-01");
		 Task task = new Task("Test","Test Project","Open",date);
		 Task task1 = new Task("First","First Project","Open",date1);
		 Task task2 = new Task("Second","Second Project","Closed",date2);
		 
		 taskList.add(task);
		 taskList.add(task1);
		 taskList.add(task2);
	 }
	 
	@Test
	/**
	 * 
	 * Add element to Arraylist and Test whether added element is present in the list.
	 */
	
	void checkWhetherTheElementisAddedinTheArrayList() throws ParseException {
		 
		 assertEquals("Test",taskList.get(0).getTaskName());
		 assertEquals("Test Project",taskList.get(0).getProjectName());
		 assertEquals("Open",taskList.get(0).getSatus());
		 assertEquals(date,taskList.get(0).getTaskDate());
	
	}
	@Test
	/**
	 * 
	 * Add element to Arraylist and Test for the Failure case.
	 */
	
	void checkWhetherTheElementAddedhasFailed() throws ParseException
	{
		
		 assertEquals("Test",taskList.get(0).getTaskName());
		 assertEquals("Test Project",taskList.get(0).getProjectName());
		 assertEquals("Open",taskList.get(0).getSatus());
		 assertEquals(date,taskList.get(0).getTaskDate());
	}
	@Test
	/*
	 * Edit elements in ArrayList and check whether it gets reflected.
	 */
	
	void TestForEditElementinTheListAndCheckWhetherElementisPresent() throws ParseException
	{
		date = formatter.parse("2018-10-10");
		taskList.get(0).setTaskName("Test Edit");
		taskList.get(0).setProjectName("Edit Project");
		taskList.get(0).setStatus("Closed");
		taskList.get(0).setTaskDate(date);
	 		
		taskList.set(0,new Task(taskList.get(0).getTaskName(),taskList.get(0).getProjectName(),taskList.get(0).getSatus(),taskList.get(0).getTaskDate()));
		assertEquals("Test Edit",taskList.get(0).getTaskName());
		assertEquals("Edit Project",taskList.get(0).getProjectName());
		assertEquals("Closed",taskList.get(0).getSatus());
		assertEquals(date,taskList.get(0).getTaskDate());
 }
	@Test
	/*
	 * Check for failure condition of Edit function.
	 */
	
	void TestForEditElementinTheListAndCheckWhetherElementisnotPresent() throws ParseException
	{
		date = formatter.parse("2018-10-10");
		taskList.get(0).setTaskName("Test Edit");
		taskList.get(0).setProjectName("Edit Project");
		taskList.get(0).setStatus("Closed");
		taskList.get(0).setTaskDate(date);
	 		
		taskList.set(0,new Task(taskList.get(0).getTaskName(),taskList.get(0).getProjectName(),taskList.get(0).getSatus(),taskList.get(0).getTaskDate()));
		assertEquals("Test Edit",taskList.get(0).getTaskName());
		assertEquals("Edit Project",taskList.get(0).getProjectName());
		assertEquals("Closed",taskList.get(0).getSatus());
		assertEquals(date,taskList.get(0).getTaskDate());
 }
	@Test
	/*
	 * Check whether element gets successfully deleted from Arraylist
	 */
	
	void checkForDeleteElementFromArrayList()
	{
		taskList.remove(2);
		assertEquals(2,taskList.size());
	}

	@Test
	/*
	 * Check for failure condition of Delete function.
	 */
	
	void checkForDeleteElementFromArrayListFailure()
	{
		taskList.remove(2);
		assertEquals(2,taskList.size());
	}
	@Test
	
	/*
	 * Check whether the Arraylist is sorted. Copy the original list into another list  and sorted the list. Compare the sorted list with original list. 
	 */
	
	void checkWhetherArrayListisSorted()
	{
		ArrayList<Task> sorted = new ArrayList<>(taskList);
		sorted.sort((Task d1,Task d2)->d1.getTaskDate().compareTo(d2.getTaskDate()));
		assertNotEquals(sorted.get(0).getTaskDate(),taskList.get(0).getTaskDate());
	}

	@Test
	/*
	 * 
	 */
	
	void TestForEditElementinTheListAndChecktheDateInWrongFormat() throws ParseException
	{
		//date = formatter.parse("xxxxxx");
		taskList.get(0).setTaskName("Test Edit");
		taskList.get(0).setProjectName("Edit Project");
		taskList.get(0).setStatus("Closed");
		taskList.get(0).setTaskDate(date);
	 		
		taskList.set(0,new Task(taskList.get(0).getTaskName(),taskList.get(0).getProjectName(),taskList.get(0).getSatus(),taskList.get(0).getTaskDate()));
		assertEquals("Test Edit",taskList.get(0).getTaskName());
		assertEquals("Edit Project",taskList.get(0).getProjectName());
		assertEquals("Closed",taskList.get(0).getSatus());
		assertEquals(date,taskList.get(0).getTaskDate());
		
 }
	

}
