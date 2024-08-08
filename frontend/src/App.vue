<template>
	<div id="app">
		<router-view></router-view>
	</div>
</template>

<script>
import carData from './data/carousel'

export default {
	name: 'App',
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

<style>
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
