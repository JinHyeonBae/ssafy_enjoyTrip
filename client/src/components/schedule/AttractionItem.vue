<script setup>
import Busan from "@/assets/img/main/Busan.jpg";
import { useAttrStore } from "@/stores/schedule";
import { onMounted, ref } from "vue";
import ScheduleModal from "./ScheduleModal.vue";

const { index, attraction } = defineProps({
  index: Number,
  attraction: Object,
});

/*
  title: String,
  description: String,
  index: Number,
  lat : Number,
  lng : Number,
*/

let title = ref("");
let description = ref("");

const emit = defineEmits(["addItem"]);

const addAttractionInfo = (item) => {
  console.log("ADD ITEM : ");
  console.log(item);
  emit("addItem", item.attraction);
};


</script>

<template>
  <ScheduleModal :id="`scheduleModal_${index}`" :title="attraction.title" :description="attraction.overview" />
  <div
    href="#"
    class="list-group-item d-flex flex-row list-group-item-action py-3 lh-sm mb-3"
  >
    <img class="rounded" style="width: 4.5rem; height: 100%" :src="Busan" />
    <div
      class="d-flex flex-column w-100 align-items-center justify-content-between ps-2"
      data-bs-toggle="modal"
      :data-bs-target="`#scheduleModal_${index}`"
    >
      <strong class="mb-1">{{ attraction.title }}</strong>
      <div class="description col-10 mb-1 small">
        {{ attraction.overview }}
      </div>
    </div>
    <div @click="addAttractionInfo(this)">
      <img src="/src/assets/add.png" width="20" height="20" />
    </div>
  </div>
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
