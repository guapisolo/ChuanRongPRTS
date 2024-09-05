<template>
	<div class="app-container">
		<div id="app">
			<div>
				<h1 style="text-align: center;">川蓉杯计算器</h1>
			</div>
			<component is="bigsubtitle" :text="'团队得分'"></component>
			<div class="centered-select">
				<select v-model="selectedOption" class="custom-select">
					<option value="" selected disabled>队伍名称</option>
					<option value="花嫁大爹伴郎团">花嫁大爹伴郎团</option>
					<option value="一起拉屎">一起拉屎</option>
					<option value="脑子要爆炸了">脑子要爆炸了</option>
					<option value="啊不对不队">啊不对不队</option>
					<option value="澄闪天下第一">澄闪天下第一</option>
				</select>
			</div>
			<div class="team-column-container">
				<div class="team-column-1">
					<div>
						<component is="subtitle" :text="'干员次数'"></component>
						<div style="text-align: center;">扣分制！！！</div>
						<table class="double_column_table">
							<div class="column">
								<component is="input-text" ref="ban_wsdr" :label="'维什戴尔'" :multiplier="500"
									@text-input-changed="recalTotal">
								</component>
								<component is="input-text" ref="ban_lgs" :label="'逻各斯'" :multiplier="250"
									@text-input-changed="recalTotal">
								</component>
								<component is="input-text" ref="ban_nf" :label="'妮芙'" :multiplier="150"
									@text-input-changed="recalTotal">
								</component>
								<component is="input-text" ref="ban_askl" :label="'阿斯卡纶'" :multiplier="150"
									@text-input-changed="recalTotal">
								</component>
								<component is="input-text" ref="ban_cjayfl" :label="'纯烬艾雅法拉'" :multiplier="100"
									@text-input-changed="recalTotal">
								</component>
								<component is="input-text" ref="ban_al" :label="'艾拉'" :multiplier="100"
									@text-input-changed="recalTotal">
								</component>
								<component is="input-text" ref="ban_s" :label="'黍'" :multiplier="100"
									@text-input-changed="recalTotal">
								</component>
								<component is="input-text" ref="ban_kex" :label="'凯尔希'" :multiplier="100"
									@text-input-changed="recalTotal">
								</component>
								<component is="input-text" ref="ban_weba" :label="'乌尔比安'" :multiplier="75"
									@text-input-changed="recalTotal">
								</component>
								<component is="input-text" ref="ban_ly" :label="'莱伊'" :multiplier="75"
									@text-input-changed="recalTotal">
								</component>
								<component is="input-text" ref="ban_qlryd" :label="'麒麟R夜刀'" :multiplier="75"
									@text-input-changed="recalTotal">
								</component>
								<component is="input-text" ref="ban_yns" :label="'伊内丝'" :multiplier="75"
									@text-input-changed="recalTotal">
								</component>
								<component is="input-text" ref="extrasix" :label="'额外六星'" :multiplier="300"
									@text-input-changed="recalTotal">
								</component>
							</div>
						</table>
						<div class="summary">总分：{{ total_ban }} </div>
					</div>
				</div>
				<div class="team-column-2">
					<div>
						<component is="subtitle" :text="'取源石锭'"></component>
						<table class="table">
							<component is="input-text" ref="coins1" :label="'选手1'" :multiplier="1"
								@text-input-changed="recalTotal">
							</component>
							<component is="input-text" ref="coins2" :label="'选手2'" :multiplier="1"
								@text-input-changed="recalTotal">
							</component>
							<component is="input-text" ref="coins3" :label="'选手3'" :multiplier="1"
								@text-input-changed="recalTotal">
							</component>
						</table>
						<div class="summary">总分：{{ total_coins }}</div>
					</div>
					<div>
						<component is="subtitle" :text="'选手得分'"></component>
						<table class="table">
							<component is="naive-input-text" ref="player1" :label="'选手1'"
								@text-input-changed="recalTotal">
							</component>
							<component is="naive-input-text" ref="player2" :label="'选手2'"
								@text-input-changed="recalTotal">
							</component>
							<component is="naive-input-text" ref="player3" :label="'选手3'"
								@text-input-changed="recalTotal">
							</component>
						</table>
						<div class="summary">总分：{{ total_player }}</div>
					</div>
				</div>
			</div>
			<h1 style="text-align: center;">{{ selectedOption }}团队总分：{{ team_total }} </h1>
			<div>
				<component is="subtitle" :text="'结局情况'"></component>
				<table class="table">
					<tr>
						<td>
							<component is="single-tick" ref="end1" :label="'或然面纱'" :multiplier="40"
								@tick-changed="recalTotal"></component>
						</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>
							<component is="single-tick" ref="end2" :label="'离歌的庭院'" :multiplier="50"
								@tick-changed="recalTotal"></component>
						</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>
							<component is="single-tick" ref="end3" :label="'紧急授课'" :multiplier="100"
								@tick-changed="recalTotal"></component>
						</td>
						<td>
							<component is="single-tick" ref="end_chaos3" :label="'混乱状态'" :multiplier="20"
								@tick-changed="recalTotal"></component>
						</td>
						<td>
							<component is="single-tick" ref="end_special3" :label="'奇观年代'" :multiplier="50"
								@tick-changed="recalTotal"></component>
						</td>
						<td>
							<component is="single-tick" ref="end_mowang3" :label="'魔王年代'" :multiplier="20"
								@tick-changed="recalTotal"></component>
						</td>
					</tr>
					<tr>
						<td>
							<component is="single-tick" ref="end4" :label="'朝谒'" :multiplier="250"
								@tick-changed="recalTotal"></component>
						</td>
						<td>
							<component is="single-tick" ref="end_chaos4" :label="'混乱状态'" :multiplier="50"
								@tick-changed="recalTotal"></component>
						</td>
						<td>
							<component is="single-tick" ref="end_special4" :label="'奇观年代'" :multiplier="50"
								@tick-changed="recalTotal"></component>
						</td>
						<td>
							<component is="single-tick" ref="end_mowang4" :label="'魔王年代'" :multiplier="50"
								@tick-changed="recalTotal"></component>
						</td>
					</tr>
					<tr>
						<td>
							<component is="single-tick" ref="end5" :label="'圣城'" :multiplier="300"
								@tick-changed="recalTotal"></component>
						</td>
						<td>
							<component is="single-tick" ref="end_chaos5" :label="'混乱状态'" :multiplier="50"
								@tick-changed="recalTotal"></component>
						</td>
						<td>
							<component is="single-tick" ref="end_special5" :label="'奇观年代'" :multiplier="50"
								@tick-changed="recalTotal"></component>
						</td>
						<td>
							<component is="single-tick" ref="end_mowang5" :label="'魔王年代'" :multiplier="50"
								@tick-changed="recalTotal"></component>
						</td>
					</tr>
				</table>
				<div class="summary">总分：{{ total_end }} </div>
			</div>
			<div>
				<component is="subtitle" :text="'特殊关卡'"></component>
				<table>
					<component is="input-text" ref="special1" :label="'(紧急)信号灯'" :multiplier="30"
						@text-input-changed="recalTotal">
					</component>
					<component is="input-text" ref="special2" :label="'(紧急)劫虚济实'" :multiplier="30"
						@text-input-changed="recalTotal">
					</component>
					<component is="input-text" ref="special3" :label="'(紧急)战场侧面'" :multiplier="30"
						@text-input-changed="recalTotal">
					</component>
					<component is="input-text" ref="special4" :label="'(紧急)鸭速公路'" :multiplier="50"
						@text-input-changed="recalTotal">
					</component>
					<component is="input-text" ref="special5" :label="'击杀鸭狗熊鼠门'" :multiplier="5"
						@text-input-changed="recalTotal">
					</component>
				</table>
				<div class="summary">总分：{{ total_special }} </div>
			</div>
			<div>
				<component is="subtitle" :text="'结算分'"></component>
				<table class="table">
					<component is="naive-input-text" ref="settlement_" :label="''" @text-input-changed="recalTotal">
					</component>
				</table>
			</div>
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
							<!-- <label v-for="(info, key) in collectMap" :key="key">
								<input type="checkbox" v-model="formData.collect[key]" :value="key" />
								{{ info.label }} ({{ info.score }})
								<br>
							</label> -->
							<TobackSingleTick v-for="(info, key) in collectMap" :key="key" :label="info.label"
								:score="info.score" :value="key" :checked="formData.collect[key]"
								@update:checked="formData.collect[key] = $event" />
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
				<h3>Total Score: {{ totalScore() }}</h3>
				<h3>Response History:</h3>
				<ul>
					<li v-for="(response, index) in responseHistory" :key="index">
						{{ response.info }}:
						Score: {{ response.score }}
						<button class="red-button" @click="removeResponse(index)">Delete</button>
					</li>
				</ul>
			</div>
			<h1 style="text-align: center;">选手总分：{{ personal_total }} </h1>
		</div>
	</div>
