<script setup>
import { onMounted, ref, watch, computed } from "vue";
import AttractionItem from "./AttractionItem.vue";
import { useAttrStore } from "@/stores/schedule";

const { getAttrList } = useAttrStore();
//const store = ("attrStore");

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
