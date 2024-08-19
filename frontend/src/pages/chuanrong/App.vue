<template>
	<div>
		<form @submit.prevent="submitForm">
			<!-- 表单字段 -->
			<div>
				<label>
					<input type="radio" v-model="formData.name" value="urgent_dqyp" />
					大棋一盘(30)
				</label>
				<label>
					<input type="radio" v-model="formData.name" value="urgent_dqyp2" />
					大棋一盘无盾(50)
				</label>
				<label>
					<input type="radio" v-model="formData.name" value="urgent_xmzb" />
					血脉之辩(0)
				</label>
				<label>
					<input type="radio" v-model="formData.name" value="urgent_ztbr" />
					遮天蔽日(0)
				</label>
				<label>
					<input type="radio" v-model="formData.name" value="urgent_lzdqc" />
					劳作的清晨(0)
				</label>
			</div>
			<div>
				<label>
					<input type="radio" v-model="formData.age" value="age_null" />
					无年代
				</label>
				<label>
					<input type="radio" v-model="formData.age" value="age_tz" />
					天灾年代
				</label>
				<label>
					<input type="radio" v-model="formData.age" value="age_jr" />
					金融年代
				</label>
				<label>
					<input type="radio" v-model="formData.age" value="age_yj" />
					拥挤年代
				</label>
				<label>
					<input type="radio" v-model="formData.age" value="age_qg" />
					奇观年代
				</label>
				<label>
					<input type="radio" v-model="formData.age" value="age_kn" />
					苦难年代
				</label>
			</div>
			<div>
				<label>
					<input type="radio" v-model="formData.age_value" value="0" />
					0
				</label>
				<label>
					<input type="radio" v-model="formData.age_value" value="1" />
					1
				</label>
				<label>
					<input type="radio" v-model="formData.age_value" value="2" />
					2
				</label>
				<label>
					<input type="radio" v-model="formData.age_value" value="3" />
					3
				</label>
			</div>
			<button type="submit">Submit</button>
		</form>
		<div v-if="responseMessage">
			{{ responseMessage }}
		</div>
		<div v-if="responseData">
			<h3>Response Data:</h3>
			<p>Name: {{ responseData.name }}</p>
			<p>Age: {{ responseData.age }}</p>
			<p>Age_value: {{ responseData.age_value }}</p>
		</div>
	</div>
</template>

<script>
import axios from 'axios';

export default {
	data() {
		return {
			formData: {
				name: '',
				age: '',
				age_value: '',
				tree_hole: ''
			},
			responseMessage: '',
			responseData: null
		};
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
		}
	}
};
</script>

<style scoped>
* {
  color: white;
}
</style>