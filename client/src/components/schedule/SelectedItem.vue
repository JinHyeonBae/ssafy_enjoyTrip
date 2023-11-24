<script setup>
import Busan from "@/assets/img/main/Busan.jpg";
import { useAttrStore } from "@/stores/schedule";
import { ref } from "vue";

const { attraction } = defineProps({
  attraction: Object,
  lat: Number,
  lng: Number,
});
/*

  title: String,
  startDate : String,
  destDate : String,
  description: String, (overview)
  index: Number,
  lat : Number,
  lng : Number
*/

const emit = defineEmits(["removeItem"]);

const removeItem = (item) => {
  emit("removeItem", item.attraction);
};
</script>

<template>
  <a
    href="#"
    class="list-group-item d-flex flex-row list-group-item-action py-3 lh-sm mb-3"
  >
    <svg
      xmlns="http://www.w3.org/2000/svg"
      width="16"
      height="16"
      fill="currentColor"
      class="bi bi-geo-alt-fill"
      viewBox="0 0 16 16"
    >
      <path
        d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"
      />
    </svg>
    <div class="d-flex ps-2">
      <strong class="mb-1">{{ attraction.title }}</strong>

      <div v-if="!!startDate && !!destDate">
        <small class="text-body-secondary"
          >{{ attraction.startDate }} - {{ attraction.destDate }}</small
        >
      </div>
    </div>
    <img
      src="/src/assets/delete-icon.png"
      width="20"
      height="20"
      @click="removeItem(this)"
    />
  </a>
</template>

<style scoped>
.list-group-item {
  justify-content: space-evenly;
}
.description {
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
