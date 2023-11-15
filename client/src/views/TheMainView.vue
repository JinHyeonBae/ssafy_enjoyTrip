<script setup>
import Carousel from "@/components/mains/Carousel.vue";
import Contents from "@/components/mains/Contents.vue";
import Search from "@/components/mains/Search.vue";
import SidoList from "@/components/mains/SidoList.vue";
</script>

<template>
	<Carousel />
	<h2 class="fw-bold my-5 d-flex justify-content-center">컨텐츠</h2>
	<Contents />
	<h2 class="fw-bold my-5 d-flex justify-content-center">어디로 여행을 떠나시나요?</h2>
	<Search />
	<SidoList class="d-flex justify-content-center my-5" />
</template>

<style scoped></style>
