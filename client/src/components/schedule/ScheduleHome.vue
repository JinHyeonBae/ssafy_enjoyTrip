<script setup>
import { ref, watch, onMounted, provide } from "vue";
import ScheduleSideBar from "./ScheduleSideBar.vue";
import ScheduleMap from "./ScheduleMap.vue";
import SendButton from "./SendButton.vue";

import { useRoute, useRouter } from "vue-router";
//import { storeToRefs } from "pinia";
import { useAttrStore } from "@/stores/schedule";

const store = useAttrStore();
//const { setSidoCode } = storeToRefs(store);

const { dataObj } = history.state; // 이렇게 받는다.

if (!!dataObj) {
  console.log(dataObj);
  store.setSidoCode(dataObj.sido);
}
</script>

<template>
  <div class="sch-container">
    <ScheduleSideBar :sido="sido" class="item"></ScheduleSideBar>
    <ScheduleMap class="item"></ScheduleMap>
  </div>
  <SendButton></SendButton>
</template>

<style scope>
body {
  min-height: 100vh;
  min-height: -webkit-fill-available;
}

html {
  height: -webkit-fill-available;
}

.sch-container {
  display: flex;
  height: 100vh;
  width: 100%;
  flex-direction: row;
}

.item:nth-child(1) {
  flex-grow: 1;
}

.item:nth-child(2) {
  flex-grow: 4;
}
</style>
