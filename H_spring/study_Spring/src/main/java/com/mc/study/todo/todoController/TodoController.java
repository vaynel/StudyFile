package com.mc.study.todo.todoController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("todo")
public class TodoController {

	@GetMapping("/todo")
	public void todo() {
		
	}
	
}
