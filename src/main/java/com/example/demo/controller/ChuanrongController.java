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
		public String description;

		public Info(String label, Integer score) {
			this.label = label;
			this.score = score;
			this.description = "";
		}

		public Info(String label, Integer score, String description) {
			this.label = label;
			this.score = score;
			this.description = description;
		}
	};

	public static final Map<String, Info> stageMap;
	static {
		stageMap = new LinkedHashMap<>();
		stageMap.put("urgent_null", new Info("无关卡加分", 0));
		stageMap.put("urgent_cdbx", new Info("拆东补西清刺", 15));
		stageMap.put("urgent_yxqc", new Info("有序清场清刺", 20));
		stageMap.put("urgent_dqyp", new Info("大棋一盘", 30));
		stageMap.put("urgent_dqyp_plus", new Info("大棋一盘苦难年代无藏", 50));
		stageMap.put("urgent_klmd", new Info("溃乱魔典", 40));
		stageMap.put("urgent_nddc", new Info("年代断层清刺", 40));
		stageMap.put("urgent_jxdc", new Info("假想对冲", 30));
		stageMap.put("urgent_xhyd", new Info("猩红甬道", 40));
		stageMap.put("urgent_xhyd_plus", new Info("猩红甬道奇观年代", 50));
		stageMap.put("urgent_wztm", new Info("巫咒同盟", 20));
		stageMap.put("urgent_jhgz", new Info("计划耕种", 40));
		stageMap.put("urgent_tdfs", new Info("通道封锁", 40));
		stageMap.put("urgent_jrccx", new Info("寄人城池下", 30));
		stageMap.put("urgent_mqgs", new Info("谋求共识", 60));
		stageMap.put("urgent_ssdkq", new Info("神圣的渴求", 50));
		
		stageMap.put("urgent_hrms", new Info("或然面纱", 40));
		stageMap.put("urgent_lgdty", new Info("离歌的庭院", 50));

		stageMap.put("end_1", new Info("一结局紧急授课", 100));
		stageMap.put("end_2", new Info("二结局朝谒", 250));
		stageMap.put("end_3", new Info("三结局圣城", 300));
		// stageMap.put("end_swhl_1", new Info("思维混乱一结局（额外加分）", 20));
		// stageMap.put("end_swhl_23", new Info("思维混乱二三结局（额外加分）", 50));
		// stageMap.put("end_qg", new Info("奇观年代完成结局（额外加分）", 50));
		// stageMap.put("end_mw_12", new Info("魔王年代完成一二结局（额外加分）", 20));
		// stageMap.put("end_mw_3", new Info("魔王年代完成三结局（额外加分）", 50));
	}

	public static final Map<String, Info> ageMap;
	static {
		ageMap = new LinkedHashMap<>();
		ageMap.put("age_null", new Info("无年代加分", 0, "：无年代，繁荣年代，魔王年代，哲学年代，悖论年代"));
		ageMap.put("age_tz1", new Info("天灾年代1", 5, "：清理至少2根年代之刺"));
		ageMap.put("age_tz2", new Info("天灾年代2", 10, "：清理至少3根年代之刺，饮泣之刺视为3根年代之刺"));
		ageMap.put("age_tz3", new Info("天灾年代3", 15, "：清理至少4根年代之刺，饮泣之刺视为3根年代之刺"));
		ageMap.put("age_jr1", new Info("金融年代1", 10, "：全程无漏通关"));
		ageMap.put("age_jr2", new Info("金融年代2", 20, "：持有巴别塔誓言或思绪混乱进入战斗并无漏"));
		ageMap.put("age_jr3", new Info("金融年代3", 40, "：同时持有思绪混乱和巴别塔誓言进入战斗并无漏"));
		ageMap.put("age_yj1", new Info("拥挤年代1", 15, "：同时部署人数小于等于3完成战斗"));
		ageMap.put("age_yj2", new Info("拥挤年代2",25, "：同时部署人数小于等于3无漏过关"));
		ageMap.put("age_yj3", new Info("拥挤年代3", 40, "：同时部署人数小于等于2无漏过关"));
		ageMap.put("age_qg1", new Info("奇观年代1", 10, "：未使用灵感进入战斗并胜利"));
		ageMap.put("age_qg2", new Info("奇观年代2", 15, "：未使用灵感进入战斗并全程无漏通关"));
		ageMap.put("age_qg3", new Info("奇观年代3", 40, "：未使用灵感进入战斗并全程无漏通关，且战斗包含至少一个领袖级敌人"));
		ageMap.put("age_kn1", new Info("苦难年代1", 20, "：在药枚、筑墙、活木甲不生效的情况下完成战斗"));
		ageMap.put("age_kn2", new Info("苦难年代2", 40, "：在药枚、筑墙、活木甲不生效的情况下无漏完成战斗"));
		ageMap.put("age_kn3", new Info("苦难年代3", 70, "：在药枚、筑墙、活木甲不生效的情况下干员不主动撤退或被击倒无漏完成战斗"));
	}

	public static final Map<String, Info> collectMap;
	static {
		collectMap = new LinkedHashMap<>();
		collectMap.put("nj", new Info("宁静之谜", 15));
		collectMap.put("ja", new Info("惧傲之谜", 10));
		collectMap.put("ys", new Info("预示之谜", 10));
		collectMap.put("jj", new Info("结晶之谜", 10));
		collectMap.put("ly", new Info("烙印之谜", 10));
		collectMap.put("xs", new Info("血税之谜", 5));
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
	// response.put("name", stageMap.get(name));
	// response.put("age", ageMap.get(age));
	// return ResponseEntity.ok(response);
	// }

	@GetMapping("/stageMap")
	public ResponseEntity<Map<String, Info>> getStageMap() {
		return ResponseEntity.ok(stageMap);
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
		Integer baseScore = stageMap.get(name).score;
		Integer ageScore = ageMap.get(age).score;

		ResponseData response = new ResponseData();
		response.info = stageMap.get(name).label + ", " + ageMap.get(age).label;

		// 处理 Collect 类型中的所有布尔字段
		Integer multiplier = 0;
		if (collect.nj) {
			multiplier += collectMap.get("nj").score;
			response.info += ", " + collectMap.get("nj").label;
		}
		if (collect.ja) {
			multiplier += collectMap.get("ja").score;
			response.info += ", " + collectMap.get("ja").label;
		}
		if (collect.ys) {
			multiplier += collectMap.get("ys").score;
			response.info += ", " + collectMap.get("ys").label;
		}
		if (collect.jj) {
			multiplier += collectMap.get("jj").score;
			response.info += ", " + collectMap.get("jj").label;
		}
		if (collect.ly) {
			multiplier += collectMap.get("ly").score;
			response.info += ", " + collectMap.get("ly").label;
		}
		if (collect.xs) {
			multiplier += collectMap.get("xs").score;
			response.info += ", " + collectMap.get("xs").label;
		}

		response.score = (1.0 + multiplier / 100.0) * (baseScore + ageScore);

		// System.out.println(baseScore);
		// System.out.println(ageScore);
		// System.out.println(multiplier);
		// System.out.println(response.score);
		return ResponseEntity.ok(response);
	}
}