<script setup>
import Carousel from "@/components/mains/Carousel.vue";
import Search from "@/components/mains/Search.vue";
import SidoList from "@/components/mains/SidoList.vue";
import Card from "@/components/mains/Card.vue";
import { ref, onMounted } from "vue";
import { listArticle, detailArticle, latestArticles } from "@/api/board";

const latestListArticle = ref([]);

const getArticleList = () => {
	// API 호출
	latestArticles(
		({ data }) => {
			latestListArticle.value = data;
		},
		(error) => {
			console.log(error);
		}
	);
};

onMounted(() => {
	getArticleList();
});
</script>

<template>
	<Carousel />
	<h2 class="fw-bold my-5 d-flex justify-content-center">최신글 보기</h2>
	<div class="row row-cols-auto mx-5d-flex justify-content-center">
		<div v-for="(latestArticle, index) in latestListArticle" :key="index">
			<Card class="mx-3 mb-3 col3" :latestArticle="latestArticle" />
		</div>
	</div>
	<h2 class="fw-bold my-5 d-flex justify-content-center">어디로 여행을 떠나시나요?</h2>
	<Search />
	<SidoList class="d-flex justify-content-center my-5" />
</template>

<style scoped></style>
