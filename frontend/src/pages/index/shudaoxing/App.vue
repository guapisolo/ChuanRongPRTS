<template>
    <div class="app-container">
        <h1>蜀道行——队伍介绍</h1>
		<hr class="gradient-hr">
        <div class="container">
			<carousel :autoplay="true" :duration="30000" :initialIndex="0" :hasDots="true" :hasDirector="true">
				<car-item v-for="(item, index) in carTeam" :key="index">
					<router-link :to="item.link">
						<img class="img" :src="getImageSrc(item.img_name)" />
					</router-link>
				</car-item>
			</carousel>
		</div>
    </div>
</template>


<script>
import carTeam from '@/data/carouselteam'

export default {
    name: 'ShudaoxingIndex',
    setup() {
		const getImageSrc = (imgName) => {
			return require(`@/assets/teams/${imgName}`);
		};
		return {
			carTeam,
			getImageSrc
		}
	},
    
    mounted() {
    document.title = '蜀道行队伍'; // 动态设置页面标题
  }
};

</script>


<style scoped>
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
.container {
    width: 100%;
    height: 4300px;
    display: flex;
    justify-content: center; /* 水平居中 */
}
.img {
    width: 100%;
    height: 100%;
    display: block;
}
</style>