<template>
	<div id="app">
		<form @submit.prevent="submitForm">
			<!-- 表单字段 -->
			<div class="app-column-container">
				<div class="app-column-1">
					<h3>关卡</h3>
					<div v-if="stageMap">
						<label v-for="(info, key) in stageMap" :key="key">
							<input type="radio" v-model="formData.name" :value="key" />
							{{ info.label }} ({{ info.score }})
							<br>
						</label>
					</div>
				</div>
				<div class="app-column-2">
					<h3>年代</h3>
					<div v-if="ageMap">
						<label v-for="(info, key) in ageMap" :key="key">
							<input type="radio" v-model="formData.age" :value="key" />
							{{ info.label }}{{ info.description }} ({{ info.score }})
							<br>
						</label>
					</div>
					<h3>树洞藏品</h3>
					<div v-if="collectMap">
						<label v-for="(info, key) in collectMap" :key="key">
							<input type="checkbox" v-model="formData.collect[key]" :value="key" />
							{{ info.label }} ({{ info.score }})
							<br>
						</label>
					</div>
				</div>
			</div>
			<br>
			<button class="blue-button" type="submit">Submit</button>
		</form>
		<!-- <div v-if="responseMessage">
			{{ responseMessage }}
		</div> -->
		<!-- <div v-if="responseData">
			<h3>Response Data:</h3>
			<p>Info: {{ responseData.info }}</p>
			<p>Score: {{ responseData.score }}</p>
		</div> -->
		<div v-if="responseHistory.length >= 0">
			<h3>Total Score: {{ totalScore }}</h3>
			<h3>Response History:</h3>
			<ul>
				<li v-for="(response, index) in responseHistory" :key="index">
					{{ response.info }}:
					Score: {{ roundToThreeDecimals(response.score) }}
					<button class="red-button" @click="removeResponse(index)">Delete</button>
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
import axios from 'axios';

export default {
	data() {
		return {
			formData: {
				name: "urgent_null",
				age: "age_null",
				collect: {
					nj: false,
					ja: false,
					ys: false,
					jj: false,
					ly: false,
					xs: false
				}
			},
			responseMessage: "",
			responseData: null,
			responseHistory: [],
			stageMap: null,
			ageMap: null,
			collectMap: null
		};
	},
	computed: {
		totalScore() {
			return this.responseHistory.reduce((sum, response) => sum + response.score, 0);
		}
	},
	mounted() {
		this.fetchStageMap();
		this.fetchAgeMap();
		this.fetchCollectMap();
	},
	methods: {
		async submitForm() {
			try {
				const response = await axios.post('http://localhost:8181/chuanrong/submit', this.formData);
				this.responseMessage = 'Form submitted successfully!';
				this.responseData = response.data; // 解析并绑定响应数据
				this.responseHistory.push({ ...this.responseData }); // 保存 responseData 的副本
			} catch (error) {
				this.responseMessage = 'Error: ' + error.message;
				this.responseData = null;
			}
		},
		removeResponse(index) {
			this.responseHistory.splice(index, 1);
		},
		async fetchStageMap() {
			try {
				const response = await axios.get('http://localhost:8181/chuanrong/stageMap');
				this.stageMap = response.data;
			} catch (error) {
				console.error('Error fetching stageMap:', error);
			}
		},
		async fetchAgeMap() {
			try {
				const response = await axios.get('http://localhost:8181/chuanrong/ageMap');
				this.ageMap = response.data;
			} catch (error) {
				console.error('Error fetching ageMap:', error);
			}
		},
		async fetchCollectMap() {
			try {
				const response = await axios.get('http://localhost:8181/chuanrong/collectMap');
				this.collectMap = response.data;
			} catch (error) {
				console.error('Error fetching collectMap:', error);
			}
		},
		roundToThreeDecimals(value) {
			return parseFloat(value).toFixed(3);
		}
	}
};
</script>

<style scoped>
* {
	color: white;
}

.app-column-container {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
}

.app-column-1 {
	flex: 18;
	align-self: flex-start;
}

.app-column-2 {
	flex: 30;
	align-self: flex-start;
}

.blue-button {
	background-color: blue;
	color: white;
}

.red-button {
	background-color: red;
	color: white;
}
</style>