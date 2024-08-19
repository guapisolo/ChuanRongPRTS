package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {
	
	@PostMapping("/submit")
	public ResponseEntity<Map<String, String>> handleFormSubmit(@RequestBody Map<String, String> formData) {
        String name = formData.get("name");
        String email = formData.get("email");

        // 处理表单数据，例如添加前缀或其他操作
        Map<String, String> response = new HashMap<>();
        response.put("name", "Processed " + name);
        response.put("email", "Processed " + email);

        return ResponseEntity.ok(response);
    }
}
