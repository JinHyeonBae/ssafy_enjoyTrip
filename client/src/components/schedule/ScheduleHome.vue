<script setup>
import { ref, watch, onMounted, provide } from "vue";
import ScheduleSideBar from "./ScheduleSideBar.vue";
import ScheduleMap from "./ScheduleMap.vue";
import SendButton from "./SendButton.vue";

// const { sido } = defineProps({
//   sido: Number,
// });

</script>

<template>
  <div class="sch-container">
    <ScheduleSideBar class="item"></ScheduleSideBar>
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
  height: 100%;
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
