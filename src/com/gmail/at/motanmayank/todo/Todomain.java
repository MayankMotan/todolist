package com.gmail.at.motanmayank.todo;

import java.io.IOException;
import java.text.ParseException;

import com.gmail.at.motanmayank.todo.bean.TaskInput;

public class Todomain {

	public static void main(String[] args) throws IOException, ParseException {

		TaskInput taskInput = new TaskInput();
		taskInput.displayOption();
	}
}
