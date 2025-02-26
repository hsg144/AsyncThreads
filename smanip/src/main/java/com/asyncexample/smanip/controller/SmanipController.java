package com.asyncexample.smanip.controller;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asyncexample.smanip.service.SmanipService;

@RestController
@RequestMapping("/async")
public class SmanipController {
	private final SmanipService smanipService;
	public SmanipController(SmanipService smanipService) {
		this.smanipService = smanipService;
	}
	@GetMapping("/run-tasks")
	public String triggerAsyncTasks() {

		CompletableFuture<String> task1 = smanipService.executeTaskOne();
        CompletableFuture<String> task2 = smanipService.executeTaskTwo();
        CompletableFuture<String> task3 = smanipService.executeTaskThree();

        CompletableFuture.allOf(task1, task2, task3).join(); // Wait for all tasks to complete

        return "String manipulation tasks started asynchronously! ";

	}

}
