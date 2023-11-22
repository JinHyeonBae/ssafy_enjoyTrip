<script setup>
import SidoCard from "./SidoCard.vue";
import Modal from "./Modal.vue";
import { useSidoStore } from "@/stores/sido";
import { storeToRefs } from "pinia";

const sidoStore = useSidoStore();
const { sidoImages } = storeToRefs(sidoStore);
</script>

<template>
	<div class="row row-cols-auto mx-5">
		<div v-for="(sidoImage, index) in sidoImages" :key="index">
			<SidoCard
				class="col"
				data-bs-toggle="modal"
				:data-bs-target="`#${sidoImage.name}`"
				:sidoImage="sidoImage"
			/>
			<Modal :modalId="sidoImage.name" :sidoImage="sidoImage" :sidoCode="sidoImage.code"/>
		</div>
	</div>
</template>

<style scoped></style>
