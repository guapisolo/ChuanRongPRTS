<template>
    <div class="carousel">
        <div class="inner">
            <slot></slot>
        </div>
    </div>
</template>

<script>
/* eslint-disable */

import { reactive, toRefs,onMounted,onBeforeUnmount,getCurrentInstance } from 'vue';

export default {
    name: 'Carousel',
    props: {
        autoplay: {
            type: Boolean,
            default: false
        },
        duration: {
            type: Number,
            default: 3000
        },
        initialIndex: {
            type: Number,
            default: 0
        },
        hasDots: {
            type: Boolean,
            default: false
        },
        hasDirector: {
            type: Boolean,
            default: false
        }
    },
    setup(props) {
        const instance = getCurrentInstance();

        const state = reactive({
            currentIndex: props.initialIndex,
            itemLen: 0
        });

        let t = null;

        const autoPlay = () => {
            if(props.autoplay) {
                t = setInterval(() => {
                    console.log('1');
                    setIndex('next');
                }, props.duration);
            }
        };

        const setIndex = (dir) => {
            switch(dir) {
                case 'prev':
                    state.currentIndex = (state.currentIndex - 1 + state.itemLen) % state.itemLen;
                    break;
                case 'next':
                    state.currentIndex = (state.currentIndex + 1) % state.itemLen;
                    break;
                default:
                    break;
            }
        };

        onMounted(() => {
            state.itemLen =instance.slots.default()[0].children.length;
            autoPlay();
        });

        onBeforeUnmount(() => {
            clearInterval(t);
            t = null;
        });

        return {
            ...toRefs(state)
        }
    },
}
</script>

<style lang="scss" scoped>
.carousel {
    width: 100%;
    height: 100%;

    display: flex;
    justify-content: center; /* 水平居中 */
    align-items: center; /* 垂直居中 */
    .inner {
        position: relative;
        width: 1200px;
        height: 800px;
    }
}
</style>
