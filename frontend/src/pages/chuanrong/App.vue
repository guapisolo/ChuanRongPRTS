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
			<!-- <div>
				<label>
					<input type="radio" v-model="formData.age" value="age_null" />
					无年代
				</label>
				<label>
					<input type="radio" v-model="formData.age" value="age_tz1" />
					天灾年代1
				</label>
				<label>
					<input type="radio" v-model="formData.age" value="age_tz2" />
					天灾年代2
				</label>
				<label>
					<input type="radio" v-model="formData.age" value="age_tz3" />
					天灾年代3
				</label>
				<label>
					<input type="radio" v-model="formData.age" value="age_jr1" />
					金融年代
				</label>
				<label>
					<input type="radio" v-model="formData.age" value="age_yj1" />
					拥挤年代
				</label>
				<label>
					<input type="radio" v-model="formData.age" value="age_qg1" />
					奇观年代
				</label>
				<label>
					<input type="radio" v-model="formData.age" value="age_kn1" />
					苦难年代
				</label>
			</div>
			<div>
				<label>
					<input type="checkbox" v-model="formData.collect.nj" value="collect_nj" />
					宁静之谜
				</label>
				<label>
					<input type="checkbox" v-model="formData.collect.ja" value="collect_ja" />
					惧傲之谜
				</label>
				<label>
					<input type="checkbox" v-model="formData.collect.ys" value="collect_ys" />
					预示之谜
				</label>
				<label>
					<input type="checkbox" v-model="formData.collect.jj" value="collect_jj" />
					结晶之谜
				</label>
				<label>
					<input type="checkbox" v-model="formData.collect.ly" value="collect_ly" />
					烙印之谜
				</label>
				<label>
					<input type="checkbox" v-model="formData.collect.xs" value="collect_xs" />
					血税之谜
				</label>
			</div> -->
			<button type="submit">Submit</button>
		</form>
		<div v-if="responseMessage">
			{{ responseMessage }}
		</div>
		<div v-if="responseData">
			<h3>Response Data:</h3>
			<p>Name: {{ responseData.name }}</p>
			<p>Age: {{ responseData.age }}</p>
			<p>Collect: {{ responseData.collect }}</p>

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
			urgentMap: null
		};
	},
	mounted() {
		this.fetchUrgentMap();
	},
	methods: {
		async submitForm() {
			try {
				const response = await axios.post('http://localhost:8181/chuanrong/submit', this.formData);
				this.responseMessage = 'Form submitted successfully!';
				this.responseData = response.data; // 解析并绑定响应数据
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
		}
	}
};
</script>

<style scoped>
* {
	color: white;
}
</style>