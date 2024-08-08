import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import JsppUi from './libs/jspp-ui'


createApp(App).use(router).use(JsppUi).mount('#app')
