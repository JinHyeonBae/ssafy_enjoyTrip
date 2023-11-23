<script setup>
import { onMounted, ref, watch, computed } from "vue";
import AttractionItem from "./AttractionItem.vue";
import { useAttrStore } from "@/stores/schedule";
import { storeToRefs } from "pinia";

const store = useAttrStore();
const { getAttrList } = storeToRefs(store);
//const store = ("attrStore");

const removeItem = (item) => {
  console.log("REMOVEUITEM : ");
  console.log(item);
  store.removeToAttrList(item);
}

// watch(
//   () => getAttrList,
//   (value) => {
//     console.log("ATTRACTION : ");
//     console.log(value);
//   }, 
//   {
//   immediate : true,
//   deep: true
// })

</script>

<template>
  <div class="selected-list">
    <div class="mt-2">
      <ul style="width: 20rem; flex-wrap: nowrap;">
        <h3>내가 선택한 여행지</h3>
        <div class="selectedAttraction" v-for="(attr, index) in getAttrList">
            <AttractionItem
              :title="attr.title"
              :startDate="attr.startDate"
              :destDate="attr.destDate"
              description=""
              :index="index"
              :enableSelected="false"
              @remove-item="removeItem"
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
