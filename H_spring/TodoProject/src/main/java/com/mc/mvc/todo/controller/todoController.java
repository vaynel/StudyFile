package com.mc.mvc.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("todo")
public class todoController {

	@GetMapping("/todo-form")
	public void todo() {
		System.out.println("todo-form으로 이동합니다");
		
	}
	
	
}
