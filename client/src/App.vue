<script setup>
import { RouterView } from "vue-router";
import TheHeadingNavbar from "@/components/layout/TheHeadingNavbar.vue";
import TheFooter from "./components/layout/TheFooter.vue";
</script>

<template>
	<div class="mb-5">
		<TheHeadingNavbar></TheHeadingNavbar>
		<router-view></router-view>
		<TheFooter />
	</div>
</template>

<style scoped></style>
