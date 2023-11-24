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
    <img class="rounded" style="width: 4.5rem; height: 100%" :src="Busan" />
    <div
      class="d-flex ps-2"
    >
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

.list-group-item{
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
