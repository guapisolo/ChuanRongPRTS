import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/HomePage.vue';
import yonghengbeiCalculator from '@/pages/backup/yonghengbei/App.vue';
import shudaoxingCalculator from '@/pages/backup/shudaoxing/App.vue';
import NotFound from '@/pages/NotFound.vue';

const routes = [
	{
		path: '/',
		name: 'Home',
		component: HomePage
	},
	{
		path: '/yonghengbei/calculator',
		name: 'yonghengbei_calculator',
		component: yonghengbeiCalculator
	},
	{
		path: '/shudaoxing/calculator',
		name: 'shudaoxing_calculator',
		component: shudaoxingCalculator
	},
	{
		path: '/:catchAll(.*)',
		name: 'NotFound',
		component: NotFound // 重定向到 404 页面
	}
];

const router = createRouter({
	history: createWebHistory(process.env.BASE_URL),
	routes
});

export default router;