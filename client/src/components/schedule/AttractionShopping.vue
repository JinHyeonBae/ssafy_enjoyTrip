<script setup>
import { ref } from "vue";
import AttractionItem from "./AttractionItem.vue";
import { useAttrStore } from "@/stores/schedule";

const store = useAttrStore();
const attrList = ref([]);
const date = ref("");

attrList.value = store.getDataAll;
</script>

<template>
  <div class="selected-list">
    <div class="mt-2">
      <ul style="width: 20rem; flex-wrap: nowrap">
        <h3>내가 선택한 여행지</h3>
        <div class="selectedAttraction" v-for="(attr, index) in attrList">
          <AttractionItem
            :attraction="attr.attraction"
            :date="date"
            description=""
            :index="index"
          />
        </div>
      </ul>
    </div>
  </div>
</template>

<style scoped>
.selected-list {
  height: 100vh;
  overflow-y: scroll;
}
</style>
