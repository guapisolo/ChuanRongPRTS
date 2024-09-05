<template>
	<label>
		<input type="radio" :checked="checked" :value="value" @change="updateChecked" />
		{{ label }}{{ description }} ({{ score }})
		<br>
	</label>
</template>

<script>
export default {
	name: 'RadioWithLabel',
	props: {
		label: {
			type: String,
			required: true
		},
		description: {
			type: String,
			required: true
		},
		score: {
			type: Number,
			required: true
		},
		value: {
			type: String,
			required: true
		},
		checked: {
			type: Boolean,
			default: false
		},
		methods: {
			updateChecked(event) {
				if (event.target.checked) {
					this.$emit('update:checked', this.value);
				}
			}
		}
	}
};
</script>

<style scoped>
/* 添加任何必要的样式 */
</style>