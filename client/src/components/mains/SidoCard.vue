<script setup>
import home_1 from "@/assets/img/main/Busan.jpg";
defineProps({ sidoImage: Object });
</script>

<template>
	<div class="card border-0">
		<img :src="sidoImage.image" style="width: 18rem; height: 10rem" class="rounded-3" alt="..." />
		<div class="card-body">
			<h5 class="card-title" style="text-align: center">{{ sidoImage.name }}</h5>
		</div>
	</div>
</template>

<style scoped></style>
