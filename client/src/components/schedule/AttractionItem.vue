<script setup>
import Busan from "@/assets/img/main/Busan.jpg";
import { useAttrStore } from "@/stores/schedule";

const { attraction, date, description, index } = defineProps({
  attraction: String,
  date: String,
  description: String,
  index: Number,
});

const store = useAttrStore();

const getAttractionInfo = () => {
  store.addToAttrList({
    attraction,
    date,
    description,
    index,
  });
};
</script>

<template>
  <a
    href="#"
    class="list-group-item d-flex flex-row list-group-item-action py-3 lh-sm mb-3"
    @click="getAttractionInfo"
  >
    <img class="rounded" style="width: 4.5rem; height: 100%" :src="Busan" />
    <div
      class="d-flex flex-column w-100 align-items-center justify-content-between ps-2"
    >
      <strong class="mb-1">{{ attraction }}</strong>
      <small class="text-body-secondary">{{ store.getStartDate() }} - {{ store.getDestDate() }}</small>
      <div class="description col-10 mb-1 small">
        {{ description }}
      </div>
    </div>
  </a>
</template>

<style scoped>
.description {
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
