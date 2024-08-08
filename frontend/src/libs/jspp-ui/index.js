import Carousel from './Carousel';
import CarItem from './Carousel/item.vue';

let JsppUi = {};

JsppUi.install = function (Vue) {
    Vue.component(Carousel.name, Carousel);
    Vue.component(CarItem.name, CarItem);
}

export default JsppUi;