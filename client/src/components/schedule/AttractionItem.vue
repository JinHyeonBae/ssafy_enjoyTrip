<script setup>
import Busan from "@/assets/img/main/Busan.jpg";
import { useAttrStore } from "@/stores/schedule";
import {ref} from "vue";

const { title, startDate, destDate, description, index, lat, lng, enableSelected } = defineProps({
  title: String,
  startDate : String,
  destDate : String,
  description: String,
  index: Number,
  lat : Number,
  lng : Number,
  enableSelected : Boolean
});

const emit = defineEmits(['addItem','removeItem']);

const addAttractionInfo = () => {
  emit("addItem", {
      title,
      startDate,
      destDate,
      description,
      index,
      lat,
      lng,
      show : true,
    })
};

const removeItem = (item)=>{
  emit("removeItem", item)
}

</script>

<template>
  <a
    href="#"
    class="list-group-item d-flex flex-row list-group-item-action py-3 lh-sm mb-3"
    @click="addAttractionInfo"
  >
    <img class="rounded" style="width: 4.5rem; height: 100%" :src="Busan" />
    <div
      class="d-flex flex-column w-100 align-items-center justify-content-between ps-2"
    >
      <strong class="mb-1">{{ title }}</strong>
      
      <div v-if="!!startDate && !!endDate">
        <small class="text-body-secondary">{{ startDate }} - {{ endDate }}</small>
      </div>
      <div class="description col-10 mb-1 small">
        {{ description }}
      </div>
    </div>
    <div v-if="!enableSelected">
      <img src="/src/assets/delete-icon.png" 
      width=20 height=20 @click="removeItem(this)"/>
    </div>
  </a>
</template>

<style scoped>

.list-group-item{
  overflow-y: scroll;
}

.description {
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
