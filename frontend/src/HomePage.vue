<template>
	<div id="app">
		<h1>川蓉联盟PRTS</h1>
		<div class="container">
			<carousel :autoplay="true" :duration="3000" :initialIndex="0" :hasDots="true" :hasDirector="true">
				<car-item v-for="(item, index) in carData" :key="index">
					<router-link :to="item.link">
						<img class="img" :src="getImageSrc(item.img_name)" />
					</router-link>
				</car-item>
			</carousel>
		</div>
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
</style>
