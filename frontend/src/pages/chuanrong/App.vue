<template>
	<div>
		<form @submit.prevent="submitForm">
			<!-- 表单字段 -->
			<div>
				<div v-if="urgentMap">
					<label v-for="(info, key) in urgentMap" :key="key">
						<input type="radio" v-model="formData.name" :value="key" />
						{{ info.label }} ({{ info.score }})
					</label>
				</div>
			</div>
			<div>
				<div v-if="ageMap">
					<label v-for="(info, key) in ageMap" :key="key">
						<input type="radio" v-model="formData.age" :value="key" />
						{{ info.label }} ({{ info.score }})
					</label>
				</div>
			</div>
			<div>
				<div v-if="collectMap">
					<label v-for="(info, key) in collectMap" :key="key">
						<input type="checkbox" v-model="formData.collect[key]" :value="key" />
						{{ info.label }} ({{ info.score }})
					</label>
				</div>
			</div>
			<button type="submit">Submit</button>
		</form>
		<div v-if="responseMessage">
			{{ responseMessage }}
		</div>
		<div v-if="responseData">
			<h3>Response Data:</h3>
			<p>Info: {{ responseData.info }}</p>
			<p>Score: {{ responseData.score }}</p>
		</div>
		<div>
			<h3>Response History:</h3>
			<ul>
				<li v-for="(response, index) in responseHistory" :key="index">
					<p>Info: {{ response.info }}</p>
					<p>Score: {{ response.score }}</p>
				</li>
			</ul>
		</div>
		<div v-if="responseHistory.length >= 0">
			<h3>Total Score: {{ totalScore }}</h3>
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
			urgentMap: null,
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
		this.fetchUrgentMap();
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
		async fetchUrgentMap() {
			try {
				const response = await axios.get('http://localhost:8181/chuanrong/urgentMap');
				this.urgentMap = response.data;
			} catch (error) {
				console.error('Error fetching urgentMap:', error);
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
		}
	}
};
</script>

<style scoped>
* {
	color: white;
}
</style>