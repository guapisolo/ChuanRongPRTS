<template>
	<div class="app-container">
		<div id="app">
			<!-- <div>
				<h1 style="text-align: center;">川蓉杯计算器</h1>
			</div> -->
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
			<component is="bigsubtitle" :text="'个人得分'"></component>
			<div class="personal-column-container">

				<div class="personal-column-1">
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
				<div class="personal-column-2">
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
						<component is="input-text" ref="special5" :label="'击杀鸭狗熊鼠'" :multiplier="10"
							@text-input-changed="recalTotal">
						</component>
						<component is="input-text" ref="special6" :label="'击杀门'" :multiplier="5"
							@text-input-changed="recalTotal">
						</component>
					</table>
					<div class="summary">总分：{{ total_special }} </div>

					<component is="subtitle" :text="'结算分'"></component>
					<table class="table">
						<component is="naive-input-text" ref="settlement_" :label="''" @text-input-changed="recalTotal">
						</component>
					</table>
				</div>
			</div>"
			<form @submit.prevent="submitForm">
				<!-- 表单字段 -->
				<div class="form-sub-container-1">
					<div class="form-column-1">
						<component is="subtitle" :text="'关卡'"></component>
						<div v-if="stageMap">
							<label v-for="(info, key) in stageMap" :key="key">
								<span v-if="key.startsWith('urgent_info')">
									{{ info.label }}
								</span>
								<span v-else>
									<input type="radio" class="image-radio" v-model="formData.name" :value="key" />
									{{ info.label }} ({{ info.score }})
								</span>
								<br>
							</label>
						</div>
					</div>
					<div class="form-column-2">
						<component is="subtitle" :text="'年代'"></component>
						<div v-if="ageMap">
							<label v-for="(info, key) in ageMap" :key="key">
								<span v-if="key.startsWith('age_info')">
									{{ info.label }}
								</span>
								<span v-else>
									<input type="radio" class="image-radio" v-model="formData.age" :value="key" />
									{{ info.label }}{{ info.description }} ({{ info.score }})
								</span>
								<!-- <input type="radio" class="image-radio" v-model="formData.age" :value="key" />
								{{ info.label }}{{ info.description }} ({{ info.score }}) -->
								<br>
							</label>
						</div>
					</div>
				</div>
				<div class="form-sub-container-2">
					<div class="form-column-3">
						<component is="subtitle" :text="'树洞藏品'"></component>
						<div v-if="collectMap">
							<label v-for="(info, key) in collectMap" :key="key">
								<input type="checkbox" class="image-checkbox" v-model="formData.collect[key]"
									:value="key" />
								{{ info.label }} ({{ info.score }})
								<br>
							</label>
						</div>
						<button class="submit-button" type="submit"></button>
					</div>
					<div class="form-column-4">
						<div v-if="responseHistory.length >= 0">
							<h3>关卡总分: {{ totalScore() }}</h3>
							<h3>关卡记录:</h3>
							<ul>
								<li v-for="(response, index) in responseHistory" :key="index">
									{{ response.info }}:
									Score: {{ response.score }}
									<button class="delete-button" @click="removeResponse(index)" type="button"></button>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</form>
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

export default {
	components: {
		InputText,
		SingleTick,
		Subtitle,
		NaiveInputText,
		Bigsubtitle
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
@import './assets/App.css';
</style>