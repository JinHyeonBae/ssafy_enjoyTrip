<script setup>
import { onMounted, ref, watch, computed } from "vue";
import SelectedItem from "./SelectedItem.vue";
import { useAttrStore } from "@/stores/schedule";
import { storeToRefs } from "pinia";

const store = useAttrStore();
const { getAttrList } = storeToRefs(store);
//const store = ("attrStore");

const removeItem = (item) => {
  store.removeToAttrList(item);
}

</script>

<template>
  <div class="selected-list">
    <div class="mt-2">
      <ul style="width: 20rem; flex-wrap: nowrap;">
        <h3>내가 선택한 여행지</h3>
        <div class="selectedAttraction" v-for="attraction in getAttrList">
            <SelectedItem
              :attraction="attraction"
              @remove-item="removeItem"
            ></SelectedItem>
            <!---<SelectedItem
              :title="attr.title"
              :startDate="attr.startDate"
              :destDate="attr.destDate"
              description=""
              :index="attr.contentId"
              @remove-item="removeItem"
            /> --->
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
