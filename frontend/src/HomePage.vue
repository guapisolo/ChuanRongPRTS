<template>
	<div id="app">
		<h1>川蓉联盟PRTS</h1>
		<hr class="gradient-hr">
		<h2>进行中的比赛</h2>
		<div class="shudaoxingimg">
			<router-link to="/shudaoxing/index">
				<img class="img" src="@/assets/img/shudaoxing.png" alt="蜀道行"/>
			</router-link>
		</div>
		<hr class="gradient-hr">
		<h2>比赛计算器模板</h2>
		<p>（点击跳转）</p>
		<div class="container">
			<carousel :autoplay="true" :duration="3000" :initialIndex="0" :hasDots="true" :hasDirector="true">
				<car-item v-for="(item, index) in carData" :key="index">
					<router-link :to="item.link">
						<img class="img" :src="getImageSrc(item.img_name)" />
					</router-link>
				</car-item>
			</carousel>
		</div>
		<hr class="gradient-hr">
		<p>(本页面由川蓉联盟技术组开发)</p>
	</div>
</template>

<script>
import carData from './data/carousel'

export default {
	name: 'HomePage',
	setup() {
		const getImageSrc = (imgName) => {
			return require(`./assets/img/${imgName}`);
		};
		return {
			carData,
			getImageSrc
		}
	},
	mounted() {
		document.title = '川蓉联盟PRTS'; // 动态设置页面标题
	}
}
</script>

<style scoped>
body {
	background-color: rgb(18, 16, 16);
	/* 设置页面背景颜色为黑色 */
}

h1 {
	text-align: center;
	/* 确保文本在 h1 内部居中 */
	color: rgba(255, 255, 255, 0.854);
	/* 设置文本颜色为白色 */
	font-size: 40px;
}

.gradient-hr {
	border: none;
	/* 移除默认边框 */
	height: 2px;
	/* 设置高度 */
	width: 100%;
	/* 设置宽度 */
	margin: 20px auto;
	/* 设置上下左右的边距 */
	background: linear-gradient(to right, rgb(18, 16, 16), rgba(255, 255, 255, 0.854), rgb(18, 16, 16));
	/* 设置渐变背景 */
}

h2 {
	text-align: center;
	color: rgba(255, 255, 255, 0.854);
	font-size: 30px;
}

p {
	text-align: center;
	color: rgba(255, 255, 255, 0.854);
	font-size: 20px;
}

.contanier {
	width: 100%;
	max-width: 1200px;
	margin: 0 auto;
	display: flex;
	justify-content: center;
	align-items: center;
}

.img {
	width: 1200px;
	height: 600px;
	display: block;
	margin: 0 auto;
}

.shudaoxingimg {
	width: 100%;
	max-width: 1200px;
	margin: 0 auto;
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