</template>

<script>
import axios from 'axios';
import InputText from './components/input-text.vue';
import SingleTick from './components/single-tick.vue';
import Subtitle from './components/subtitle.vue';
import NaiveInputText from './components/naive-input-text.vue';
import Bigsubtitle from './components/bigsubtitle.vue';
// import TobackRadio from './components/toback-radio.vue';
import TobackSingleTick from './components/toback-single-tick.vue';

export default {
	components: {
		InputText,
		SingleTick,
		Subtitle,
		NaiveInputText,
		Bigsubtitle,
		// TobackRadio,
		TobackSingleTick
	},
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
			collectMap: null,
			selectedOption: '',
			total_ban: 3650,
			total_coins: 0,
			total_player: 0,
			team_total: 0,
			initial_value: 0,
			total_special: 0,
			total_settlement: 0,
			personal_total: 0
		};
	},
	computed: {

	},
	mounted() {
		this.fetchStageMap();
		this.fetchAgeMap();
		this.fetchCollectMap();
		document.title = '川蓉杯计算器'; // 动态设置页面标题
	},
	methods: {
		totalScore() {
			if (this.responseHistory.length === 0) {
				return 0;
			} else {
				return this.responseHistory.reduce((sum, response) => sum + response.score, 0);
			}
		},
		async submitForm() {
			try {
				// const response = await axios.post('http://localhost:8181/chuanrong/submit', this.formData);
				const response = await axios.post('http://121.40.66.236:8181/chuanrong/submit', this.formData);
				this.responseMessage = 'Form submitted successfully!';
				this.responseData = response.data; // 解析并绑定响应数据
				this.responseHistory.push({ ...this.responseData }); // 保存 responseData 的副本
				this.recalTotal();
			} catch (error) {
				this.responseMessage = 'Error: ' + error.message;
				this.responseData = null;
			}
		},
		removeResponse(index) {
			this.responseHistory.splice(index, 1);
			this.recalTotal();
		},
		async fetchStageMap() {
			try {
				// const response = await axios.get('http://localhost:8181/chuanrong/stageMap');
				const response = await axios.get('http://121.40.66.236:8181/chuanrong/stageMap');
				this.stageMap = response.data;
			} catch (error) {
				console.error('Error fetching stageMap:', error);
			}
		},
		async fetchAgeMap() {
			try {
				// const response = await axios.get('http://localhost:8181/chuanrong/ageMap');
				const response = await axios.get('http://121.40.66.236:8181/chuanrong/ageMap');
				this.ageMap = response.data;
			} catch (error) {
				console.error('Error fetching ageMap:', error);
			}
		},
		async fetchCollectMap() {
			try {
				// const response = await axios.get('http://localhost:8181/chuanrong/collectMap');
				const response = await axios.get('http://121.40.66.236:8181/chuanrong/collectMap');
				this.collectMap = response.data;
			} catch (error) {
				console.error('Error fetching collectMap:', error);
			}
		},
		roundToThreeDecimals(value) {
			return parseFloat(value).toFixed(3);
		},
		recalTotal() {
			console.log('recalTotal method called'); // 日志输出
			// 更新 result 的值
			let ban_sum = Object.keys(this.$refs)
				.filter(ref => ref.startsWith('ban'))
				.reduce((total, ref) => total + this.$refs[ref].multiplier, 0);
			let ban_sub = Object.keys(this.$refs)
				.filter(ref => ref.startsWith('ban'))
				.reduce((total, ref) => total + this.$refs[ref].result, 0);
			let extra = Object.keys(this.$refs)
				.filter(ref => ref.startsWith('extrasix'))
				.reduce((total, ref) => total + this.$refs[ref].result, 0);
			this.total_ban = ban_sum * 2 - ban_sub + 500 - extra;

			let coins_sum = Object.keys(this.$refs)
				.filter(ref => ref.startsWith('coins'))
				.reduce((total, ref) => total + this.$refs[ref].result, 0);

			if (coins_sum > 150) {
				this.total_coins = (coins_sum - 150) * (-40);
			} else {
				this.total_coins = 0;
			}

			this.total_player = Object.keys(this.$refs)
				.filter(ref => ref.startsWith('player'))
				.reduce((total, ref) => total + this.$refs[ref].result, 0);

			this.total_end = Object.keys(this.$refs)
				.filter(ref => ref.startsWith('end'))
				.reduce((total, ref) => total + this.$refs[ref].result, 0);

			this.total_special = Object.keys(this.$refs)
				.filter(ref => ref.startsWith('special'))
				.reduce((total, ref) => total + this.$refs[ref].result, 0);

			this.total_settlement = Object.keys(this.$refs)
				.filter(ref => ref.startsWith('settlement'))
				.reduce((total, ref) => total + this.$refs[ref].result, 0);


			this.personal_total = this.total_end + this.total_special
				+ this.total_settlement + this.totalScore();

			this.team_total = this.total_ban + this.total_coins + this.total_player;
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

.centered-select {
	display: flex;
	justify-content: center;
	margin-top: 20px;
}

.custom-select {
	padding: 10px;
	font-size: 16px;
	background: url('assets/input.png') no-repeat right center;
	background-size: 20px auto;
	/* 调整背景图片的大小 */
	-webkit-appearance: none;
	/* 隐藏默认的下拉箭头 */
	-moz-appearance: none;
	/* 隐藏默认的下拉箭头 */
	appearance: none;
	/* 隐藏默认的下拉箭头 */
	color: #d7aebe;
	/* 修改字体颜色 */
	border: none;
	/* 去掉白色边框 */
	font-size: 24px;
	text-align: center;
	/* 使选项文字居中 */
	text-align-last: center;
	/* 使选中的选项文字居中 */
}

.select {
	padding: 10px;
	font-size: 16px;
}

.app-container {
	padding-top: 1100px;
	/* background-color: #000; */
	background-image: url('assets/background.jpg');
	background-size: cover;
}

.team-column-container {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.team-column-1 {
	flex: 20;
	align-self: flex-start;
	margin-left: 100px;
	/* 调整边距 */
}

.team-column-2 {
	flex: 20;
	align-self: flex-start;
	margin-right: 100px;
	/* 调整边距 */
}

.app-column-container {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

@media (min-width: 1200px) {

	/* 当屏幕宽度大于或等于 1200px 时 */
	.team-column-container {
		flex-direction: row;
		/* 变为两列 */
	}
}

@media (min-width: 1200px) {

	/* 当屏幕宽度大于或等于 1200px 时 */
	.app-column-container {
		flex-direction: row;
		/* 变为三列 */
	}
}

.app-column-1 {
	flex: 18;
	align-self: flex-start;
}

.app-column-2 {
	flex: 30;
	align-self: flex-start;
}

.info-column-container {
	display: flex;
	justify-content: space-between;
}

.info-column {
	flex: 1;
	margin: 0 10px;
}

.double_column_table {
	margin: auto;
	justify-content: center;
	display: flex;
}

table {
	margin: auto;
}

.app {
	width: 100%;
	max-width: 1200px;
	margin: 0 auto;
	padding: 20px;
	box-sizing: border-box;
	font-family: Arial, sans-serif;
	/* background-color: #000; */
	/* 如果需要，可以添加这一行来使背景图片覆盖整个元素 */
	color: #d7aebe;
}

@media (max-width: 1200px) {

	/* 当屏幕宽度大于或等于 1200px 时 */
	.app {
		max-width: 400px;
	}
}

.summary {
	margin-top: 18px;
	font-size: 18px;
	font-weight: bold;
	text-align: center;
}
</style>