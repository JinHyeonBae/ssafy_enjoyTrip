<script setup>
import AttractionItem from "./AttractionItem.vue";
import InfiniteLoading from "v3-infinite-loading";
import "v3-infinite-loading/lib/style.css";

import { ref, watch, onMounted, provide, inject } from "vue";
import { getAttrtions } from "@/api/schedule";

let attrList = ref([]);
let page = 1;

const load = async ($state) => {
  console.log("loading...");

  const size = import.meta.env.VITE_ATTR_LIST_SIZE;
  const start = page * size - size;

  console.log(start);

  try {
    getAttrtions(
      {
        sido: 3,
        start: start,
        listsize: size,
      },
      ({ data }) => {
        console.log(data);
        //console.log("ATTRLIST : " + response.data);

        const json = data;

        if (json.length < 10) $state.complete();
        else {
          attrList.value.push(...json);
          $state.loaded();
        }
        page++;
      },
      (error) => {
        console.log(error);
      }
    );
  } catch (error) {
    $state.error();
  }
};
</script>

<template>
  <div class="input-group mb-3">
    <span class="input-group-text" id="inputGroup-sizing-default">검색</span>
    <input
      type="text"
      class="form-control"
      aria-label="Sizing example input"
      aria-describedby="inputGroup-sizing-default"
    />
  </div>
  <div class="attr-list">
    <div v-for="attraction in attrList">
      <AttractionItem
        :attraction="attraction.title"
        date="2023-10-22"
        :description="attraction.overview"
      />
    </div>
  </div>
  <infinite-loading @infinite="load"></infinite-loading>
</template>

<style scoped>
.input-group {
  width: 100%;
}
.attr-list {
  overflow-y: scroll;
  overflow-x: hidden;
}
</style>
