package com.asyncexample.smanip.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SmanipService {
	private static final Logger logger = LoggerFactory.getLogger(SmanipService.class);
	private static final String INPUT_STRING = "SPRINGBOOTASYNC";


	@Async("taskExecutor")
	public CompletableFuture<String> executeTaskOne() {
		long start = System.currentTimeMillis();
        logger.info("Starting Task 1 (First 4 characters) | Thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000); // Simulated delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String result = INPUT_STRING.length() >= 4 ? INPUT_STRING.substring(0, 4) : INPUT_STRING;
        long end = System.currentTimeMillis();

        logger.info("First 4 Characters: {} | Thread: {} | Execution Time: {}ms", result, Thread.currentThread().getName(), (end - start));
        return CompletableFuture.completedFuture(result);
	}

    @Async("taskExecutor")
    public CompletableFuture<String> executeTaskTwo() {
		long start = System.currentTimeMillis();
        logger.info("Starting Task 2 (Last 4 characters) | Thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000); // Simulated delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String result = INPUT_STRING.length() >= 4 ? INPUT_STRING.substring(INPUT_STRING.length() - 4) : INPUT_STRING;
        long end = System.currentTimeMillis();

        logger.info("Last 4 Characters: {} | Thread: {} | Execution Time: {}ms", result, Thread.currentThread().getName(), (end - start));
		return CompletableFuture.completedFuture(result);
	}
	@Async("taskExecutor")
    public CompletableFuture<String> executeTaskThree() {
		long start = System.currentTimeMillis();
        logger.info("Starting Task 3 (Reversed String) | Thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000); // Simulated delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String result = new StringBuilder(INPUT_STRING).reverse().toString();
        long end = System.currentTimeMillis();

        logger.info("Reversed String: {} | Thread: {} | Execution Time: {}ms", result, Thread.currentThread().getName(), (end - start));
        return CompletableFuture.completedFuture(result);
    }
}
