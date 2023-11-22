<script setup>
import { onMounted, ref, watch } from "vue";
import AttractionItem from "./AttractionItem.vue";
import { useAttrStore } from "@/stores/schedule";

const store = useAttrStore();
const attrList = ref([]);
const list = store.getAttrList;
console.log("LIST : ")
console.log(list.value);
// watch(
//   ()=>store.getAttrList,
//   () => {
//       const list = store.getAttrList;
//       console.log(list.value);
//       // attrList.value = list.filter((item, index)=>{
//       //   return list.indexOf(item.title) === index;
//       // })
    
//       console.log("ATTR:IST ");
//       console.log(attrList.value.length)
//   },
//   {deep : true}
// );


</script>

<template>
  <div class="selected-list">
    <div class="mt-2">
      <ul style="width: 20rem; flex-wrap: nowrap;">
        <h3>내가 선택한 여행지</h3>
        <div class="selectedAttraction" v-for="(attr, index) in attrList">
          {{ attr.title }}
          <AttractionItem
            :title="attr.title"
            :startDate="attr.startDate"
            :destDate="attr.destDate"
            description=""
            :index="index"
            :enableSelected="false"
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
