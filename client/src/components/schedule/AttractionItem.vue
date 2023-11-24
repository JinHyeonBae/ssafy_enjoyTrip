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
  <ScheduleModal
    :id="`scheduleModal_${index}`"
    :title="attraction.title"
    :description="attraction.overview"
  />
  <div
    href="#"
    class="list-group-item d-flex flex-row list-group-item-action py-3 lh-sm mb-3"
  >
    <svg
      xmlns="http://www.w3.org/2000/svg"
      width="32"
      height="32"
      fill="currentColor"
      class="bi bi-geo-alt-fill"
      viewBox="0 0 16 16"
    >
      <path
        d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"
      />
    </svg>
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
