package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chuanrong")
public class ChuanrongController {

	public static class Info {
		public String label;
		public Integer score;

		public Info(String label, Integer score) {
			this.label = label;
			this.score = score;
		}
	};

	public static final Map<String, Info> urgentMap;
	static {
		urgentMap = new LinkedHashMap<>();
		urgentMap.put("urgent_null", new Info("无关卡", 0));
		urgentMap.put("urgent_dqyp", new Info("大棋一盘", 30));
		urgentMap.put("urgent_dqyp_plus", new Info("大棋一盘plus", 20));
		urgentMap.put("urgent_xmzb", new Info("血脉之辩", 0));
		urgentMap.put("urgent_ztbr", new Info("遮天蔽日", 0));
		urgentMap.put("urgent_lzdqc", new Info("劳作的清晨", 0));
	}

	public static final Map<String, Info> ageMap;
	static {
		ageMap = new LinkedHashMap<>();
		ageMap.put("age_null", new Info("无年代", 0));
		ageMap.put("age_tz1", new Info("天灾年代1", 5));
		ageMap.put("age_tz2", new Info("天灾年代2", 10));
		ageMap.put("age_tz3", new Info("天灾年代3", 15));
	}

	public static final Map<String, Info> collectMap;
	static {
		collectMap = new LinkedHashMap<>();
		collectMap.put("nj", new Info("宁静之谜", 15));
		collectMap.put("ja", new Info("惧傲之谜", 10));
		collectMap.put("ys", new Info("3之谜", 10));
		collectMap.put("jj", new Info("4之谜", 10));
		collectMap.put("ly", new Info("5之谜", 10));
		collectMap.put("xs", new Info("6之谜", 5));
	}

	public static class Collect {
		public boolean nj;
		public boolean ja;
		public boolean ys;
		public boolean jj;
		public boolean ly;
		public boolean xs;
	}

	public static class FormData {
		public String name;
		public String age;
		public Collect collect;
	}

	public static class ResponseData {
		public String info;
		public Double score;
	}
	// @PostMapping("/submit")
	// public ResponseEntity<Map<String, Integer>> handleFormSubmit(@RequestBody
	// FormData formData) {
	// String name = formData.name;
	// String age = formData.age;

	// // 处理表单数据，例如添加前缀或其他操作
	// Map<String, Integer> response = new HashMap<>();
	// response.put("name", urgentMap.get(name));
	// response.put("age", ageMap.get(age));
	// return ResponseEntity.ok(response);
	// }

	@GetMapping("/urgentMap")
	public ResponseEntity<Map<String, Info>> getUrgentMap() {
		return ResponseEntity.ok(urgentMap);
	};

	@GetMapping("/ageMap")
	public ResponseEntity<Map<String, Info>> getAgeMap() {
		return ResponseEntity.ok(ageMap);
	};

	@GetMapping("/collectMap")
	public ResponseEntity<Map<String, Info>> getCollectMap() {
		return ResponseEntity.ok(collectMap);
	};

	@PostMapping("/submit")
	public ResponseEntity<ResponseData> handleFormSubmit(@RequestBody FormData formData) {
		String name = formData.name;
		String age = formData.age;
		Collect collect = formData.collect;

		// 处理表单数据，例如添加前缀或其他操作
		Integer baseScore = urgentMap.get(name).score;
		Integer ageScore = ageMap.get(age).score;

		// 处理 Collect 类型中的所有布尔字段
		Integer multiplier = 0;
		if (collect.nj) {
			multiplier += collectMap.get("nj").score;
		}
		if (collect.ja) {
			multiplier += collectMap.get("ja").score;
		}
		if (collect.ys) {
			multiplier += collectMap.get("ys").score;
		}
		if (collect.jj) {
			multiplier += collectMap.get("jj").score;
		}
		if (collect.ly) {
			multiplier += collectMap.get("ly").score;
		}
		if (collect.xs) {
			multiplier += collectMap.get("xs").score;
		}

		ResponseData response = new ResponseData();
		response.info = "temp";
		response.score = (1.0 + multiplier / 100.0) * (baseScore + ageScore);

		// System.out.println(baseScore);
		// System.out.println(ageScore);
		// System.out.println(multiplier);
		// System.out.println(response.score);
		return ResponseEntity.ok(response);
	}
}