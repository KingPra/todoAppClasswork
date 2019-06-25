package com.kingpra.todoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoListController {

	@Autowired
	private TodoRepository todoRepo;

	@GetMapping({ "/" })
	public String getIndexPage(Model model) {
		model.addAttribute("todos", todoRepo.findAll());
		return "index";
	}

	@GetMapping("/new")
	public String addNewTodoPage() {
		return "new";
	}

	@GetMapping("/edit/{id}")
	public String getEditPage(@PathVariable Long id, Model model) {
		model.addAttribute("todo", todoRepo.findById(id));
		return "edit";
	}

	@PostMapping("/")
	public String addNewTask(Todo todo, Model model) {
		todoRepo.save(todo);
		model.addAttribute("todos", todoRepo.findAll());
		return "index";
	}

	@PostMapping("/delete/{id}")
	public String deleteTask(@PathVariable Long id, Model model) {
		todoRepo.deleteById(id);
		model.addAttribute("todos", todoRepo.findAll());
		return "index";
	}

	@PostMapping("/edit/{id}")
	public String editTask(Todo todo, @PathVariable Long id, Model model) {
		Todo task = todoRepo.findById(id).orElse(null);
		task.setTask(task.getTask());
		model.addAttribute("todos", todoRepo.findAll());
		return "index";
	}
}
